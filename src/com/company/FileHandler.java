package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    private File objFile = null;
    private final String pathName = "vectorSumResult.txt";

    private void createNewFileIO() {
        try
        {
            objFile = new File(pathName);
        }catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
    }

    protected boolean writeToFile(String textToSave)
    {
        try
        {
            createNewFileIO();
            FileWriter writeToFileObj = new FileWriter(pathName);
            writeToFileObj.write(textToSave);
            writeToFileObj.close();
            return true;
        }catch (IOException ex){
            System.out.println("Exception occured while writing to File " + ex);
        }
        return false;
    }




}
