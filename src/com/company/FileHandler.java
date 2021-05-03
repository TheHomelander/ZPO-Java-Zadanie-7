package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandler {

    private final String pathName = "vectorSumResult.txt";

    private void createNewFileIO()
    {
        try
        {
            File objFile = new File(pathName);
        }
        catch (NullPointerException ex)
        {
            System.out.println("Error inside FileHandler.createNewFileIO: Path name is NULL");
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
        }
        catch (IOException ex)
        {
            System.out.println("Exception occured while writing to File " + ex);
        }
        return false;
    }


}
