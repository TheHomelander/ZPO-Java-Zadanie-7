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


    public List<Integer> getVectorElements()
    {
        return vectorElements;
    }

    public void setVectorElements(List<Integer> vectorElements)
    {
        this.vectorElements = vectorElements;
    }


    public boolean compareVectorTo(Vector tw)
    {
        try
        {
            final Integer firstVectorLength = this.vectorElements.size();
            final Integer secondVectorLength = tw.vectorElements.size() ;

            if (firstVectorLength.compareTo(secondVectorLength) != 0)
                throw new WektoryRoznejDlugosciException(firstVectorLength, secondVectorLength, "Vector lengths are not equal inside Vector.compareVectorTo");

            return true;
        }
        catch (WektoryRoznejDlugosciException ex)
        {
            System.out.println(
                            "Długość pierwszego wektora to " + ex.getFirstVal() +
                            ", a drugiego to " + ex.getSecondVal() +
                            "\n" + ex +
                            "\nWprowadz wektory jeszcze raz:"
                              );
        }
        return false;
    }

    public boolean compareVectorLengthTo(Vector component) throws NullPointerException
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
        catch ( UnsupportedOperationException e) // to wyrzucić
        {
            System.out.println("Error inside Vector.addVector: target list doesn't support get() method");
        }
        catch ( ClassCastException e) // delete me
        {
            System.out.println("Error inside Vector.addVector: class of the specified element prevents it from being added to this list");
        }
        catch ( IllegalArgumentException e) // maybe delete me
        {
            System.out.println("Error inside Vector.addVector: illegal arguments inside get() method");
        }
        catch ( IndexOutOfBoundsException e)
        {
            System.out.println("Error inside Vector.addVector: index is out of bounds of the list size");
        }


        return false;
    }





}
