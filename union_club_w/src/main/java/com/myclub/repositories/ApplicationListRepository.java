package com.myclub.repositories;

import java.util.List;
import java.util.Optional;

import com.myclub.entities.ApplicationList;
import com.myclub.entities.ApplicationListKey;
import com.myclub.entities.Club;
import com.myclub.entities.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationListRepository extends JpaRepository<ApplicationList, ApplicationListKey> {
    
    List<ApplicationList> findByKey(ApplicationListKey key);
    List<ApplicationList> findByCname(Club cname);
    List<ApplicationList> findByMid(Member mid);

    // @Override
    // default Optional<ApplicationList> findById(ApplicationListKey id) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

}
