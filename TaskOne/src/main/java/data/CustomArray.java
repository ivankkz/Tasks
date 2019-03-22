package data;

public interface CustomArray<E extends Comparable<E>> {
    void add(E item);
    E getAndDeleteMin();
}
