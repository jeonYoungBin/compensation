package com.compensation.compensation.domain;

import com.compensation.compensation.domain.base.Base;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class PointMember extends Base {
    @Id
    @GeneratedValue
    @Column(name = "pointMember_id")
    private Long id;

    @Column(name = "member_id")
    private String memberId;
    private Long totalPoint;
    private int receivePointCnt;

    //회원에게 포인트 최초 지급시
    public static PointMember createMember(String userId, PointRemain pointRemain) {
        PointMember createPointMember = new PointMember();
        createPointMember.setTotalPoint(100L);
        createPointMember.setReceivePointCnt(1);
        createPointMember.setMemberId(userId);
        //남아있는 총포인트 100포인트 감소
        pointRemain.removePoint(100L);

        return createPointMember;
    }
}
