package main.java.data;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

// E implements Comparable
public class CustomArray<E> {
    private TreeSet<E> data;

    public CustomArray() {
        this.data = new TreeSet<>();
    }

    public void add(E item){
        synchronized (data){
            data.add(item);
        }
    }

    public void deleteMin(){
        synchronized (data) {
            data.pollFirst();
        }
    }

}
