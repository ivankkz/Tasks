import model.Slot;
import model.SlotBig;

import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        printSlot(8,20);
        printSlotBig(8,20);
    }

    private static void printSlotBig(int k, int n) {
        SlotBig.setCountChance(n);
        SlotBig.setNumberParts(k);
        BigInteger res = new SlotBig(1, BigInteger.valueOf(k), 1).count();
        BigInteger pow = powBig(k, n);

        System.out.println("SlotBig: количество неудачных: " + res);
        System.out.println("SlotBig: количество всех     : " + pow);

    }

    private static void printSlot(int k, int n) {
        Slot.setCountChance(n);
        Slot.setNumberParts(k);
        long res = new Slot(1, k, 1).count();
        long pow = pow(k, n);

        System.out.println("Slot   : количество неудачных: " + res);
        System.out.println("Slot   : количество всех     : " + pow);
    }

    private static long pow(int num, int power) {
        if (power == 1)
            return num;
        return num * pow(num, power - 1);
    }

    private static BigInteger powBig(int num, int power) {
        if (power == 1)
            return BigInteger.valueOf(num);
        return BigInteger.valueOf(num).multiply(powBig(num, power - 1));
    }
}
