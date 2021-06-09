package com.myclub.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MemberClubPairKey implements Serializable {
    
    @Column(name="member_id")
    private String memberId;

    @Column(name="club_name")
    private String clubName;
    
    // Constructor
    public MemberClubPairKey() {
    }

    public MemberClubPairKey(String memberId, String clubName) {
        this.memberId = memberId;
        this.clubName = clubName;
    }


    // getter, setter
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

    // hashCode(), equals() 구현
    // hashCode() 리턴값이 같아도 equals()의 리턴값이 false면 다른 객체가 된다.
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj instanceof MemberClubPairKey){
            final MemberClubPairKey other = (MemberClubPairKey)obj;
            return (this.memberId.equals(other.getMemberId()) && this.clubName.equals(other.getClubName()));
        }
        return false;
    }

}
