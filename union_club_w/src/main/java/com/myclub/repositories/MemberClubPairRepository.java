package com.myclub.repositories;


import java.util.List;
import java.util.Optional;

import com.myclub.entities.MemberClubPair;
import com.myclub.entities.MemberClubPairKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberClubPairRepository extends JpaRepository<MemberClubPair, MemberClubPairKey> { 
    Optional<MemberClubPair> findById(MemberClubPairKey id);
    <S extends MemberClubPair> S save(S entity);
    boolean existsById(MemberClubPairKey id);
}
