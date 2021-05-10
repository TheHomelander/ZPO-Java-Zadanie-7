package com.company;

public class WektoryRoznejDlugosciException extends Exception{
    private Integer firstVectorLength;
    private Integer secondVectorLength;

    public WektoryRoznejDlugosciException(Integer sizeOne, Integer sizeTwo, String msg)
    {
        super(msg);
        firstVectorLength = sizeOne;
        secondVectorLength = sizeTwo;
    }

    public Integer getFirstVectorLength() { return firstVectorLength; }

    public void setFirstVectorLength(Integer firstVectorLength) {
        this.firstVectorLength = firstVectorLength;
    }

    public Integer getSecondVectorLength() {
        return secondVectorLength;
    }

    public void setSecondVectorLength(Integer secondVectorLength) {
        this.secondVectorLength = secondVectorLength;
    }


}
