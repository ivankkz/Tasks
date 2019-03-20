package data;

public class CustomNumber implements Comparable<CustomNumber> {
    private int num;
    private String numStr;

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

    @Override
    public String toString() {
        return num + " | " + numStr;
    }
}
