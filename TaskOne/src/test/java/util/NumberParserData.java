package util;

import static junitparams.JUnitParamsRunner.$;

public class NumberParserData {
    public static Object[] valueOf() {
        return $(
                $("one hundred twenty-three", 123),
                $("seventy two", 72),
                $("twelve", 12),
                $("twelve hundred", 1200),
                $("three hundred", 300),
                $("twelve thousand three hundred four", 12304),
                $("nine thousand nine hundred ninety nine", 9999)
        );
    }
}
