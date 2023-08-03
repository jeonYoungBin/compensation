package com.compensation.compensation.domain.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {
    @CreatedDate
    @Column(name = "first_point_at", nullable = false, updatable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "last_point_at", nullable = false)
    private LocalDateTime modifyDate;
}
