package util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class NumberParserTest {

    @Test
    @Parameters(source = NumberParserData.class, method = "valueOf")
    public void valueOf(String line, int expected) {
        assertEquals(expected, NumberParser.valueOf(line));
    }
}
