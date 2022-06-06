package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        return member.getGradle() == Gradle.VIP ? price * discountPercent / 100 : 0;
    }
}
