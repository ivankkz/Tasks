package data;

import java.util.ArrayList;

public class CustomArrayImpl<E extends Comparable<E>> implements CustomArray<E> {
    private ArrayList<Integer> freeIndex;
    private ArrayList<E> data;

    public CustomArrayImpl() {
        this.data = new ArrayList<>();
        this.freeIndex = new ArrayList<>();
    }

    public void add(E item) {
        synchronized (data) {
            if (freeIndex.isEmpty()) {
                data.add(item);
            } else {
                int ind = freeIndex.get(freeIndex.size() - 1);
                freeIndex.remove(freeIndex.size() - 1);
                data.set(ind, item);
            }
        }
    }

    public E getAndDeleteMin() {
        synchronized (data) {
            E min = null;
            int iMin = -1;

            for (int i = 0, len = data.size(); i < len; i++) {
                E temp = data.get(i);
                if (temp != null && (min == null || min.compareTo(temp) > 0)) {
                    min = temp;
                    iMin = i;
                }
            }

            if (min != null)
                data.set(iMin, null);
            return min;
        }
    }
}
