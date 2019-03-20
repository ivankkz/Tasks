import data.CustomArray;
import data.CustomNumber;
import util.NumberParser;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MainRunner {
    public static void main(String[] args) {
        final CustomArray<CustomNumber> data = new CustomArray<>();

        Thread cleanerMin = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                    }

                    CustomNumber temp = data.getAndDeleteMin();
                    if (temp == null) {
                        System.out.println("The cleaner can't delete min element. Data is empty.");
                    } else {
                        System.out.println("The cleaner deleted min element. It is " + temp.toString());
                    }
                }
            }
        });
        cleanerMin.start();

        Thread scannerWord = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner sin = new Scanner(System.in);

                while (true) {
                    String temp = sin.nextLine();
                    try {
                        CustomNumber num = new CustomNumber(NumberParser.valueOf(temp), temp);
                        data.add(num);
                        System.out.println("The scanner add new element. It is " + num.toString());
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        scannerWord.start();
    }
}
