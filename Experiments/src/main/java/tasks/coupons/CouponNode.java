package tasks.coupons;

class CouponNode {
    private static int countDays;
    private static int numberCoupons;

    private int multi;
    private CouponNode unchanged;
    private CouponNode changed;

    public CouponNode() {
        this(1, numberCoupons, 1);
    }

    private CouponNode(int numberBusy, int mult, int num) {
        this.multi = mult;

        if (num != countDays && mult != 0) {
            unchanged = new CouponNode(numberBusy, numberBusy, num + 1);
            if (numberBusy + 1 == numberCoupons)
                changed = new CouponNode(numberBusy + 1, 0, num + 1);
            else
                changed = new CouponNode(numberBusy + 1, numberCoupons - numberBusy, num + 1);
        }
    }

    public long countUnlucky() {
        if (unchanged == null && changed == null)
            return multi;

        return multi * (unchanged.countUnlucky() + changed.countUnlucky());
    }

    public long countAll() {
        return pow(numberCoupons, countDays);
    }

    public static void setCountDays(int countDays) {
        CouponNode.countDays = countDays;
    }

    public static void setNumberCoupons(int numberCoupons) {
        CouponNode.numberCoupons = numberCoupons;
    }

    private static long pow(int num, int power) {
        if (power == 1)
            return num;
        return num * pow(num, power - 1);
    }
}
