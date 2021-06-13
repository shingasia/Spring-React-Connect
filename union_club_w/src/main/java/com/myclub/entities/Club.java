package com.myclub.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="club")
public class Club {
    
    @Id
    @Column(name="club_name")
    private String name;

    @Column(name="president_id")
    private String president;

    @Column(name="thema")
    private String thema;

    @Column(name="introduction")
    private String introduction;

    // Member와 Club 둘다 @JoinTable로 단방향 관계 2개로 연결되어 있다. mappedBy 속성이 없으므로 양방향 관계가 아니다.
    // member_club 테이블은 단순히 다대다를 연결을 위한 테이블이다. A와 B의 일대일 관계도 @JoinTable을 사용하려면 DB에 a_b 테이블을 만들어야 한다.
    @ManyToMany(
        targetEntity = Member.class, 
        fetch = FetchType.LAZY, 
        cascade = CascadeType.ALL 
    )
    @JoinTable(name = "member_club", 
            joinColumns = @JoinColumn(name="club_name"),
            inverseJoinColumns = @JoinColumn(name="member_id"))
    private Set<Member> members = new HashSet<>();



    // @OneToMany(mappedBy = "cname") // targetEntity = ApplicationList.class
    // private Set<ApplicationList> applicationLists;

    
    // @OneToMany(mappedBy = "cname")
    // private Set<MemberClubPair> memberClubPairs;


    // Constructors
    public Club() { }

    public Club(String name, String president, String thema, String introduction){
        this.name=name;
        this.president=president;
        this.thema=thema;
        this.introduction=introduction;
    }



    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    

}