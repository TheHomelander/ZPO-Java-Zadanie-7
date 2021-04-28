package com.company;

import java.util.ArrayList;
import java.util.List;

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
            else if (firstVectorLength.compareTo(secondVectorLength) == 0)
                return true;
        }catch (WektoryRoznejDlugosciException ex){
            System.out.println("Wektory roznej dlugosci exception call");
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

    public static void main(String[] args) {
        // write your code here
    }

}
