package org.statestreet.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderUtil {

    public static List<String> getListOfFilesInFolder(String path){

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        List<String> filesInFolder = new ArrayList<>();
        if(listOfFiles!=null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    filesInFolder.add(listOfFile.getName());
                } else if (listOfFile.isDirectory()) {
                    System.out.println("Directory " + listOfFile.getName());
                }
            }
        }
        else return null;

        return filesInFolder;
    }
}
