package com.compensation.compensation.service.Impl;

import com.compensation.compensation.domain.PointMember;
import com.compensation.compensation.domain.PointRemain;
import com.compensation.compensation.exception.CustomExcepiton;
import com.compensation.compensation.repository.PointMemberRepository;
import com.compensation.compensation.repository.PointRemainRepository;
import com.compensation.compensation.service.PointMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointMemberServiceImpl implements PointMemberService {
    private final PointMemberRepository pointMemberRepository;
    private final PointRemainRepository pointRemainRepository;
    private final CommonServiceImpl commonService;

    @Override
    public PointMember save(String id) throws CustomExcepiton {
        //포인트 조회
        PointRemain remainPoint = pointRemainRepository.findNotNullOne();
        //멤버 있는지 여부 확인
        List<PointMember> findMember = pointMemberRepository.findById(id);
        if(findMember.size() == 0) {
            //포인트 최초 지급
            PointMember member = PointMember.createMember(id, remainPoint);
            pointMemberRepository.save(member);
            return member;
        } else {
            //이미 오늘 지급 받은 사람은 포인트를 받지 못한다.
            if(!commonService.dateTimeCheck(findMember.get(0).getModifyDate())) {
                throw new CustomExcepiton("이미 포인트를 받았습니다.다음날 다시 시도하세요");
            }
            //포인트 업데이트
            return pointMemberRepository.update(findMember.get(0));
        }
    }

    @Override
    public PointMember findAll() {
        return null;
    }
}
