package tasks;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TaskOneTest {

    @Test
    @Parameters(source = TaskOneData.class, method = "whoWinGame")
    public void whoWinGame(int[] deck, String expected) {
        assertEquals(expected, new TaskOne("Petya", "Vasya").whoWinGame(deck));
    }
}
