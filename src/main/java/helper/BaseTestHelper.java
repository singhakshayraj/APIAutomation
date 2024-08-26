package helper;

import java.io.File;
import java.util.Date;

public class BaseTestHelper {

    public static void CreateFolder(String path){
        File file=new File(path);
        if(!file.exists())
            file.mkdir();
        else
            System.out.println("Folder already exists");
    }
    public static String TimeStamp(){
        Date now=new Date();
        String Timestamp=now.toString().replace(":","-");
        return Timestamp;
    }
}
