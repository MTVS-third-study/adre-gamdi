package com.ohgiraffers.adregamdi.common;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.adregamdi", annotationClass = Mapper.class)
public class MybatisConfiguration {
}