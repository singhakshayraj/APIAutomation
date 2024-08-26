package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String propertyReader(String filePath,String key){
        String value=null;

        try(InputStream input=new FileInputStream(filePath)) {
            Properties prop = new Properties();

            prop.load(input);

            value=prop.getProperty(key);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }
}
