package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
    public static String getTestData(String key) throws IOException, org.json.simple.parser.ParseException {
        String testdata;
        return testdata=(String)getJsonData().get(key);
    }

    public static JSONObject getJsonData() throws IOException, org.json.simple.parser.ParseException {
        File filename=new File("resources//TestData//testdata.json");
      //  String json=Files.readAllLines(Path.of("resources//TestData//testdata.json")).toString();
       // Files.readString(Path.of("resources//TestData//testdata.json"),"UTF-8");
      //  String json= FileUtils.readFileToString(filename,"UTF-8");

        String json=FileUtils.readFileToString(filename,"UTF-8");

        Object obj=new JSONParser().parse(json);

        JSONObject jsonObject=(JSONObject) obj;

        return jsonObject;
    }

    public static JSONArray getJsonArray(String key) throws IOException, ParseException {
        JSONObject jsonObject=getJsonData();
        JSONArray jsonArray=(JSONArray) jsonObject.get(key);
        return jsonArray;
    }

    public static Object getJsonArrayData(String key,int index) throws IOException, ParseException {
        JSONArray languages=getJsonArray(key);
        return languages.get(index);
    }

}
