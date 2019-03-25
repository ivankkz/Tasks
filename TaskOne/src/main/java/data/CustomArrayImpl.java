package data;

import java.util.ArrayList;

public class CustomArrayImpl<E extends Comparable<E>> implements CustomArray<E> {
    private ArrayList<E> data;

    public CustomArrayImpl() {
        this.data = new ArrayList<>();
    }

    public void add(E item) {
        synchronized (data) {
            data.add(item);
        }
    }

    public E getAndDeleteMin() {
        synchronized (data) {
            E min = null;
            int iMin = -1;

            for (int i = 0, len = data.size(); i < len; i++) {
                E temp = data.get(i);
                if (min == null || temp.compareTo(min) < 0) {
                    min = temp;
                    iMin = i;
                }
            }

            if (min != null)
                data.remove(iMin);

            return min;
        }
    }
}
