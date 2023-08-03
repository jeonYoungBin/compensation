package com.compensation.compensation.service;

import com.compensation.compensation.domain.PointMember;
import com.compensation.compensation.domain.PointNoti;
import com.compensation.compensation.exception.CustomExcepiton;

public interface PointMemberService {
    PointMember save(String id) throws CustomExcepiton;
    PointMember findAll();
}
