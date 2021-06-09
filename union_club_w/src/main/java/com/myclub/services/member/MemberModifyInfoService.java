package com.myclub.services.member;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.myclub.entities.Member;
import com.myclub.exceptions.member.EmailRegexNotMatchException;
import com.myclub.exceptions.member.MemberAlreadyExistException;
import com.myclub.exceptions.member.MemberNotFoundException;
import com.myclub.exceptions.member.PreviousInformationIsInaccurateException;
import com.myclub.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberModifyInfoService {
    
    @Autowired
    private MemberRepository memberRepository;


    @Transactional(rollbackFor = {SQLException.class})
    public Member modifyMemberInfoSvc(MemberModifyInfoRequest request){
        Member previousInfo = null;

        try{
            previousInfo = memberRepository.findById(request.getPreviousId()).get();
        }catch(NoSuchElementException e){
            throw new MemberNotFoundException();
        }
        
        // 기존 정보를 잘못 입력했을 경우(하나라도 false인 경우)
        if(
            !previousInfo.getId().equals(request.getPreviousId()) ||
            !previousInfo.getPassword().equals(request.getPreviousPassword()) ||
            !previousInfo.getName().equals(request.getPreviousName()) ||
            !previousInfo.getAddress().equals(request.getPreviousAddress()) ||
            !previousInfo.getEmail().equals(request.getPreviousEmail())
        ){
            throw new PreviousInformationIsInaccurateException();
        }


        Member newInfo = new Member(
            request.getNewId(),
            request.getNewPassword(),
            request.getNewName(),
            request.getNewAddress(),
            request.getNewEmail()
        );

        // 새로 바꾸려는 아이디가 이미 존재할 때
        if(memberRepository.existsById(newInfo.getId())){
            throw new MemberAlreadyExistException();
        }

        // 이메일이 이상할 때
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?"); //~.com, ~.ac.kr 등
        Matcher matcher = pattern.matcher(newInfo.getEmail());
        if(!matcher.matches()){ //이메일이 정규표현식에 어긋날 때
            throw new EmailRegexNotMatchException();
        }
        // 아이디(primary key)가 바뀌면 update가 아니라 insert로 동작한다
        memberRepository.save(newInfo); // update
        return newInfo;
    }
    

}
