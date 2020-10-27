package com.myclub.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// 기본기가 복합키일 때 키의 다른 부분을 보유 할 새 클래스를 만들어야 한다.
// 복합 키 클래스가 충족해야하는 몇 가지 주요 요구 사항이 있다.
/*
1) @Embeddable 로 표시해야합니다
2) java.io.Serializable 을 구현해야합니다.
3) hashcode () 및 equals () 메소드 의 구현을 제공해야 합니다.
4) None of the fields can be an entity themselves (어떤 필드도 엔티티가 될 수 없다. -> 밑에 mid나 cname 처럼 String 타입으로는 가능하나 Entity타입은 안된다.)
*/

@Embeddable
public class ApplicationListKey implements Serializable {
    
    @Column(name="member_id")
    private String mid;

    @Column(name="club_name")
    private String cname;


    // Constructor
    public ApplicationListKey() { }

    public ApplicationListKey(String mid, String cname) {
        this.mid = mid;
        this.cname = cname;
    }


    // getter, setter
    public String getMid() {
        return mid;
    }

    public void setMid(final String mid) {
        this.mid = mid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(final String cname) {
        this.cname = cname;
    }

    // hashCode(), equals() 구현
    // hashCode() 리턴값이 같아도 equals()의 리턴값이 false면 다른 객체가 된다.
    @Override
    public boolean equals(final Object obj) {
        if(obj instanceof ApplicationListKey){
            final ApplicationListKey other = (ApplicationListKey)obj;
            return (this.mid.equals(other.getMid()) && this.cname.equals(other.getCname()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }


}
