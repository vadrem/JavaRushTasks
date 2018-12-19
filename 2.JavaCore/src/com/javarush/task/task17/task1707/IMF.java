package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        //add your code here - добавь код тут
        IMF localimf = imf;
        if (localimf == null) {
            synchronized (IMF.class) {
                localimf = imf;
                if (localimf == null) {
                    imf = new IMF();
                    localimf = imf;
                }
            }
        }
        return localimf;
    }

    private IMF() {
    }
}
