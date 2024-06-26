package com.study.springbasic;

import com.study.springbasic.discount.DiscountPolicy;
import com.study.springbasic.discount.RateDiscountPolicy;
import com.study.springbasic.member.MemberRepository;
import com.study.springbasic.member.MemberService;
import com.study.springbasic.member.MemberServiceImpl;
import com.study.springbasic.member.MemoryMemberRepository;
import com.study.springbasic.order.OrderService;
import com.study.springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //걍 설정정보임..
public class AppConfig {
    // @Configuration AppConfig에 설정을 구성한다는 뜻
    //@Bean 스프링 컨테이너에 스프링 빈으로 등록한다는 뜻임!!


    //스프링 DI 적용시키기
//    @Bean(name = "mmm") //이렇게 이름 바꿀 수 있는데 바꾸지 말고 걍 쓰자
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
