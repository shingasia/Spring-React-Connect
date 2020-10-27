package com.myclub.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans(value = {
    @ComponentScan(basePackages = {"com.myclub.services.member"}),
    @ComponentScan(basePackages = {"com.myclub.services.club"}),
    @ComponentScan(basePackages = {"com.myclub.services.applicationlist"})
})
public class ServiceConfig {
    
}