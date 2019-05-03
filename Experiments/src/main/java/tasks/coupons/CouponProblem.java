package tasks.coupons;

import java.math.BigInteger;

/*
 * https://math.stackexchange.com/questions/379525/probability-distribution-in-the-coupon-collectors-problem
 * https://math.stackexchange.com/questions/963077/cdf-of-probability-distribution-with-replacement
 */
public class CouponProblem {
    private CouponNode headTree;
    private CouponNodeBig headTreeBig;

    public CouponProblem() {
    }

    public void updateCouponNode(int countDay, int numberCoupon) {
        CouponNode.setCountDays(countDay);
        CouponNode.setNumberCoupons(numberCoupon);
        headTree = new CouponNode();
    }

    public void updateCouponNodeBig(int countDay, int numberCoupon) {
        CouponNodeBig.setCountDays(countDay);
        CouponNodeBig.setNumberCoupons(numberCoupon);
        headTreeBig = new CouponNodeBig();
    }

    public long countUnlucky() {
        return headTree.countUnlucky();
    }

    public long countAll() {
        return headTree.countAll();
    }

    public BigInteger countUnluckyBig() {
        return headTreeBig.countUnlucky();
    }

    public BigInteger countAllBig() {
        return headTreeBig.countAll();
    }
}
