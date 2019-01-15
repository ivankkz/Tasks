import java.util.ArrayList;

public class Simple {
    static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        final int lenB = b.size();

        for (int indexB = 0,indexA = 0; indexB < lenB; indexA++) {
            if (indexA < a.size()) {
                if (a.get(indexA) > b.get(indexB)) {
                    a.add(indexA, b.get(indexB++));
                }
            } else {
                a.add(b.get(indexB++));
            }
        }
    }
}
