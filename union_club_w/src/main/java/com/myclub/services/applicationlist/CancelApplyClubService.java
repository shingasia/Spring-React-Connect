package com.myclub.services.applicationlist;

import java.util.NoSuchElementException;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.ApplicationList;
import com.myclub.entities.ApplicationListKey;
import com.myclub.exceptions.applicationlist.AlreadyAppliedException;
import com.myclub.exceptions.applicationlist.ApplicationNotFoundException;
import com.myclub.repositories.ApplicationListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cancelApplyClubService")
@Import(RepositoriesConfig.class)
public class CancelApplyClubService {
    
    @Autowired
    private ApplicationListRepository applicationListRepository;


    @Transactional
    public ApplicationList cancelApplyClub(String mid, String cname){
        ApplicationList cancelApply=null;
        ApplicationListKey key = new ApplicationListKey(mid, cname);

        
        // if(applicationListRepository.findByKey(key).size()>=2){
        //     throw new AlreadyAppliedException();
        // }
        try{
            cancelApply = applicationListRepository.findById(key).get();
        }catch(NoSuchElementException e){
            throw new ApplicationNotFoundException();
        }



        if(cancelApply==null){
            throw new ApplicationNotFoundException();
        }else{
            applicationListRepository.delete(cancelApply);
        }
        return cancelApply;
    }
    

}
