package com.compensation.compensation.repository;

import com.compensation.compensation.domain.PointMember;
import com.compensation.compensation.domain.PointNoti;
import com.compensation.compensation.domain.PointRemain;
import com.compensation.compensation.domain.base.Base;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointMemberRepository  {
    private final EntityManager em;

    static final Long receivePoint = 100L;
    static final Long day3receivePoint = 300L;
    static final Long day5receivePoint = 500L;
    static final Long day10receivePoint = 1000L;
    static final int days3 = 3;
    static final int days5 = 5;
    static final int days10 = 10;

    static final int receivePointCnt = 1;

    @Transactional
    public void save(PointMember pointMember) {
        em.persist(pointMember);
    }

    public List<PointMember> findById(String member_id) {
        return em.createQuery("select m from PointMember m where m.memberId= :memberId", PointMember.class)
                .setParameter("memberId", member_id)
                .getResultList();
    }

    @Transactional
    public PointMember update(PointMember pointMember) {
        //포인트 받은 횟수가 10번 이상이면 초기화
        if(pointMember.getReceivePointCnt() > 10)
            pointMember.setReceivePointCnt(receivePointCnt);
        else
            pointMember.setReceivePointCnt(pointMember.getReceivePointCnt() + receivePointCnt);

        int between = Long.valueOf(ChronoUnit.DAYS.between(pointMember.getCreateDate(), pointMember.getModifyDate()) + 1).intValue();
        switch (between) {
            case days3 -> pointMember.setTotalPoint(pointMember.getTotalPoint() + day3receivePoint);
            case days5 -> pointMember.setTotalPoint(pointMember.getTotalPoint() + day5receivePoint);
            case days10 -> pointMember.setTotalPoint(pointMember.getTotalPoint() + day10receivePoint);
            default -> pointMember.setTotalPoint(pointMember.getTotalPoint() + receivePoint);
        }

        return pointMember;
    }

    public List<PointMember> findAll(String searchDateTime) {
        String day = searchDateTime + " 00:00:00.000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime startDateTime = LocalDateTime.parse(day, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(day, formatter).plusDays(1);

        String sql = "SELECT m FROM PointMember m where m.createDate >= ?1 AND m.createDate < ?2 order by m.createDate";
        return em.createQuery(sql, PointMember.class)
                .setParameter(1, startDateTime)
                .setParameter(2, endDateTime)
                .setMaxResults(10)
                .getResultList();
    }

    public List<PointMember> findAll1() {
        return em.createQuery("SELECT m FROM PointMember m", PointMember.class)
                .getResultList();
    }


}
