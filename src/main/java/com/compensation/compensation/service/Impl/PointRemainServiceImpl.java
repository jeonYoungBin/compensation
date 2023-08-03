package com.compensation.compensation.service.Impl;

import com.compensation.compensation.domain.PointRemain;
import com.compensation.compensation.exception.CustomExcepiton;
import com.compensation.compensation.repository.PointRemainRepository;
import com.compensation.compensation.service.PointRemainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointRemainServiceImpl implements PointRemainService {

    private final CommonServiceImpl commonService;
    private final PointRemainRepository pointRemainRepository;

    @Override
    public void initCheck() throws CustomExcepiton {
        //초기 1000포인트 세팅
        List<PointRemain> remain = pointRemainRepository.findCheck();
        if(remain.size() == 0) {
            remain.add(pointRemainRepository.save());
        }
        //00:00:00되는 순간 포인트 1000 재충전
        if(commonService.nowDateCheck()) {
            if(remain.get(0).getRemainPoint() == 0) {
                pointRemainRepository.updatePointRemain();
            }
        }
        //포인트가 0이면 포인트 지급 마감
        if(remain.get(0).getRemainPoint() == 0) {
            throw new CustomExcepiton("포인트 지급 마감");
        }
    }
}
