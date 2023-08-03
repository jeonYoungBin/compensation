package com.compensation.compensation.repository;

import com.compensation.compensation.domain.PointNoti;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.HashMap;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointRepository {
    private final EntityManager em;

    @Transactional
    public void save(PointNoti pointNoti) {
        em.persist(pointNoti);
    }

    public PointNoti findOne() {
        return em.find(PointNoti.class, 1L);
    }

}
