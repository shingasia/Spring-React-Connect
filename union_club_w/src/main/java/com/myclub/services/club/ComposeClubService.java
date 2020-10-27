package com.myclub.services.club;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.Club;
import com.myclub.exceptions.club.DuplicateClubException;
import com.myclub.exceptions.member.MemberNotFoundException;
import com.myclub.repositories.ClubRepository;
import com.myclub.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service("composeClubService")
@Import(RepositoriesConfig.class)
public class ComposeClubService {
    
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private MemberRepository memberRepository;

    public void setClubRepository(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Club composeClub(Club club){
        
        if(clubRepository.existsById(club.getName())){ // 해당 이름의 클럽이 이미 존재하는 경우
            throw new DuplicateClubException();
        }else if(!memberRepository.existsById(club.getPresident())){ // 회장의 회원정보가 DB에 없는 경우
            throw new MemberNotFoundException();
        }


        Club newClub = clubRepository.save(club);
        return newClub;

    }

}
