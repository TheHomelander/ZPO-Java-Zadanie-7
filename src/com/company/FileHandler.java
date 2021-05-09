package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandler {


    public static boolean writeToFile(String textToSave,String pathName) throws IOException
    {
            if(textToSave == null || pathName == null)return false;
            File objFile = new File(pathName);
            FileWriter writeToFileObj = new FileWriter(pathName);
            writeToFileObj.write(textToSave);
            writeToFileObj.close();
            return true;
    }

}
