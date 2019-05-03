package tasks.coupons;

import java.math.BigInteger;

class CouponNodeBig {
    private static int countDays;
    private static int numberCoupons;

    private BigInteger multi;
    private CouponNodeBig unchanged;
    private CouponNodeBig changed;

    public CouponNodeBig() {
        this(1, BigInteger.valueOf(numberCoupons), 1);
    }

    private CouponNodeBig(int numberBusy, BigInteger mult, int num) {
        this.multi = mult;

        if (num != countDays && !this.multi.equals(BigInteger.ZERO)) {
            unchanged = new CouponNodeBig(numberBusy, BigInteger.valueOf(numberBusy), num + 1);
            if (numberBusy + 1 == numberCoupons)
                changed = new CouponNodeBig(numberBusy + 1, BigInteger.ZERO, num + 1);
            else
                changed = new CouponNodeBig(numberBusy + 1, BigInteger.valueOf(numberCoupons - numberBusy), num + 1);
        }
    }

    public BigInteger countUnlucky() {
        if (unchanged == null && changed == null)
            return multi;

        return multi.multiply(unchanged.countUnlucky().add(changed.countUnlucky()));
    }

    public BigInteger countAll() {
        return powBig(numberCoupons, countDays);
    }

    public static void setCountDays(int countDays) {
        CouponNodeBig.countDays = countDays;
    }

    public static void setNumberCoupons(int numberCoupons) {
        CouponNodeBig.numberCoupons = numberCoupons;
    }

    private static BigInteger powBig(int num, int power) {
        if (power == 1)
            return BigInteger.valueOf(num);
        return BigInteger.valueOf(num).multiply(powBig(num, power - 1));
    }
}
