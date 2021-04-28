package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vector {
    private List<Integer> vectorElements = new ArrayList<>();

    public Vector()
    {

    }


    protected boolean compareVectorTo(Vector tw){
        try {
            final Integer firstVectorLength = this.returnVectorLength();
            final Integer secondVectorLength = tw.returnVectorLength();

            if (firstVectorLength.compareTo(secondVectorLength) != 0)
                throw new WektoryRoznejDlugosciException(firstVectorLength, secondVectorLength);

            return true;
        }catch (WektoryRoznejDlugosciException ex)
        {
            System.out.println(
                                "Długość pierwszego wektora to " + ex.firstVal +
                                ", a drugiego to " + ex.secondVal +
                                "\nWprowadz wektory jeszcze raz:\n"
                              );
        }
        return false;
    }


    protected Integer returnVectorLength(){
        return vectorElements.size();
    }

    protected List<Integer> getVectorElements() {
        return vectorElements;
    }

    protected void setVectorElements(List<Integer> vectorElements) {
        this.vectorElements = vectorElements;
    }

    protected boolean addVectorElement(Integer myInt){
        return vectorElements.add(myInt);
    }

    protected String generateStringFromVector(){
        String ts = vectorElements.toString();
        return ts;
    }

    protected boolean getVectorFromUser(){


        try
        {
            System.out.println("Wprowadz wartosci wektora oddzielone spacjami");

            Scanner userScanner = new Scanner(System.in);
            String inputArray;
            String[] splitedArray = null;

            inputArray = userScanner.nextLine();
            splitedArray = inputArray.split(" ");

            for(String ts : splitedArray)
            {
                addVectorElement(Integer.parseInt(ts));
            }
            return  true;
        }
        catch (NumberFormatException e) {
            System.out.println("Error: vector consists of illegal characters");
            vectorElements.clear();
        }
        return false;
    }

    protected boolean addVectorTo(Vector component){
        final int vecSize = vectorElements.size();
        for(int i = 0 ; i < vecSize; i++)
        {
            vectorElements.set(i,vectorElements.get(i) + component.getVectorElements().get(i));
        }

        return true;
    }

    public static void main(String[] args) {
        Vector firstVector = new Vector();
        Vector secondVector = new Vector();
        FileHandler fh = new FileHandler();
        System.out.println("Podaj dwa wektory tej samej długości: \n");
        do
        {

            while (!firstVector.getVectorFromUser()) { }
            while (!secondVector.getVectorFromUser()) { }

        }while ( !firstVector.compareVectorTo(secondVector) );
        firstVector.addVectorTo(secondVector);
        fh.writeToFile(firstVector.generateStringFromVector());
        System.out.println(firstVector.generateStringFromVector());
    }



}
