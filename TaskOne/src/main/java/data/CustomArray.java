package data;

import java.util.TreeSet;

import static java.lang.Thread.sleep;

// E implements Comparable
public class CustomArray<E> {
    private TreeSet<E> data;

    public CustomArray() {
        this.data = new TreeSet<>();
    }

    public void add(E item) {
        synchronized (data) {
            data.add(item);
        }
    }

    public E getAndDeleteMin() {
        synchronized (data) {
            return data.pollFirst();
        }
    }
}
