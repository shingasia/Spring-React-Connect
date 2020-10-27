package com.myclub.controllers.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myclub.config.ServiceConfig;
import com.myclub.entities.Member;
import com.myclub.services.member.MemberRegisterRequest;
import com.myclub.services.member.MemberRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Import(ServiceConfig.class)
@RequestMapping(value="/member", method={RequestMethod.POST, RequestMethod.GET})
public class MemberJoinController {
    
    @Autowired
    private MemberRegisterService memberRegisterService;

    // consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"}
    // {"application/*"}
    @ResponseBody
    @RequestMapping(path="/joinmember", method={RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member registerMember(@RequestBody Map<String, Object> params){ // 변수 params는 java.util.LinkedHashMap 타입이다.

        HashMap<String, String> data = ((HashMap<String, String>)params.get("member"));
        
        MemberRegisterRequest newMemberRequest = new MemberRegisterRequest (
            data.get("id"),
            data.get("password"),
            data.get("confirmpassword"),
            data.get("name"),
            data.get("address"),
            data.get("email")
        );

        Member newMember = memberRegisterService.registerMember(newMemberRequest);
        
        return newMember;
        
    }

    // 얘는 잘 동작함
    @ResponseBody
    @RequestMapping(path="/jointest", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member test(){
        Member obj=new Member("xxxx", "xxxx", "xxxx", "xxxx", "xxxx");
        return obj;
    }

    // 얘는 잘 동작함(Map, List, 중첩된 Object 잘 리턴 함...)
    // @ResponseBody
    // @RequestMapping(path="/nestedObject", method={RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    // public Map<String, Object> nextedObject1(){
    //     HashMap<String, Object> obj = new HashMap<>();
    //     obj.put("Sera", new Member("Sera", "Sera", "Sera", "Sera", "Sera"));
    //     obj.put("Kitty", new Member("Kitty", "Kitty", "Kitty", "Kitty", "Kitty"));
    //     List<Member> list = new ArrayList<>();
    //     list.add(new Member("Jeky", "Jeky", "Jeky", "Jeky", "Jeky"));
    //     list.add(new Member("Konta", "Konta", "Konta", "Konta", "Konta"));
    //     obj.put("list", list);
    //     return obj;
    // }
    

}
