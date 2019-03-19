package main.java.data;

public class CustomNumber implements Comparable<CustomNumber> {
    private int num;
    private String numStr;

    public CustomNumber(String numStr) {
        this(18, numStr);
    }

    public CustomNumber(int num, String numStr) {
        this.num = num;
        this.numStr = numStr;
    }

    @Override
    public int compareTo(CustomNumber o) {
        return num - o.getNum();
    }

    public int getNum() {
        return num;
    }
}
