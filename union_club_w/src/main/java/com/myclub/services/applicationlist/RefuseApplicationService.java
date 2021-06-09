package com.myclub.services.applicationlist;

import com.myclub.config.RepositoriesConfig;
import com.myclub.entities.ApplicationList;
import com.myclub.entities.ApplicationListKey;
import com.myclub.exceptions.applicationlist.ApplicationNotFoundException;
import com.myclub.repositories.ApplicationListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

// 회장은 지원자의 신청을 거절할 수 있다
@Service(value="refuseApplicationService")
@Import(RepositoriesConfig.class)
public class RefuseApplicationService {
    
    @Autowired
    private ApplicationListRepository applicationListRepository;

    public ApplicationList refuseApplication(String mid, String cname){
        ApplicationList refuseApply = null;
        ApplicationListKey key = new ApplicationListKey(mid, cname);


        refuseApply = applicationListRepository.findByKey(key).get(0);
        if(refuseApply == null){
            throw new ApplicationNotFoundException();
        }else{
            applicationListRepository.delete(refuseApply);
        }
        
        return refuseApply;
    }


}
