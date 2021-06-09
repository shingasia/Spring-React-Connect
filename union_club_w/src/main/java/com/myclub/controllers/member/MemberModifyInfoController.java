package com.myclub.controllers.member;

import com.myclub.entities.Member;
import com.myclub.services.member.MemberModifyInfoRequest;
import com.myclub.services.member.MemberModifyInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberModifyInfoController {
    
    @Autowired
    private MemberModifyInfoService memberModifyInfoService;

    @PostMapping(path="/member/modifymember", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member modifyMemberInfoCtl(@RequestBody MemberModifyInfoRequest request){
        System.out.println(request);
        Member renewMember = memberModifyInfoService.modifyMemberInfoSvc(request);
        return renewMember;
    }

}
