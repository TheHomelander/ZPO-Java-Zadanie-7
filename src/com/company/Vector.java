package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Vector {
    private List<Integer> vectorElements = new ArrayList<>();

    public Vector()
    {

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

    protected boolean compareVectorTo(Vector tw){
        try
        {
            final Integer firstVectorLength = this.returnVectorLength();
            final Integer secondVectorLength = tw.returnVectorLength();

            if (firstVectorLength.compareTo(secondVectorLength) != 0)
                throw new WektoryRoznejDlugosciException(firstVectorLength, secondVectorLength);

            return true;
        }
        catch (WektoryRoznejDlugosciException ex)
        {
            System.out.println(
                            "Długość pierwszego wektora to " + ex.firstVal +
                            ", a drugiego to " + ex.secondVal +
                            "\nWprowadz wektory jeszcze raz:"
                              );
        }
        return false;
    }


    protected String generateStringFromVector(){
        return vectorElements.toString();
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
        catch (NumberFormatException e)
        {
            System.out.println("Error inside getVectorFromUser: vector consists of illegal characters");
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Error inside getVectorFromUser: No line found to read");
        }
        catch (IllegalStateException e)
        {
            System.out.println("Error inside getVectorFromUser: Scanner is closed");
        }
        catch (PatternSyntaxException e)
        {
            System.out.println("Error inside getVectorFromUser: Invalid syntax inside split method");
        }

        vectorElements.clear();
        return false;
    }

    protected boolean addVectorTo(Vector component) // ADD TRY CATCH HERE
    {

        try
        {
            final int vecSize = vectorElements.size();
            for (int i = 0; i < vecSize; i++)
            {
                vectorElements.set(i, vectorElements.get(i) + component.getVectorElements().get(i));
            }

            return true;
        }
        catch ( UnsupportedOperationException e)
        {
            System.out.println("Error inside Vector.addVector: target list doesn't support get() method");
        }
        catch ( ClassCastException e)
        {
            System.out.println("Error inside Vector.addVector: class of the specified element prevents it from being added to this list");
        }
        catch ( NullPointerException  e)
        {
            System.out.println("Error inside Vector.addVector: NULL value inside vector");
        }
        catch ( IllegalArgumentException e)
        {
            System.out.println("Error inside Vector.addVector: illegal arguments inside get() method");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Error inside Vector.addVector: index is out of bounds of the list size");
        }


        return false;
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
