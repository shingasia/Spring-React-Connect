package com.myclub.services.applicationlist;

import com.myclub.config.RepositoriesConfig;
import com.myclub.repositories.ApplicationListRepository;
import com.myclub.repositories.MemberClubPairRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

// 회장이 새로운 지원을 받으면 member_club 테이블에 추가
@Service(value="acceptApplicationService")
@Import(RepositoriesConfig.class)
public class AcceptApplicationService {

    @Autowired
    private ApplicationListRepository applicationListRepository;
    @Autowired
    private MemberClubPairRepository memberClubPairRepository;
    
}
