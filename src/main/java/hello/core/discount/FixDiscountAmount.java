package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;

public class FixDiscountAmount implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        return member.getGradle() == Gradle.VIP?discountFixAmount:0;
    }
}
