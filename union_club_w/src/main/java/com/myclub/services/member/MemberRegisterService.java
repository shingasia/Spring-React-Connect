package com.myclub.services.member;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.Member;
import com.myclub.exceptions.member.EmailRegexNotMatchException;
import com.myclub.exceptions.member.MemberAlreadyExistException;
import com.myclub.exceptions.member.PasswordAndPasswordConfirmDifferentException;
import com.myclub.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberRegisterService")
@Import(RepositoriesConfig.class)
public class MemberRegisterService {
    
    @Autowired
    private MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Transactional(rollbackFor={SQLException.class})
    public Member registerMember(MemberRegisterRequest memberRequest){

        // 비밀번호, 비밀번호확인이 일치하지 않을 때
        if(!memberRequest.getPassword().equals(memberRequest.getConfirmpassword())){
            throw new PasswordAndPasswordConfirmDifferentException();
        }

        // 이미 존재하는 아이디
        if(memberRepository.existsById(memberRequest.getId())){
            throw new MemberAlreadyExistException();
        }

        // 이메일이 이상할 때
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?"); //~.com, ~.ac.kr 등
        Matcher matcher = pattern.matcher(memberRequest.getEmail());
        if(!matcher.matches()){ //이메일이 정규표현식에 어긋날 때
            throw new EmailRegexNotMatchException();
        }

        Member newMember = new Member();
        newMember.setId(memberRequest.getId());
        newMember.setPassword(memberRequest.getPassword());
        newMember.setName(memberRequest.getName());
        newMember.setAddress(memberRequest.getAddress());
        newMember.setEmail(memberRequest.getEmail());

        memberRepository.save(newMember); //Entity 객체만 save 된다.
        return newMember;
    }


}