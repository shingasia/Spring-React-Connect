package com.myclub.services.club;

import java.util.NoSuchElementException;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.Club;
import com.myclub.exceptions.club.ClubNotFoundException;
import com.myclub.repositories.ClubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service("removeClubService")
@Import(RepositoriesConfig.class)
public class RemoveClubService {
    
    @Autowired
    private ClubRepository clubRepository;

    public Club removeClub(String name, String president){

        Club obj = clubRepository.findById(name).get();
        
        if(!(obj.getPresident().equals(president))){ // 동아리 이름과 회장 아이디가 일치하는지 체크
            throw new ClubNotFoundException();
        }
        
        clubRepository.delete(obj);
        return obj;
        
    }

}
