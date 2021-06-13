package com.myclub.services.member;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.Member;
import com.myclub.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@Import(RepositoriesConfig.class)
public class MemberSearchService {
    
    @Autowired
    private MemberRepository memberRepository;


    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member searchMemberById(String id){
        Member member=memberRepository.findById(id).get();
        return member;
    }

}