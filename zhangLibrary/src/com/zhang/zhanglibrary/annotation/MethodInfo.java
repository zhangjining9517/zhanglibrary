package com.zhang.zhanglibrary.annotation;

public @interface MethodInfo {
	String auther() default "zhangjining@sina.com";
	String date();
	int version() default 1;
}
