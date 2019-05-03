package tasks.merging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class SortListsMergerTest {
    private ArrayList<Integer> a;
    private ArrayList<Integer> b;
    private String expectedA;
    private String expectedB;

    public SortListsMergerTest(List<Integer> a, List<Integer> b, String s) {
        this.expectedA = s;
        this.a = new ArrayList<>(a);
        this.b = new ArrayList<>(b);
        this.expectedB = this.b.toString();
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5), "[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]"},
                {Arrays.asList(-100, 0, 3, 8, 44, 59), Arrays.asList(-5, -1), "[-100, -5, -1, 0, 3, 8, 44, 59]"},
                {Arrays.asList(1), Arrays.asList(0, 3, 4, 5), "[0, 1, 3, 4, 5]"},
                {Arrays.asList(), Arrays.asList(0, 3, 4, 5), "[0, 3, 4, 5]"},
                {Arrays.asList(), Arrays.asList(), "[]"},
                {Arrays.asList(1, 2), Arrays.asList(), "[1, 2]"},
                {Arrays.asList(1), Arrays.asList(), "[1]"},
                {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(-58), "[-58, 1, 2, 3, 4, 5]"},
                {Arrays.asList(2, 3, 8, 44, 59), Arrays.asList(-5, -1), "[-5, -1, 2, 3, 8, 44, 59]"},
                {Arrays.asList(6, 8, 9, 15, 88), Arrays.asList(1, 2, 3, 4, 5), "[1, 2, 3, 4, 5, 6, 8, 9, 15, 88]"},
        });
    }

    @Test
    public void merge() {
        SortListsMerger.merge(a, b);
        assertEquals(a.toString(), expectedA);
        assertEquals(b.toString(), expectedB);
    }
}
