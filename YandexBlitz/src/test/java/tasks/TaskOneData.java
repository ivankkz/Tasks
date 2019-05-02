package tasks;

import static junitparams.JUnitParamsRunner.$;

public class TaskOneData {
    public static Object[] whoWinGame() {
        return $(
                $(new int[]{1, 2, 3}, "Petya"),
                $(new int[]{37, 3, 33}, "Petya"),
                $(new int[]{1, 9, 23, 45, 22, 4, 23, 10, 44, 81, 70}, "Petya"),
                $(new int[]{187, 99, 42, 43}, "Petya"),
                $(new int[]{20000, 239, 10001, 999999, 10000, 20566, 29999}, "Vasya"),
                $(new int[]{1, 4, 2}, "Vasya")
        );
    }

}
