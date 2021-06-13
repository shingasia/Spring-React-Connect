package com.myclub.services.applicationlist;

import java.util.NoSuchElementException;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.ApplicationList;
import com.myclub.entities.ApplicationListKey;
import com.myclub.entities.MemberClubPair;
import com.myclub.entities.MemberClubPairKey;
import com.myclub.exceptions.applicationlist.ApplicationNotFoundException;
import com.myclub.exceptions.applicationlist.UnauthorizedException;
import com.myclub.exceptions.memberclubpair.DuplicationMemberClubPairException;
import com.myclub.repositories.ApplicationListRepository;
import com.myclub.repositories.ClubRepository;
import com.myclub.repositories.MemberClubPairRepository;
import com.myclub.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 회장이 새로운 지원을 받으면 member_club 테이블에 추가
@Service(value="acceptApplicationService")
@Import(RepositoriesConfig.class)
public class AcceptApplicationService {

    @Autowired
    private ApplicationListRepository applicationListRepository;
    @Autowired
    private MemberClubPairRepository memberClubPairRepository;
    @Autowired
    private ClubRepository clubRepository;

    @Transactional
    public MemberClubPair acceptApplication(String acceptor, String mid, String cname){
        ApplicationList apply = null;
        ApplicationListKey akey = new ApplicationListKey(mid, cname);

        MemberClubPair mcp = null;
        MemberClubPairKey mcpKey = new MemberClubPairKey(mid, cname);
        
        
        boolean mcpExist = memberClubPairRepository.existsById(mcpKey);
        try{
            apply = applicationListRepository.findById(akey).get();
        }catch(NoSuchElementException e){
            throw new ApplicationNotFoundException();
        }
        String pName = clubRepository.findById(cname).get().getPresident();


        if(apply == null){
            throw new ApplicationNotFoundException();
        }else if(mcpExist){ // 이미 해당 동아리에 있는 회원이 중복으로 지원한 경우
            throw new DuplicationMemberClubPairException();
        }else{ // 여기서 이제 member_club 테이블에 추가
            if(acceptor.equals(pName)){ // 승인하는 자가 회장인지 확인
                mcp = new MemberClubPair();
                mcp.setMid(apply.getMember());
                mcp.setCname(apply.getClub());
                memberClubPairRepository.save(mcp); // member_club에 추가하고
                
                
                applicationListRepository.delete(apply);// application_list에서 삭제하고
            }else{
                throw new UnauthorizedException();
            }
        }

        return mcp;
    }
    
}
