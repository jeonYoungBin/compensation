package com.compensation.compensation.repository;

import com.compensation.compensation.domain.PointMember;
import com.compensation.compensation.domain.PointRemain;
import com.compensation.compensation.domain.base.Base;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointRemainRepository {
    private final EntityManager em;
    static final Long initPoint = 1000L;
    @Transactional
    public PointRemain save() {
        PointRemain pointRemain = new PointRemain();
        pointRemain.setRemainPoint(initPoint);
        em.persist(pointRemain);
        return pointRemain;
    }

    public List<PointRemain> findCheck() {
        return em.createQuery("select r from PointRemain r where r.id =: id", PointRemain.class)
                .setParameter("id", 1L)
                .getResultList();
    }

    public PointRemain findNotNullOne() {
        return em.find(PointRemain.class, 1L);
    }

    @Transactional
    public void updatePointRemain() {
        PointRemain pointRemain = em.find(PointRemain.class, 1L);
        pointRemain.setRemainPoint(initPoint);
    }

}
