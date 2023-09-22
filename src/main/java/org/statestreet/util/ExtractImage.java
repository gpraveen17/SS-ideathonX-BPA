package org.statestreet.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ExtractImage {

public static boolean extractTextFromImage(String imagePath,String textPath){
 boolean status = false;
 try {
     String projectPath = System. getProperty("user.dir");
     String python = "C:\\Users\\ideathon\\AppData\\Local\\Programs\\Python\\Python39\\python.exe";
     String pythonFunction = projectPath+"\\src\\main\\java\\org\\statestreet\\py\\";
     String space = " ";

     String cmd = python+space+pythonFunction+"RetriveTextFromImage.py"+space+imagePath+space+textPath;
     System.out.println("Python Cmd : "+cmd);
     Process process = Runtime.getRuntime().exec(cmd);
     status=true;
     System.out.println("Data Extracted from image file successfully");
 } catch(Exception e){
     System.out.println("Exception occurred while retrieving text from image file");
 }
 return status;
}
public static void main(String args[]) throws IOException, InterruptedException {

    String imagePath = System. getProperty("user.dir") + "\\src\\main\\resources\\Balance-Sheet.jpg";
    String textPath = System. getProperty("user.dir") + "\\src\\main\\resources\\Balance-Sheet12.txt";

    extractTextFromImage(imagePath, textPath);
    Thread.sleep(7000);
    HashMap<String, HashMap<String,String>> mapList = readDataFromTextFile(textPath);
    System.out.println("map : "+mapList);

}


public static HashMap<String, HashMap<String,String>> readDataFromTextFile(String textFile){
    HashMap<String,HashMap<String,String>> maplist = new HashMap<>();
    HashMap<String,String> assetMap = new HashMap<>();
    HashMap<String,String> liabilitiesMap = new HashMap<>();
    try {
        FileReader fr = new FileReader(textFile);
        BufferedReader br = new BufferedReader(fr);
        String str = "";
        boolean assetFlag = true;
        while((str=br.readLine())!=null){

            if(str.contains("Liabilities")){
                assetFlag=false;
            }
            if(assetFlag){
                if(str.contains("$")){
                    int index =0;
                    char array[] = str.toCharArray();
                    for(int i =0;i<array.length-1;i++){
                        if(array[i]=='$'){
                            index = i-1;
                            break;
                        }
                    }
                    //String strList[] = str.split("$");
                    assetMap.put(str.substring(0,index),str.substring(index,str.length()));
                }
            } else{
                if(str.contains("$")){
                    if(str.contains("$")){
                        //String strList[] = str.split("$");
                        int index =0;
                        char array[] = str.toCharArray();
                        for(int i =0;i<array.length-1;i++){
                            if(array[i]=='$'){
                                index = i-1;
                                break;
                            }
                        }
                        liabilitiesMap.put(str.substring(0,index),str.substring(index,str.length()));
                    }
                }
            }
        }
        maplist.put("Asset",assetMap);
        maplist.put("Liabilities",liabilitiesMap);

    }catch (Exception e ){
        System.out.println(" Exception while reading Text file ");
    }
    //System.out.println("maplist : "+maplist);
return maplist;
}
}
