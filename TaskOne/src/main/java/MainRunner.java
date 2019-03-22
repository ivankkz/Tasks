import data.CustomArray;
import data.CustomArrayImpl;
import data.NumberUsingWords;
import thread.Adder;
import thread.CleanerMin;

import static java.lang.Thread.sleep;

public class MainRunner {
    public static void main(String[] args) {
        CustomArray<NumberUsingWords> data = new CustomArrayImpl<>();

        new CleanerMin<NumberUsingWords>(data).start();
        new Adder(data).start();
    }
}
