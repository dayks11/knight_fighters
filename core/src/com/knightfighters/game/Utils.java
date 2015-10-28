package com.knightfighters.game;

import java.util.Random;

/**
 * Created by rdaykin on 22/10/2015.
 */
public class Utils {

    static Random random = new Random();

    // Return a random float within a specified range, inclusive
    public static float randRange(float min, float max)
    {
        return min + (random.nextFloat() * (max - min) );
    }

    // Return a random int within a specified range, inclusive
    public static int randRange(int min, int max)
    {

        return min + random.nextInt( (max - min) + 1);
    }

}
