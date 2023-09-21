package org.statestreet.util;

import java.io.IOException;

public class RetrivingTextFromImage{

public static boolean retrivingTextFromImage(String imagePath,String textPath){
 boolean status = false;
 try {
     String projectPath = System. getProperty("user.dir");
     String python = "C:\\Users\\ideathon\\PycharmProjects\\pythonProject\\venv\\Scripts\\python.exe";
     String pythonFunction = projectPath+"\\src\\main\\java\\org\\statestreet\\py\\";
     String space = " ";

     String cmd = python+space+pythonFunction+"RetriveTextFromImage.py"+space+imagePath+space+textPath;
     Process process = Runtime.getRuntime().exec(cmd);
     status=true;
 } catch(Exception e){
     System.out.println("Exception occurred while retrieving image from text file");
 }
 return status;
}
public static void main(String args[]) throws IOException {
    String imagePath = System. getProperty("user.dir")+"\\src\\resource\\Balance-Sheet.jpg";
    String textPath = System. getProperty("user.dir")+"\\src\\resource\\Balance-Sheet.txt";
    retrivingTextFromImage(imagePath,textPath);

}
}
