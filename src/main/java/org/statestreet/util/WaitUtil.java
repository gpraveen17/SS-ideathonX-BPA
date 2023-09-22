package org.statestreet.util;

public class WaitUtil {

    public static void sleepFor(long miiliseconds){
        try {
            Thread.sleep(miiliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
