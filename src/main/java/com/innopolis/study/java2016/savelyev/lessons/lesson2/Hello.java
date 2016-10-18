package com.innopolis.study.java2016.savelyev.test.lessons.lesson2;

import java.io.IOException;

/**
 * Created by User on 04.10.2016.
 */

public class Hello {
    public void doSome() throws IOException {
        System.out.println("генерим ошибку");
        int x=5;
        throw (new IOException("Аггггг"));
    }


    private void message () {
        try {
            doSome();
        } catch (IOException e) {
            System.out.println("ловим в меесаге !");
            // e.printStackTrace();
            // throw new RuntimeException(e);
            System.out.println(e);

        }
        System.out.println ("после трейса");
    }

    public static void main1 (String [] args) {
        System.out.println("HelloWorld!!!!");
        Hello  h = new Hello();
        h. message();
        for (int i=0;i<1000000;i++) {
            System.out.println(i);
        }
    }
}

