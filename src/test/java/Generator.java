import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    public static int[] numbers(int count, int min, int max) {
        int[] res = new int[count];

        for (int i = 0; i < count; i++) {
            res[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }

        return res;
    }
}
