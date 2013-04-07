package net.dawnfirerealms.bukkit.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler {

	private Map<Class<?>, List<Field>> registeredClasses = new LinkedHashMap<Class<?>, List<Field>>();
	private File configFolder;

	public ConfigHandler(File configFolder) {
		this.configFolder = configFolder;
	}
	
	public void loadConfiguration(Class<?> clazz) {
		String path;
		Config configAnno = clazz.getAnnotation(Config.class);
		if (configAnno != null)
			path = configAnno.path();
		else
			path = clazz.getSimpleName();
		loadConfiguration(path, clazz);
	}

	public void loadConfiguration(String path, Class<?> clazz) {
		File file = new File(configFolder, path + ".yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw (RuntimeException) new RuntimeException().initCause(e);
			}
		}

		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.options().pathSeparator('_');
		List<Field> fields = new ArrayList<Field>();
		for (Field field : clazz.getDeclaredFields()) {
			int mod = field.getModifiers();
			if (!Modifier.isStatic(mod)
					|| field.getAnnotation(CField.class) == null)
				continue;

			field.setAccessible(true);

			String lpath = field.getName();
			try {
				if (!config.contains(lpath))
					config.set(lpath, field.get(null));
				else
					field.set(null, config.get(lpath));

				fields.add(field);
			} catch (ReflectiveOperationException e) {
				throw (RuntimeException) new RuntimeException().initCause(e);
			}
		}
		try {
			config.save(file);
		} catch (IOException e) {
			throw (RuntimeException) new RuntimeException().initCause(e);
		}
		registeredClasses.put(clazz, fields);
	}

	public void saveInstance(String path, Object instance) {
		File file = new File(configFolder, path + ".yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw (RuntimeException) new RuntimeException().initCause(e);
			}
		}

		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.options().pathSeparator('_');
		config.set("type", instance.getClass().getName());
		for (Class<?> clazz = instance.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
			for (Field field : clazz.getDeclaredFields()) {
				if (field.getAnnotation(CField.class) == null)
					continue;

				field.setAccessible(true);

				String p = clazz.getName() + "_" + field.getName();
				try {
					config.set(p, field.get(null));
				} catch (ReflectiveOperationException e) {
					throw (RuntimeException) new RuntimeException().initCause(e);
				}
			}
		}
		try {
			config.save(file);
		} catch (IOException e) {
			throw (RuntimeException) new RuntimeException().initCause(e);
		}
	}

	public Object loadInstance(String path) {
		File file = new File(configFolder, path + ".yml");

		if (!file.exists())
			return null;

		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.options().pathSeparator('_');
		Class<?> clazz;
		Object instance;
		try {
			clazz = Class.forName(config.getString("type"));
			instance = clazz.newInstance();
		} catch (ReflectiveOperationException e) {
			throw (RuntimeException) new RuntimeException().initCause(e);
		}

		for (Class<?> nclazz = clazz; nclazz != null; nclazz = nclazz.getSuperclass()) {
			for (Field field : nclazz.getDeclaredFields()) {
				field.setAccessible(true);
				try {
					field.set(instance,config.get(nclazz.getSimpleName() + "_" + field.getName()));
				} catch (ReflectiveOperationException e) {
					throw (RuntimeException) new RuntimeException().initCause(e);
				}
			}
		}

		return instance;
	}

	public void cleanup() {
		for (Entry<Class<?>, List<Field>> entry : registeredClasses.entrySet()) {
			for (Field field : entry.getValue()) {
				Class<?> c = field.getType();
				if (c == boolean.class || c == int.class || c == short.class
						|| c == byte.class || c == long.class
						|| c == float.class || c == double.class
						|| c == char.class)
					continue;

				try {
					field.set(null, null);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
