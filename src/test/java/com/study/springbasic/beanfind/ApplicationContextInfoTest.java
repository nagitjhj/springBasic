package com.study.springbasic.beanfind;

import com.study.springbasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    //junit5 부터 public 안써도됨 굳굳 왜지? 알아볼것
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void 모든_빈_찾기(){
        //모든 빈임 스프링의 모든 빈을 출력하는 것
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter 탭 하면 배열의 for문 자동생성해줌
        for (String beanDefinitionName : beanDefinitionNames) {
            //ctrl alt v
            Object bean = ac.getBean(beanDefinitionName);
            //soutv -> 변수명 찍어줌
            //soutm -> 메서드명 찍어줌
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력 - 우리가 등록한")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //빈꺼내기

            //ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
            //어떤 빈들이 등록되어있는지 확인 가능.

        }
    }
}
