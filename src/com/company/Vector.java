package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vector {
    private List<Integer> vectorElements = new ArrayList<>();
    private int vectorLength;

    public Vector() { }

    public List<Integer> getVectorElements()
    {
        return vectorElements;
    }

    public void setVectorElements(List<Integer> vectorElements)
    {
        this.vectorElements = vectorElements;
        vectorLength = vectorElements.size();
    }

    public int getVectorLength() {
        return vectorLength;
    }

    public void setVectorLength(int vectorLength) {
        this.vectorLength = vectorLength;
    }

    public void areVectorLengthsEqual(Vector tw) throws WektoryRoznejDlugosciException
    {

            if(tw != null)
            {
                final Integer firstVectorLength = this.vectorElements.size();
                final Integer secondVectorLength = tw.vectorElements.size();

                if (vectorLength != tw.getVectorLength())
                    throw new WektoryRoznejDlugosciException(firstVectorLength, secondVectorLength, "Vector lengths are not equal");

            }

    }

    public boolean addVectorToVector(Vector component) throws WektoryRoznejDlugosciException
    {
            this.areVectorLengthsEqual(component);
            if(component == null)return false;

            for (int i = 0; i < vectorLength; i++)
            {
                vectorElements.set(i, vectorElements.get(i) + component.getVectorElements().get(i));
            }

        return true;
    }





}
