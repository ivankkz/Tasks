import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class SimpleTest {
    private ArrayList<Integer> a;
    private ArrayList<Integer> b;
    private String expectedA;
    private String expectedB;

    public SimpleTest(ArrayList<Integer> a, ArrayList<Integer> b, String sA) {
        this.expectedA = sA;
        this.expectedB = b.toString();
        this.a = a;
        this.b = b;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), "[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]"},
                {new ArrayList<Integer>(Arrays.asList(-100, 0, 3, 8, 44, 59)), new ArrayList<Integer>(Arrays.asList(-5, -1)), "[-100, -5, -1, 0, 3, 8, 44, 59]"},
                {new ArrayList<Integer>(Arrays.asList(1)), new ArrayList<Integer>(Arrays.asList(0, 3, 4, 5)), "[0, 1, 3, 4, 5]"},
                {new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<Integer>(Arrays.asList(-58)), "[-58, 1, 2, 3, 4, 5]"},
                {new ArrayList<Integer>(Arrays.asList(2, 3, 8, 44, 59)), new ArrayList<Integer>(Arrays.asList(-5, -1)), "[-5, -1, 2, 3, 8, 44, 59]"},
                {new ArrayList<Integer>(Arrays.asList(6, 8, 9, 15, 88)), new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), "[1, 2, 3, 4, 5, 6, 8, 9, 15, 88]"}
        });
    }

    @Test
    public void merge() {
        Simple.merge(a, b);
        assertEquals(a.toString(), expectedA);
        assertEquals(b.toString(), expectedB);
    }
}