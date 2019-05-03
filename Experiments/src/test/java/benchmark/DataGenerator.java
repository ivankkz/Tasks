package benchmark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    public static ArrayList<Integer> sortNumber(int count, int min, int max) {
        ArrayList<Integer> res = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            res.add(ThreadLocalRandom.current().nextInt(min, max));
        }

        Collections.sort(res);

        return res;
    }
}
