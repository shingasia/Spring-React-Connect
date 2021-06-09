package com.myclub.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="member_club")
public class MemberClubPair {

    @EmbeddedId
    private MemberClubPairKey key = new MemberClubPairKey();
    
    @ManyToOne(targetEntity=Member.class)
    @MapsId("memberId")
    @JoinColumn(name="member_id")
    private String memberId; //이 번에는 mid, cname으로 안하고 대문자를 섞은 memberId로 해보자
    
    @ManyToOne(targetEntity=Club.class)
    @MapsId("clubName")
    @JoinColumn(name="club_name")
    private String clubName;

    /*
    @MapsId means that we tie those fields to a part of the key, and they're the foreign keys of a many-to-one relationship. 
    We need it, because as we mentioned above, in the composite key we can't have entities.
    */

    public MemberClubPairKey getKey() {
        return key;
    }

    public void setKey(MemberClubPairKey key) {
        this.key = key;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }


    

}
