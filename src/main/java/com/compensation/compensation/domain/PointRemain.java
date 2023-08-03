package com.compensation.compensation.domain;

import com.compensation.compensation.exception.CustomExcepiton;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class PointRemain {
    @Id
    @GeneratedValue
    @Column(name = "pointRemain_id")
    private Long id;
    private Long remainPoint;

    public void removePoint(Long point) {
        Long restPoint = this.remainPoint - point;
        if(restPoint < 0) {
            try {
                throw new CustomExcepiton("0 보다는 커야됨");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this.remainPoint = restPoint;
    }
}
