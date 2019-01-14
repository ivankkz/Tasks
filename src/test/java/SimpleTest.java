import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SimpleTest {
    private ArrayList<Integer> a;
    private ArrayList<Integer> b;

    @Test
    public void merge1() {
        a = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        b = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Simple.merge(a, b);
        assertEquals(a.toString(), "[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]");
    }

    @Test
    public void merge2() {
        a = new ArrayList<Integer>(Arrays.asList(-100, 0, 3, 8, 44, 59));
        b = new ArrayList<Integer>(Arrays.asList(-5, -1));
        Simple.merge(a, b);
        assertEquals(a.toString(), "[-100, -5, -1, 0, 3, 8, 44, 59]");
    }

    @Test
    public void merge3() {
        a = new ArrayList<Integer>(Arrays.asList(6, 8, 9, 15, 88));
        b = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Simple.merge(a, b);
        assertEquals(a.toString(), "[1, 2, 3, 4, 5, 6, 8, 9, 15, 88]");
    }

    @Test
    public void merge4() {
        a = new ArrayList<Integer>(Arrays.asList(1));
        b = new ArrayList<Integer>(Arrays.asList(0, 3, 4, 5));
        Simple.merge(a, b);
        assertEquals(a.toString(), "[0, 1, 3, 4, 5]");
    }

    @Test
    public void merge5() {
        a = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        b = new ArrayList<Integer>(Arrays.asList(-58));
        Simple.merge(a, b);
        assertEquals(a.toString(), "[-58, 1, 2, 3, 4, 5]");
    }

    @Test
    public void merge6() {
        a = new ArrayList<Integer>(Arrays.asList(2, 3, 8, 44, 59));
        b = new ArrayList<Integer>(Arrays.asList(-5, -1));
        Simple.merge(a, b);
        assertEquals(a.toString(), "[-5, -1, 2, 3, 8, 44, 59]");
    }

}