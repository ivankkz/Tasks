package data;

public class NumberUsingWords implements Comparable<NumberUsingWords> {
    private int num;
    private String numStr;

    public NumberUsingWords(int num, String numStr) {
        this.num = num;
        this.numStr = numStr;
    }

    @Override
    public int compareTo(NumberUsingWords o) {
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
