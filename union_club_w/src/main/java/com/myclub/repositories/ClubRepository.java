package com.myclub.repositories;

import java.util.List;
import java.util.Optional;

import com.myclub.entities.Club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, String> {
    
    List<Club> findByPresident(String president);
    Optional<Club> findById(String id);
    <S extends Club> S save(S entity);
}
