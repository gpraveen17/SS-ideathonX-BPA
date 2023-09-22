package org.statestreet.util;

import java.io.IOException;
import java.util.Properties;

public class ApplicationPropertyUtil {

    public static Properties readPropertyFile(){
        Properties prop = new Properties();
        try{
            prop.load(ApplicationPropertyUtil.class.getClassLoader().getResourceAsStream("application.properties"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return  prop;
    }

    public static void main(String args[]){
        System.out.println(readPropertyFile().getProperty("dbUrl"));
    }

    public static String getProperty(String propertyName){
        return readPropertyFile().getProperty(propertyName);
    }

    public static String getDbUrlFromProperty(){
        return readPropertyFile().getProperty("dbUrl");
    }

    public static String getDbUserFromProperty(){
        return readPropertyFile().getProperty("user");
    }

    public static String getDbPasswordFromProperty(){
        return EncoderUtil.getDecodedString(readPropertyFile().getProperty("password"));
    }

    public static String getPythonExe(){
        return readPropertyFile().getProperty("python_exe");
    }
}
