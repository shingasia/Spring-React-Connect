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

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    @JoinTable(name="member_club",
            joinColumns = @JoinColumn(name="club_name"),
            inverseJoinColumns = @JoinColumn(name="member_id"))
    private Set<Member> members = new HashSet<>();


    public Club() { }

    public Club(String name, String president, String thema, String introduction){
        this.name=name;
        this.president=president;
        this.thema=thema;
        this.introduction=introduction;
    }

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