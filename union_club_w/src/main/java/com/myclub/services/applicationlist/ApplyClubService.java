package com.myclub.services.applicationlist;

import java.util.List;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.ApplicationList;
import com.myclub.entities.ApplicationListKey;
import com.myclub.entities.Club;
import com.myclub.entities.Member;
import com.myclub.exceptions.applicationlist.AlreadyAppliedException;
import com.myclub.exceptions.applicationlist.PresidentApplyedOtherClubException;
import com.myclub.repositories.ApplicationListRepository;
import com.myclub.repositories.ClubRepository;
import com.myclub.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("applyClubService")
@Import(RepositoriesConfig.class)
public class ApplyClubService {
    

    @Autowired
    private ApplicationListRepository applicationListRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ClubRepository clubRepository;

    @Transactional
    public ApplicationList applyClub(String mid, String cname){ // 그냥 boolean이나 void로 할까?
        ApplicationList newApply = new ApplicationList();
        Member member=memberRepository.findById(mid).get();
        Club club=clubRepository.findById(cname).get();
        
        // 동아리 신청한 사람이 이미 다른 동아리의 회장인 경우
        List<Club> list = clubRepository.findByPresident(member.getId());
        if(list.size()> 0){
            throw new PresidentApplyedOtherClubException();
        }

        newApply.setMid(member);
        newApply.setCname(club);
        newApply.setTime("hhhhh");

        
        ApplicationListKey newKey=new ApplicationListKey(member.getId(), club.getName());
        // 이미 신청했으면
        boolean applied = applicationListRepository.existsById(newKey);

        if(applied){
            throw new AlreadyAppliedException();
        }
        ApplicationList result = applicationListRepository.save(newApply);
        return result;
    }

}
