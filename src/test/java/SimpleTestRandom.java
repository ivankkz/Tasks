import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleTestRandom {
    private ArrayList<Integer> a;
    private ArrayList<Integer> b;
    private final int countA = 100000;
    private final int countB = 100000;

    @Test
    public void merge() {
        int[] t = Generator.numbers(countA, -1000, 1000);
        int[] t2 = Generator.numbers(countB, -1000, 1000);

        Arrays.sort(t);
        Arrays.sort(t2);

        a = new ArrayList<>(countA);
        b = new ArrayList<>(countB);
        for (int i = 0; i < t.length; i++) {
            a.add(t[i]);
        }

        for (int i = 0; i < t2.length; i++) {
            b.add(t2[i]);
        }

        long startTime1 = System.nanoTime();
        Simple.merge(a, b);
        long finishTime1 = System.nanoTime();

        System.out.println("Время затраченное merge новый = " + Long.toString(finishTime1 - startTime1));
    }

    @Test
    public void merge2() {
        int[] t = Generator.numbers(countA, -1000, 1000);
        int[] t2 = Generator.numbers(countB, -1000, 1000);

        Arrays.sort(t);
        Arrays.sort(t2);

        a = new ArrayList<>(countA);
        b = new ArrayList<>(countB);
        for (int i = 0; i < t.length; i++) {
            a.add(t[i]);
        }

        for (int i = 0; i < t2.length; i++) {
            b.add(t2[i]);
        }

        long startTime1 = System.nanoTime();
        Simple.merge2(a, b);
        long finishTime1 = System.nanoTime();

        System.out.println("Время затраченное merge старый= " + Long.toString(finishTime1 - startTime1));
    }
}
