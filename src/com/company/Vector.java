package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vector {
    private List<Integer> vectorElements = new ArrayList<>();


    public Vector() { }

    public List<Integer> getVectorElements()
    {
        return vectorElements;
    }

    public void setVectorElements(List<Integer> vectorElements)
    {
        this.vectorElements = vectorElements;
    }


    public boolean areVectorLengthsEqual(Vector tw)
    {
        try
        {
            if(tw == null)return false;
            final Integer firstVectorLength = this.vectorElements.size();
            final Integer secondVectorLength = tw.vectorElements.size() ;

            if (firstVectorLength.compareTo(secondVectorLength) != 0)
                throw new WektoryRoznejDlugosciException(firstVectorLength, secondVectorLength, "Vector lengths are not equal");

            return true;
        }
        catch (WektoryRoznejDlugosciException ex)
        {
            System.out.println(
                                "Długość pierwszego wektora to " + ex.getFirstVectorLength() +
                                ", a drugiego to " + ex.getSecondVectorLength() +
                                "\n" + ex +
                                "\nWprowadz wektory jeszcze raz:"
                              );
            ex.printStackTrace(System.err);
        }
        return false;
    }

    public boolean addVectorToVector(Vector component)
    {
            if(component == null)return false;

            final int vecSize = vectorElements.size();
            for (int i = 0; i < vecSize; i++)
            {
                vectorElements.set(i, vectorElements.get(i) + component.getVectorElements().get(i));
            }

        return true;
    }





}
