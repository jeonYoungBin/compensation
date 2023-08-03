package com.compensation.compensation.service;

import com.compensation.compensation.domain.PointNoti;
import com.compensation.compensation.repository.PointRepository;

public interface PointService {
    PointNoti save();
    PointNoti findOne();
}
