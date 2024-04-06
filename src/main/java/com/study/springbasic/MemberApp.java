package com.study.springbasic;


import com.study.springbasic.member.Grade;
import com.study.springbasic.member.Member;
import com.study.springbasic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfigJavacode appConfig = new AppConfigJavacode();
//        MemberService memberService = appConfig.memberService();
        //AppConfig를 가져
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //memberService 이거 객체를 찾겠다 MemberService 반환타입은 이거 ctrl alt v
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
