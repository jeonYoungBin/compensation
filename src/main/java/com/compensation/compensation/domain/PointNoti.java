package com.compensation.compensation.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class PointNoti {
    @Id
    @GeneratedValue
    @Column(name = "pointNoti_id")
    private Long id;
    private String admin_id;
    private String description;
    private String subject;
}
