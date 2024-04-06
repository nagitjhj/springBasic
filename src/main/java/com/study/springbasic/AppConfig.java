package com.study.springbasic;


import com.study.springbasic.discount.DiscountPolicy;
import com.study.springbasic.discount.RateDiscountPolicy;
import com.study.springbasic.member.MemberRepository;
import com.study.springbasic.member.MemberService;
import com.study.springbasic.member.MemberServiceImpl;
import com.study.springbasic.member.MemoryMemberRepository;
import com.study.springbasic.order.OrderService;
import com.study.springbasic.order.OrderServiceImpl;

public class AppConfig {
    //메서드 명에서 역할이 드러나게 리팩터링 해준다
    

    //이렇게 하면 MemberService를 사용할때 MemoryMemberRepository를 사용할 수 있게 함
    //즉 MemberServiceImpl에서는 MemoryMemberRepository를 알 수 없다
    //생성자를 통해서 주입하는 것임 이것이!!!!!!!!!!!!생성자 주입!!!!!!!!!!!!!!!!!!!!
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    //리팩터링 단축키 ctrl alt M
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //이렇게 할인 정책을 변경해도 클라이언트는 수정할 필요가 없다!!!
    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
