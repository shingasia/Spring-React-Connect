package com.myclub.repositories;


import com.myclub.entities.MemberClubPair;
import com.myclub.entities.MemberClubPairKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberClubPairRepository extends JpaRepository<MemberClubPair, MemberClubPairKey> {
    
}
