package com.myclub.controllers.member;

import java.util.Map;

import com.myclub.config.ServiceConfig;
import com.myclub.entities.Member;
import com.myclub.services.member.MemberDeleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Import(ServiceConfig.class)
public class MemberDeleteController {
    
    @Autowired
    public MemberDeleteService memberDeleteService;

    @RequestMapping(path="/member/deletemember", method={RequestMethod.DELETE, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member deleteMember(@RequestBody Map<String, Object> params){
        
        System.out.println("deleteMember() 함수 이제 곧 호출됨");
        Member result = memberDeleteService.deleteMember(params.get("id")+"", params.get("password")+"");
        return result;
    }

}
