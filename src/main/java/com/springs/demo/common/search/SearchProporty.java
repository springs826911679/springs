package com.springs.demo.common.search;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SearchProporty {
    boolean inKeywords() default false;
    String linkEntityField() default "";
    String joinAttributeName() default "";
    String joinTargetAttributeName() default "";

}