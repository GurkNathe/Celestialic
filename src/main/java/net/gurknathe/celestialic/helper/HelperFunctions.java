package net.gurknathe.celestialic.helper;

import java.util.Random;

public class HelperFunctions {
    // Function from https://stackoverflow.com/questions/13279509/random-number-with-nonuniform-distributed
    public static float nextMyGaussian(Random r) {
        double d = -1000;
        while (d < -2) {
            // RANDOMis Java's normal Random() class.
            // The nextGaussian is normal give a value from -5 to +5?
            d = r.nextGaussian() * 2;
        }
        if (d > 4d) {
            return 1;
        } else if (d < 0.75) {
            d = 0.75;
        }

        return (float)(2.5 * (d + 2) / 5);
    }
}
