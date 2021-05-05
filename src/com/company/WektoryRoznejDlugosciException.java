package com.company;

public class WektoryRoznejDlugosciException extends Exception{
    private Integer firstVal;
    private Integer secondVal;

    public Integer getFirstVal() {
        return firstVal;
    }

    public void setFirstVal(Integer firstVal) {
        this.firstVal = firstVal;
    }

    public Integer getSecondVal() {
        return secondVal;
    }

    public void setSecondVal(Integer secondVal) {
        this.secondVal = secondVal;
    }

    public WektoryRoznejDlugosciException(Integer sizeOne, Integer sizeTwo, String msg)
    {
        super(msg);
        firstVal = sizeOne;
        secondVal = sizeTwo;
    }
}
