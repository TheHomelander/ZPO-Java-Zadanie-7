package com.company;

public class WektoryRoznejDlugosciException extends Exception{
    public WektoryRoznejDlugosciException(Integer sizeOne, Integer sizeSecond){
        System.out.println("Size first vector: " + sizeOne + "\nSize second vector: " + sizeSecond + "\n");
    }
}
