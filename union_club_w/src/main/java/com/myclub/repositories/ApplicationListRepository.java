package com.myclub.repositories;

import java.util.List;
import java.util.Optional;

import com.myclub.entities.ApplicationList;
import com.myclub.entities.ApplicationListKey;
import com.myclub.entities.Club;
import com.myclub.entities.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationListRepository extends JpaRepository<ApplicationList, ApplicationListKey> {
    
    // @Query("SELECT al FROM ApplicationList al WHERE al.mid = key.mid AND al.cname = key.cname") // 지금 이 방식이 2개가 검색됨
    // List<ApplicationList> findByKey(ApplicationListKey key);
    
    // @Query("SELECT a FROM ApplicationList a WHERE a.mid = :mid AND a.cname = :cname")
    // ApplicationList findByKey(@Param("mid") String mid, @Param("cname") String cname);

    // @Query(value = "SELECT * FROM application_list WHERE member_id = :mid AND club_name = :cname ", nativeQuery = true)
    // ApplicationList findByKey(@Param("mid") String mid, @Param("cname") String cname);

    // List<ApplicationList> findByMid(Member mid);
    // List<ApplicationList> findByCname(Club cname);
    // boolean existsByKey(ApplicationListKey key);
    <S extends ApplicationList> S save(S entity);
    Optional<ApplicationList> findById(ApplicationListKey id);
    boolean existsById(ApplicationListKey id);
    void deleteById(ApplicationListKey id);
    void delete(ApplicationList entity);
    
    

    // Query 애너테이션으로 JPQL 또는 네이티브 SQL 쿼리를 사용해보자
    /*

    */

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
