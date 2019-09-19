import enums.Constants;

import java.io.*;
import java.util.Properties;

public class Prop {

    private final static String AbsoultePathToPropertiesFile = System.getProperty("user.dir") + "/src/main/resources/config/app.properties";

    private final static Properties property = new Properties();


    public static String getValue(Constants key) {

        String value = "";
        String FilePath = AbsoultePathToPropertiesFile;
        try (FileReader reader = new FileReader(FilePath)) {

            property.load(reader);
            value = property.getProperty(String.valueOf(key), "No such key  found");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    public static void putValue(String key, Object value) {

        try (FileWriter writer = new FileWriter(AbsoultePathToPropertiesFile)) {

            property.setProperty(key, value.toString());
            property.store(writer, "Successfully Added");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}