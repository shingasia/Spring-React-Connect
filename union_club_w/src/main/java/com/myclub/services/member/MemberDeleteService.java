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
import org.springframework.transaction.annotation.Transactional;

@Service("memberDeleteService")
@Import(RepositoriesConfig.class)
public class MemberDeleteService {
    
    @Autowired
    private MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member deleteMember(String id, String password){

        try{
            Member obj = memberRepository.findById(id).get();
            if(!obj.getPassword().equals(password)){
                throw new IdAndPasswordNotMatchException();
            }
            memberRepository.delete(obj);
            return obj;
        }catch(NoSuchElementException | IllegalArgumentException e){ 
            throw new MemberNotFoundException();
        }
        
    }

}