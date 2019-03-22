package util;

import java.util.HashMap;

public class NumberParser {
    private final static HashMap<String, Integer> numbers;
    private final static HashMap<String, Integer> factors;

    static {
        numbers = getNumbersMap();
        factors = getFactorsMap();
    }

    public static int valueOf(String s) throws NumberFormatException {
        String[] words = s.split("[ -]");
        int res = 0;
        int curr = 0;

        for (int i = 0; i < words.length; i++) {
            Integer temp = numbers.get(words[i]);
            if (temp != null) {
                curr += temp;
            } else if (curr != 0) {
                temp = factors.get(words[i]);
                if (temp != null) {
                    res += curr * temp;
                    curr = 0;
                } else {
                    throw new NumberFormatException("Unknown word: " + words[i]);
                }
            } else {
                throw new NumberFormatException("Error with word: " + words[i]);
            }
        }

        return res + curr;
    }

    private static HashMap<String, Integer> getNumbersMap() {
        HashMap<String, Integer> res = new HashMap<>();

        res.put("one", 1);
        res.put("two", 2);
        res.put("three", 3);
        res.put("four", 4);
        res.put("five", 5);
        res.put("six", 6);
        res.put("seven", 7);
        res.put("eight", 8);
        res.put("nine", 9);
        res.put("ten", 10);
        res.put("eleven", 11);
        res.put("twelve", 12);
        res.put("thirteen", 13);
        res.put("fourteen", 14);
        res.put("fifteen", 15);
        res.put("sixteen", 16);
        res.put("seventeen", 17);
        res.put("eighteen", 18);
        res.put("nineteen", 19);
        res.put("twenty", 20);
        res.put("thirty", 30);
        res.put("forty", 40);
        res.put("fifty", 50);
        res.put("sixty", 60);
        res.put("seventy", 70);
        res.put("eighty", 80);
        res.put("ninety", 90);
        res.put("one", 1);
        res.put("two", 2);
        res.put("three", 3);
        res.put("four", 4);
        res.put("five", 5);
        res.put("six", 6);
        res.put("seven", 7);
        res.put("eight", 8);
        res.put("nine", 9);
        res.put("ten", 10);
        res.put("eleven", 11);
        res.put("twelve", 12);
        res.put("thirteen", 13);
        res.put("fourteen", 14);
        res.put("fifteen", 15);
        res.put("sixteen", 16);
        res.put("seventeen", 17);
        res.put("eighteen", 18);
        res.put("nineteen", 19);
        res.put("twenty", 20);
        res.put("thirty", 30);
        res.put("forty", 40);
        res.put("fifty", 50);
        res.put("sixty", 60);
        res.put("seventy", 70);
        res.put("eighty", 80);
        res.put("ninety", 90);

        return res;
    }

    private static HashMap<String, Integer> getFactorsMap() {
        HashMap<String, Integer> res = new HashMap<>();

        res.put("hundred", 100);
        res.put("thousand", 1000);
        res.put("million", 1000000);

        return res;
    }
}
