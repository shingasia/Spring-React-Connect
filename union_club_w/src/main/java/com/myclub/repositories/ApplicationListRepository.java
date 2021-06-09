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
    List<ApplicationList> findByMid(Member mid);
    List<ApplicationList> findByCname(Club cname);
    boolean existsByKey(ApplicationListKey key);
    
    
    

    // Query 애너테이션으로 JPQL 또는 네이티브 SQL 쿼리를 사용해보자

    // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
    // User findUserByStatusAndName(Integer status, String name);

    // @Query(
    //     value = "SELECT * FROM Users ORDER BY id", 
    //     countQuery = "SELECT count(*) FROM Users", 
    //     nativeQuery = true)
    // Page<User> findAllUsersWithPagination(Pageable pageable);

    // @Override
    // default Optional<ApplicationList> findById(ApplicationListKey id) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

}
