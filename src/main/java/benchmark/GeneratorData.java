package benchmark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratorData {
    public static ArrayList<Integer> sortNumber(int count, int min, int max) {
        ArrayList<Integer> res = new ArrayList<>(count + 1);

        for (int i = 0; i < count; i++) {
            res.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }

        Collections.sort(res);

        return res;
    }
}
