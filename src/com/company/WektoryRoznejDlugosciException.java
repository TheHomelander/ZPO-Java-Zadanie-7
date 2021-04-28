package com.company;

public class WektoryRoznejDlugosciException extends Exception{
    protected Integer firstVal;
    protected Integer secondVal;
    public WektoryRoznejDlugosciException(Integer sizeOne, Integer sizeTwo){
        firstVal = sizeOne;
        secondVal = sizeTwo;
    }
}
