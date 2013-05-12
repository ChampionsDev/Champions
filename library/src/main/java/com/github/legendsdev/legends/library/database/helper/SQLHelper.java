package com.github.legendsdev.legends.library.database.helper;

import com.github.legendsdev.legends.library.database.SQLDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YoshiGenius
 */
public class SQLHelper {
    
    private Connection connection = null;
    
    public SQLHelper(SQLDataSource.SQLDatabaseType source, String pathToDB) {
        switch (source) {
            case SQLITE:
                try {
                    Class.forName("org.sqlite.JDBC");
                    connection = DriverManager.getConnection("jdbc:sqlite:" + pathToDB);
                } catch (ClassNotFoundException | SQLException e) {}
                break;
            case MYSQL:
                break;
        }
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
    public List<Integer> getInts(String query, String name) {
        List<Integer> ints = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                ints.add(rs.getInt(name));
            }
        } catch (SQLException e) {}
        return ints;
    }
    
    public int getInt(String query, String name) {
        return getInts(query, name).get(0);
    }
    
    public List<String> getStrings(String query, String name) {
        List<String> strings = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                strings.add(rs.getString(name));
            }
        } catch (SQLException e) {}
        return strings;
    }
    
    public String getFirstString(String query, String name) {
        return getStrings(query, name).get(0);
    }

}
