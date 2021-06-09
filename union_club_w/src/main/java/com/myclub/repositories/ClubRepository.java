package com.myclub.repositories;

import java.util.List;

import com.myclub.entities.Club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, String> {
    
    List<Club> findByPresident(String president);

}
