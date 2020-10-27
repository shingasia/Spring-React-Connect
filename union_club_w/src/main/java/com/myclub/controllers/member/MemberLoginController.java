package com.myclub.controllers.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.myclub.config.ServiceConfig;
import com.myclub.entities.Member;
import com.myclub.exceptions.member.IdAndPasswordNotMatchException;
import com.myclub.exceptions.member.MemberNotFoundException;
import com.myclub.services.member.MemberSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Import(ServiceConfig.class)
public class MemberLoginController {
    
    @Autowired
    private MemberSearchService memberSearchService;


    @PostMapping(path="/member/loginmember", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member login(@RequestBody Map<String, Object> params, HttpSession session){
        // System.out.println(params.getClass().getName()); //java.util.LinkedHashMap
        // System.out.println(params.keySet()); // [id, password]
        Member mem=memberSearchService.searchMemberByIdAndPassword(params.get("id")+"", params.get("password")+"");
        
        session.setAttribute(mem.getId(), mem);
        return mem;
    }

    

}
