package com.study.springbasic.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    //컨포넌트 스캔 대상에서 제외할 애노테이션
}
