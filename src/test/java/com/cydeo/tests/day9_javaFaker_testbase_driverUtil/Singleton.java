package com.cydeo.tests.day9_javaFaker_testbase_driverUtil;

public class Singleton {

    private static String word;

    // create private constructor
    private Singleton(){}

    // create private static String
    // prevent access and provide a getter method



    public static String getWord(){
        if(word==null){
            System.out.println("First time call. Word object is null. "+
                    "Assigning value to it now!");
            word="something";
        }else{
            System.out.println("Word already has value.");
        }
        return word;
    }

}
