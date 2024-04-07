package com.study.springbasic.beanfind;

import com.study.springbasic.AppConfig;
import com.study.springbasic.member.MemberService;
import com.study.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void 빈_이름으로_조회(){
        //memberService 이름으로 빈 조회하기
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //조회한 빈이 특정 클래스의 인스턴스인지 확인하는 것
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    void 이름_없이_타입으로만_조회(){
        MemberService memberService = ac.getBean(MemberService.class);
        //이름뺴고 같은 타입이 여러개일때 상당히 곤란
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    void 구체타입으로_조회(){
        //이렇게 구체 타입으로 찾아도됨
        //벗,,, 역할에 의존하도록 해야하니까 인터페이스를 찾자
        //구체 타입 조회하면 변경시 유연성이 떨어진다
        //ctrl alt f10 실행임
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    void 빈이름으로_조회_실패(){
        //ac.getBean("xxxx", MemberService.class);
        //실패 캐이스 작성
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }

}
