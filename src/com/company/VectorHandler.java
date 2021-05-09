package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VectorHandler {
    private Vector firstVector = null;
    private Vector secondVector = null;

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
        catch (NumberFormatException e)
        {
            System.out.println("Exception: Input vector consists of illegal characters or is empty\n" +
                                e.getMessage());
            e.printStackTrace(System.err);
        }


        tv.getVectorElements().clear();
        return false;
    }

    public static void main(String[] args) {
        try
        {
            VectorHandler vectorHandler = new VectorHandler(new Vector(), new Vector());
            final String filePathToWrite = "vectorSumResult.txt";

            System.out.println("Podaj dwa wektory tej samej długości: \n");
            do
            {

                while ( !vectorHandler.getVectorFromUser( vectorHandler.getFirstVector() ) ) { }

                while ( !vectorHandler.getVectorFromUser( vectorHandler.getSecondVector() ) ) { }

            } while ( !vectorHandler.getFirstVector().compareVectorTo( vectorHandler.getSecondVector()) );

            vectorHandler.getFirstVector().addVectorToVector( vectorHandler.getSecondVector() );
            System.out.println( vectorHandler.getFirstVector().getVectorElements().toString() );
            FileHandler.writeToFile( vectorHandler.getFirstVector().getVectorElements().toString(), filePathToWrite );

        }
        catch (IOException ex)
        {
            System.out.println("IOException occured while writing to file and the program will shut down\n" + ex.getMessage());
            ex.printStackTrace(System.err);
        }

    }
}
