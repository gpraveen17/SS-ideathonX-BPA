package org.statestreet.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractImage {

    public static Map<String,Boolean> extractTextFromImage(String imagePath, String textPath) {
        Map<String,Boolean> fileStatus = new HashMap<>();
        boolean status = false;
        try {
            String projectPath = System.getProperty("user.dir");
            String python = ApplicationPropertyUtil.getPythonExe();
//            String python = "C:\\Users\\ideathon\\AppData\\Local\\Programs\\Python\\Python39\\python.exe";
            String pythonFunction = projectPath + "\\src\\main\\java\\org\\statestreet\\py\\";
            String space = " ";
            List<String> files = FolderUtil.getListOfFilesInFolder(imagePath);
            if (files != null) {
                for (String fileName : files) {
                    if(fileName.contains(".jpg")) {
                        String cmd = python + space + pythonFunction + "RetrieveTextFromImage.py" + space + imagePath + "\\" + fileName + space + textPath + "\\" + fileName.replace(".jpg","") + "_processed.txt";
                        System.out.println("Python Cmd : " + cmd);
                        Process process = Runtime.getRuntime().exec(cmd);
                        fileStatus.put(fileName,true);
                    }
                }
            }
            else
                System.out.println("No Image present to process");

            System.out.println("Data Extracted from image file successfully");
        } catch (Exception e) {
            System.out.println("Exception occurred while retrieving text from image file");
        }
        return fileStatus;
    }


    public static Map<String, Map<String, String>> readDataFromTextFile(String textFile) {
        Map<String, Map<String, String>> maplist = new HashMap<>();
        Map<String, String> assetMap = new HashMap<>();
        Map<String, String> liabilitiesMap = new HashMap<>();
        try {

            FileReader fr = new FileReader(textFile);
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            boolean assetFlag = true;
            while ((str = br.readLine()) != null) {

                if (str.contains("Liabilities")) {
                    assetFlag = false;
                }
                if (assetFlag) {
                    if (str.contains("$")) {
                        int index = 0;
                        char array[] = str.toCharArray();
                        for (int i = 0; i < array.length - 1; i++) {
                            if (array[i] == '$') {
                                index = i - 1;
                                break;
                            }
                        }
                        //String strList[] = str.split("$");
                        assetMap.put(str.substring(0, index), str.substring(index, str.length()));
                    }
                } else {
                    if (str.contains("$")) {
                        if (str.contains("$")) {
                            //String strList[] = str.split("$");
                            int index = 0;
                            char array[] = str.toCharArray();
                            for (int i = 0; i < array.length - 1; i++) {
                                if (array[i] == '$') {
                                    index = i - 1;
                                    break;
                                }
                            }
                            liabilitiesMap.put(str.substring(0, index), str.substring(index, str.length()));
                        }
                    }
                }
            }
            maplist.put("Asset", assetMap);
            maplist.put("Liabilities", liabilitiesMap);

        } catch (Exception e) {
            System.out.println(" Exception while reading Text file ");
        }
        //System.out.println("maplist : "+maplist);
        return maplist;
    }

}
