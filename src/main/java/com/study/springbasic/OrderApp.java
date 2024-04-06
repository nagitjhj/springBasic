package com.study.springbasic;


import com.study.springbasic.member.Grade;
import com.study.springbasic.member.Member;
import com.study.springbasic.member.MemberService;
import com.study.springbasic.order.Order;
import com.study.springbasic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    //로그 찍으려는데 안됨 이상하네
    public static void main(String[] args) {
//        AppConfigJavacode appConfig = new AppConfigJavacode();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
