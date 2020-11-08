package com.assignment.utils;

import java.util.Random;

public class TestUtils {

    public static String getRandomString()
    {
        Random random=new Random();
        int randInt=random.nextInt(10000);
        return Integer.toString(randInt);
    }

}
