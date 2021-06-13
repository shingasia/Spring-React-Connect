package com.myclub.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="application_list")
public class ApplicationList {

    @EmbeddedId // @EmbeddedId, @Embedded, @AttributeOverrieds 각각 어떤게 다른걸까
    private ApplicationListKey key = new ApplicationListKey(); //이 필드가 null이 아니기만 하면 된다.

    @ManyToOne
    @MapsId("mid") // ApplicationListKey.mid
    @JoinColumn(name="member_id")
    private Member member;
    
    @ManyToOne
    @MapsId("cname") // ApplicationListKey.cname
    @JoinColumn(name="club_name")
    // @JoinTable(name = "application_list",
    //         joinColumns = @JoinColumn(name="club_name"))
    private Club club;

    /*
    @MapsId means that we tie those fields to a part of the key, and they're the foreign keys of a many-to-one relationship. 
    We need it, because as we mentioned above, in the composite key we can't have entities.
    */

    @Column(name="datetime")
    private String time;


    public ApplicationListKey getKey() {
        return key;
    }

    public void setKey(ApplicationListKey key) {
        this.key = key;
    }

    
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    



}
