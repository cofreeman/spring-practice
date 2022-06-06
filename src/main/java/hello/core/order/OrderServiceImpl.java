package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //note 여기서 dip(dependency inversion principle)를 위반 함 왜 냐면 인터페이스 뿐만 아니라 구현체에도 의존하고 있기때문에
    //note 추상화에 의존할 뿐만 아니라 구체화에 의존,"역할(ROLE)에 의존하게 해야한다."
    //note 정책을 변경하기 위해 다른 구현체로 바꾸면 ocp 도 위
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
    //note 진짜 잘 지킨거임 나는 모르겠고 폴리시에 멤버 던지면 할인된 가격 알려줘
        int discountedPrice = discountPolicy.discount(memberRepository.findById(memberId), itemPrice);

        return new Order(memberId,itemName,itemPrice,discountedPrice);
    }
}
