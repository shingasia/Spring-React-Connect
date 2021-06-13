package com.myclub.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MemberClubPairKey implements Serializable {
    
    @Column(name="member_id")
    private String mid;

    @Column(name="club_name")
    private String cname;
    
    // Constructor
    public MemberClubPairKey() {
    }

    public MemberClubPairKey(String mid, String cname) {
        this.mid = mid;
        this.cname = cname;
    }


    // getter, setter
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    // hashCode(), equals() 구현
    // hashCode() 리턴값이 같아도 equals()의 리턴값이 false면 다른 객체가 된다.
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        MemberClubPairKey other = (MemberClubPairKey) obj;
        return (this.mid.equals(other.getMid()) && this.cname.equals(other.getCname()));
    }

}
