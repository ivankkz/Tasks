package model;

public class Slot {
    private static int countChance = 6;
    private static int numberParts = 4;

    private int multi;
    private Slot unchanged;
    private Slot changed;

    public Slot(int numberBusy, int mult, int num) {
        this.multi = mult;

        if (num != countChance && mult != 0) {
            unchanged = new Slot(numberBusy, numberBusy, num + 1);
            if (numberBusy + 1 == numberParts)
                changed = new Slot(numberBusy + 1, 0, num + 1);
            else
                changed = new Slot(numberBusy + 1, numberParts - numberBusy, num + 1);
        }
    }

    public long count() {
        if (unchanged == null && changed == null)
            return multi;

        return multi * (unchanged.count() + changed.count());
    }

    public static void setCountChance(int countChance) {
        Slot.countChance = countChance;
    }

    public static void setNumberParts(int numberParts) {
        Slot.numberParts = numberParts;
    }
}
