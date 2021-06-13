package com.myclub.entities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="member_club_enrollment") // 테이블을 따로 만들자 member_club 테이블은 이미 다대다 매핑하는데 사용되고 있으므로... enroll 테이블을 만들던지 하자
public class MemberClubPair {

    @EmbeddedId
    private MemberClubPairKey key = new MemberClubPairKey();
    
    @ManyToOne
    @MapsId("mid")
    @JoinColumn(name="member_id")
    // @JoinTable(name = "member_club_enrollment", 
    //         joinColumns = @JoinColumn(name = "member_id"))
    private Member mid;
    
    @ManyToOne // (targetEntity=Club.class, cascade = CascadeType.ALL)
    @MapsId("cname")
    @JoinColumn(name="club_name")
    // @JoinTable(name = "member_club_enrollment", 
    //         joinColumns = @JoinColumn(name = "club_name"))
    private Club cname;

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

    public Member getMid() {
        return mid;
    }

    public void setMid(Member mid) {
        this.mid = mid;
    }

    public Club getCname() {
        return cname;
    }

    public void setCname(Club cname) {
        this.cname = cname;
    }

    
    

    

}
