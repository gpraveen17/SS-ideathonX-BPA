package org.statestreet.core;

import java.awt.*;
import java.util.HashMap;
import static org.statestreet.util.ExtractImage.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

System.out.println("Hello SS-ideathonX Team, welcome to ::: " + args[0] );

        String imagePath = args[1];
        String inputTextPath = args[2];
        extractTextFromImage(imagePath, inputTextPath);
        Thread.sleep(15000);
        HashMap<String, HashMap<String,String>> mapList = readDataFromTextFile(inputTextPath);
        System.out.println("map : " + mapList);
    }
}