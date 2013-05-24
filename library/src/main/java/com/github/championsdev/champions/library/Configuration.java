/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library;

/**
 * @author B2OJustin
 */
public class Configuration {
    private String databaseType = "YAML";
    //YAML
    private String yamlConfigPath = "";

    private String defaultRace = "Default";
    private String defaultPrimaryClass = "Default";
    private String defaultSecondaryClass = "Default";
    private String expCurve = "L * 200";

    public static Configuration instance = new Configuration();

    public static Configuration getInstance() {
        return instance;
    }

    private Configuration() {
    }


    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getDefaultRace() {
        return defaultRace;
    }

    public void setDefaultRace(String defaultRace) {
        this.defaultRace = defaultRace;
    }

    public String getDefaultPrimaryClass() {
        return defaultPrimaryClass;
    }

    public void setDefaultPrimaryClass(String defaultPrimaryClass) {
        this.defaultPrimaryClass = defaultPrimaryClass;
    }

    public String getDefaultSecondaryClass() {
        return defaultSecondaryClass;
    }

    public void setDefaultSecondaryClass(String defaultSecondaryClass) {
        this.defaultSecondaryClass = defaultSecondaryClass;
    }

    public String getYamlConfigPath() {
        return yamlConfigPath;
    }

    public void setYamlConfigPath(String yamlConfigPath) {
        this.yamlConfigPath = yamlConfigPath;
    }

    public String getExpCurve() {
        return expCurve;
    }

    public void setExpCurve(String expCurve) {
        this.expCurve = expCurve;
    }
}
