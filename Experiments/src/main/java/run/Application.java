package run;

import tasks.coupons.CouponProblem;

public class Application {
    public static void main(String[] args) {
        CouponProblem problem = new CouponProblem();
        problem.updateCouponNode(20,8);

        System.out.println("количество неудачных: " + problem.countUnlucky());
        System.out.println("количество всех     : " + problem.countAll());
    }
}
