package util;

import java.util.HashMap;

public class NumberParser {
    private final static HashMap<String, Integer> numbers;
    private final static HashMap<String, Integer> multipliers;

    static {
        numbers = new HashMap<>();
        multipliers = new HashMap<>();

        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);
        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("forty", 40);
        numbers.put("fifty", 50);
        numbers.put("sixty", 60);
        numbers.put("seventy", 70);
        numbers.put("eighty", 80);
        numbers.put("ninety", 90);

        multipliers.put("hundred", 100);
        multipliers.put("thousand", 1000);
        multipliers.put("million", 1000000);
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
                temp = multipliers.get(words[i]);
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
}
