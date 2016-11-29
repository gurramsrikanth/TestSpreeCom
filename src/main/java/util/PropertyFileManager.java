package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by srikanth on 29/11/16.
 */
public class PropertyFileManager {

    public String readProperty(String fileName, String properyKey){
        String filePath = "";
        filePath = System.getProperty("user.dir")+"/src/main/resources/testData";

        Properties prop = new Properties();
        File file = new File(filePath+"/"+fileName);
        String propValue = "";
        try{
            FileInputStream fs = new FileInputStream(file);
            prop.load(fs);
            propValue = prop.getProperty(properyKey);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return propValue;
        }
    }
}
