package com.compensation.compensation;

import com.compensation.compensation.domain.PointMember;
import com.compensation.compensation.repository.PointMemberRepository;
import com.compensation.compensation.service.Impl.CommonServiceImpl;
import com.compensation.compensation.service.PointMemberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
class CompensationApplicationTests {
	@Autowired
	CommonServiceImpl commonService;
	@Autowired
	PointMemberRepository pointMemberRepository;

	@Autowired
	PointMemberService pointMemberService;

	@Test
	@Rollback(value = false)
	void contextLoads() {
		List<PointMember> pointMember = pointMemberRepository.findById("A");
//		commonService.dateTimeCheck(id.get(0).getModifyDate());
		pointMemberRepository.update(pointMember.get(0));

//		int between = Long.valueOf(ChronoUnit.DAYS.between(pointMember.get(0).getCreateDate(), pointMember.get(0).getModifyDate()) + 1).intValue();
//		System.out.println(between);
	}

}
