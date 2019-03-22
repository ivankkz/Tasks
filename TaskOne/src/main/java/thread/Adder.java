package thread;

import data.CustomArray;
import data.NumberUsingWords;
import util.NumberParser;

import java.util.Scanner;

public class Adder extends Thread {
    private CustomArray<NumberUsingWords> data;

    public Adder(CustomArray<NumberUsingWords> data) {
        super(new Runnable() {
            @Override
            public void run() {
                Scanner sin = new Scanner(System.in);

                while (true) {
                    String temp = sin.nextLine();
                    try {
                        NumberUsingWords num = new NumberUsingWords(NumberParser.valueOf(temp), temp);
                        data.add(num);
                        System.out.println("The scanner add new element. It is " + num.toString());
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        this.data = data;
    }
}
