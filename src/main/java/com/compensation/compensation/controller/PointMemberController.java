package com.compensation.compensation.controller;

import com.compensation.compensation.domain.PointMember;
import com.compensation.compensation.domain.PointRemain;
import com.compensation.compensation.domain.response.Response;
import com.compensation.compensation.exception.CustomExcepiton;
import com.compensation.compensation.repository.PointMemberRepository;
import com.compensation.compensation.repository.PointRemainRepository;
import com.compensation.compensation.service.Impl.CommonServiceImpl;
import com.compensation.compensation.service.PointMemberService;
import com.compensation.compensation.service.PointRemainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/point/member")
@RequiredArgsConstructor
public class PointMemberController {

    private final PointMemberService pointMemberService;
    private final CommonServiceImpl commonService;
    private final PointRemainService pointRemainService;
    private final PointMemberRepository pointMemberRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Response addPointMember(@RequestBody HashMap<String,String> userId) throws CustomExcepiton {
        String id = userId.get("userId");
        //포인트 초기화 체크
        pointRemainService.initCheck();

        //회원에게 100포인트 지급(같은 날짜에만 해당)
        return new Response(200, "OK", pointMemberService.save(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Response findAllPointMember(@RequestParam(name = "searchDay") String searchDay) throws Exception {
        commonService.datePattern(searchDay);
        return new Response(200, "OK", pointMemberRepository.findAll(searchDay));
    }
}
