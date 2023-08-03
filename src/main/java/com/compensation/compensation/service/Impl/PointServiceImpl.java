package com.compensation.compensation.service.Impl;

import com.compensation.compensation.domain.PointNoti;
import com.compensation.compensation.repository.PointRepository;
import com.compensation.compensation.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;

    @Override
    public PointNoti save() {
        PointNoti addPointNoti = new PointNoti();
        String description = " • 보상지급방식은 사용자가 받기를 누를때 지급하게 됩니다.\n" +
                " • 선착순 10 명에게 100 포인트의 보상이 지급 되며 10 명 이후에는 지급되지 않아야 합니다.\n" +
                " • 3일 연속,5일 연속,10일 연속 보상을 받는 경우 300 포인트, 500 포인트, 1,000 포인트를 추가 보상 받게 됩니다.\n" +
                " • 추가 보상은 10일 까지 이어지며 그 이후 연속 보상 횟수는 1 회 부터 다시 시작 됩니다.";

        addPointNoti.setAdmin_id("reward");
        addPointNoti.setSubject("매일 00시 00분 00초 선착순 10명 100 포인트 지급!!!");
        addPointNoti.setDescription(description);
        pointRepository.save(addPointNoti);

        return addPointNoti;
    }

    @Override
    public PointNoti findOne() {
        return pointRepository.findOne();
    }
}
