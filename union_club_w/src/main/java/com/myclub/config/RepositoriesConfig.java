package com.myclub.config;

import com.myclub.repositories.MemberClubPairRepository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages = {"com.myclub.repositories"}) //excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberClubPairRepository.class)
public class RepositoriesConfig {
    
}