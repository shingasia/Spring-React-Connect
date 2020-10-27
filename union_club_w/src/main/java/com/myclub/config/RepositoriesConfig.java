package com.myclub.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.myclub.repositories"})
public class RepositoriesConfig {
    
}