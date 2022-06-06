package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountAmount;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final DiscountPolicy discountPolicy = new FixDiscountAmount();
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
    // 진짜 잘 지킨거임 나는 모르겠고 폴리시에 멤버 던지면 할인도ㅓㅣㄴ 가격 알려줘
        int discountedPrice = discountPolicy.discount(memberRepository.findById(memberId), itemPrice);

        return new Order(memberId,itemName,itemPrice,discountedPrice);
    }
}
