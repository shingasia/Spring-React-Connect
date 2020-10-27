package com.myclub.services.member;

import java.util.NoSuchElementException;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.Member;
import com.myclub.exceptions.member.IdAndPasswordNotMatchException;
import com.myclub.exceptions.member.MemberNotFoundException;
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

    // ID로만 검색
    public Member searchMemberById(String id){
        Member member=memberRepository.findById(id).get();
        return member;
    }
    
    // ID, PASSWORD로 검색
    public Member searchMemberByIdAndPassword(String id, String password){
        Member member=null;
        try{
            member=memberRepository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new MemberNotFoundException();
        }
        
        if(!member.getPassword().equals(password)){
            throw new IdAndPasswordNotMatchException();
        }
        return member;
    }

}