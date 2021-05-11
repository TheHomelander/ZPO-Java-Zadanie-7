package com.company;

import java.io.IOException;
import java.util.Scanner;

public class VectorHandler {
    private Vector firstVector = null;
    private Vector secondVector = null;

    public VectorHandler()
    {

    }

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

    public Vector getVectorFromUser( ) throws NumberFormatException
    {

            System.out.println("Wprowadz wartosci wektora oddzielone spacjami");

            Vector tv = new Vector();
            Scanner userScanner = new Scanner(System.in);
            String inputArray;
            String[] splitArrray;

            inputArray = userScanner.nextLine();
            splitArrray = inputArray.split(" ");

            for(String ts : splitArrray)
            {
                tv.getVectorElements().add(Integer.parseInt(ts));
            }
            tv.setVectorLength(tv.getVectorElements().size());
            return tv;



    }

    public static void main(String[] args) {
        while (true) {
            try {
                VectorHandler vectorHandler = new VectorHandler();
                final String filePathToWrite = "vectorSumResult.txt";
                System.out.println("Podaj dwa wektory tej samej długości: \n");

                vectorHandler.setFirstVector(vectorHandler.getVectorFromUser());
                vectorHandler.setSecondVector(vectorHandler.getVectorFromUser());

                vectorHandler.getFirstVector().addVectorToVector(vectorHandler.getSecondVector());
                System.out.println(vectorHandler.getFirstVector().getVectorElements().toString());
                FileHandler.writeToFile(vectorHandler.getFirstVector().getVectorElements().toString(), filePathToWrite);
                break;
            } catch (IOException ex)
            {
                System.out.println("IOException occured while writing to file and the program will shut down\n" + ex.getMessage());
                ex.printStackTrace(System.err);
            } catch (WektoryRoznejDlugosciException ex)
            {
                System.out.println(
                        "Długość pierwszego wektora to " + ex.getFirstVectorLength() +
                                ", a drugiego to " + ex.getSecondVectorLength() +
                                "\n" + ex +
                                "\nWprowadz wektory jeszcze raz:"
                );

                ex.printStackTrace(System.err);
            } catch (NumberFormatException ex)
            {
                // This Exception should be reworked
                // TODO: make new Exception based on NumberFormatException
                // After catching this exception there is a problem with looping back to linke 71/72
                System.out.println("illegal character in vector" + ex.getMessage());
                ex.printStackTrace(System.err);

            }
        }
    }
}
