package org.statestreet.util;
import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
public class OCRReader {
        public static void main (String[]args){
        System.setProperty("jna.library.path", "C:\\GIT\\JNA");
        Tesseract tesseract = new Tesseract();
        try {


            tesseract.setDatapath("C:\\GIT\\Tess4J");
            tesseract.setDatapath("C:\\GIT\\Tess4J\\lib");
            tesseract.setDatapath("C:\\GIT\\Tess4J\\lib\\win32-x86-64");

            // the path of your tess data folder
            // inside the extracted file
            String text = tesseract.doOCR(new File(""));
            //String text =  tesseract.doOCR(new File("C:\\GIT\\image.jpg"));

            // path of your image file
            System.out.print(text);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
    }


