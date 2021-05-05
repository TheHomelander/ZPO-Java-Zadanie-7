package com.company;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class VectorHandler {
    private Vector firstVector = null;
    private Vector secondVector = null;

    public VectorHandler(){}

    public VectorHandler(Vector firstVector, Vector secondVector)
    {
        this.firstVector = firstVector;
        this.secondVector = secondVector;
    }

    public Vector getFirstVector()
    {
        return firstVector;
    }

    public void setFirstVector(Vector firstVector)
    {
        this.firstVector = firstVector;
    }

    public Vector getSecondVector()
    {
        return secondVector;
    }

    public void setSecondVector(Vector secondVector)
    {
        this.secondVector = secondVector;
    }

    public boolean getVectorFromUser( Vector tv )
    {
        try
        {
            System.out.println("Wprowadz wartosci wektora oddzielone spacjami");

            Scanner userScanner = new Scanner(System.in);
            String inputArray;
            String[] splitArrray;

            inputArray = userScanner.nextLine();
            splitArrray = inputArray.split(" ");

            for(String ts : splitArrray)
            {
                tv.getVectorElements().add(Integer.parseInt(ts));
            }
            return  true;
        }
        catch (NumberFormatException e) // runtime
        {
            System.out.println("Error inside getVectorFromUser: vector consists of illegal characters");
        }
        catch (NoSuchElementException e) // runtime
        {
            System.out.println("Error inside getVectorFromUser: No line found to read");
        }
        catch (IllegalStateException e) // runtime
        {
            System.out.println("Error inside getVectorFromUser: Scanner is closed");
        }
        catch (PatternSyntaxException e) // runtime
        {
            System.out.println("Error inside getVectorFromUser: Invalid syntax inside split method");
        }

        tv.getVectorElements().clear();
        return false;
    }

    public static void main(String[] args) {
        try
        {
            VectorHandler vectorHandler = new VectorHandler(new Vector(), new Vector());
            FileHandler fh = new FileHandler();
            final String readFilePath = "vectorSumResult.txt";

            System.out.println("Podaj dwa wektory tej samej długości: \n");
            do
            {

                while (!vectorHandler.getVectorFromUser(vectorHandler.getFirstVector())) { }

                while (!vectorHandler.getVectorFromUser(vectorHandler.getSecondVector())) { }

            } while (!vectorHandler.getFirstVector().compareVectorTo(vectorHandler.getSecondVector()));

            vectorHandler.getFirstVector().compareVectorLengthTo(vectorHandler.getSecondVector());
            fh.writeToFile(vectorHandler.getFirstVector().getVectorElements().toString(), readFilePath);
            System.out.println(vectorHandler.getFirstVector().getVectorElements().toString());
        }
        catch (IOException ex)
        {
            System.out.println("IOException occured");
        }
    }
}
