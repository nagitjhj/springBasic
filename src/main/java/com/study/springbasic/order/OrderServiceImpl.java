package com.study.springbasic.order;


import com.study.springbasic.discount.DiscountPolicy;
import com.study.springbasic.member.Member;
import com.study.springbasic.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //이렇게 하면 이제 DIP는 지킨 것....그런데 구체클래스를 어떻게 주입을 해줄까..? 다음시간에.....
//    private DiscountPolicy discountPolicy;

    //DIP를 지켜서 구체클래스를 주입하는 방법
    //생성자를 통해서 주입한다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //@Autowierd 사용하면 생성자에서 여러 의존관계도 한번에 주입받음
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
