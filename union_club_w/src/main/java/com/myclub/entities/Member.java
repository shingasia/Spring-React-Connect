package com.myclub.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="member")
public class Member {
    
    @Id
    @Column(name="member_id")
    private String id;

    @Column(name="member_password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    // Member와 Club 둘다 @JoinTable로 단방향 관계 2개로 연결되어 있다. mappedBy 속성이 없으므로 양방향 관계가 아니다.
    @ManyToMany(
        targetEntity = Club.class, 
        fetch = FetchType.LAZY, 
        cascade = CascadeType.ALL 
    )
    @JoinTable(name="member_club", 
            joinColumns = @JoinColumn(name="member_id"), 
            inverseJoinColumns = @JoinColumn(name="club_name"))
    private Set<Club> clubs = new HashSet<>();


    // // ApplicationList 엔티티와 일대다 양방향 매핑
    // @OneToMany(mappedBy = "mid", targetEntity = ApplicationList.class)
    // private Set<ApplicationList> applicationLists;

    // // MemberClubPair 엔티티와 일대다 양방향 매핑
    // @OneToMany(mappedBy = "mid", targetEntity = MemberClubPair.class)
    // private Set<MemberClubPair> memberClubPairs;


    // Constructors
    public Member() { }

    public Member(String id, String password, String name, String address, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
    }


    // getter, setter
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    
}