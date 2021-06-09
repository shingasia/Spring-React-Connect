package com.myclub.repositories;

import java.util.List;
import java.util.Optional;

import com.myclub.entities.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    

    // [출처] -> https://dongdd.tistory.com/177
    // - save : entity를 저장하는 메소드(insert, update)
    // - flush : EntityManager의 내용을 DB에 동기화하는 메소드
    // - saveAndFlush : entity에 대한 저장 작업 후 flush
    // - delete : entity를 삭제하는 메소드(delete)
    // - deleteAll : DB의 모든 레코드를 persistence context로 읽어와 삭제하는 메소드
    // - deleteInBatch : persistence context로 읽어오지 않고 DB의 모든 레코드를 삭제하는 메소드
    // - findOne : primary key로 DB에서 Entity를 찾아오는 메소드(select)
    // - findAll : 모든 entity를 찾아오는 메소드(select)
    // - exists : primary key에 해당하는 entity가 존재하는 확인하는 메소드
    // - count : entity의 갯수를 확인하는 메소드

    // https://www.javaguides.net/2019/06/springboot-jparepository-example-tutorial.html
    // <- 거의 모든 메소드

    Optional<Member> findById(String id);
    List<Member> findByName(String name);
    <S extends Member> S save(S entity);
    void delete(Member entity);
    List<Member> findAll();
    boolean existsById(String id);


}