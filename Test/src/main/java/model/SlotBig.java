package model;

import java.math.BigInteger;

public class SlotBig {
    private static int countChance = 6;
    private static int numberParts = 4;

    private BigInteger multi;
    private SlotBig unchanged;
    private SlotBig changed;

    public SlotBig(int numberBusy, BigInteger mult, int num) {
        this.multi = mult;

        if (num != countChance && !this.multi.equals(BigInteger.ZERO)) {
            unchanged = new SlotBig(numberBusy, BigInteger.valueOf(numberBusy), num + 1);
            if (numberBusy + 1 == numberParts)
                changed = new SlotBig(numberBusy + 1, BigInteger.ZERO, num + 1);
            else
                changed = new SlotBig(numberBusy + 1, BigInteger.valueOf(numberParts - numberBusy), num + 1);
        }
    }

    public BigInteger count() {
        if (unchanged == null && changed == null)
            return multi;

        return multi.multiply(unchanged.count().add(changed.count()));
    }

    public static void setCountChance(int countChance) {
        SlotBig.countChance = countChance;
    }

    public static void setNumberParts(int numberParts) {
        SlotBig.numberParts = numberParts;
    }
}
