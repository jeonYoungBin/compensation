package com.compensation.compensation.controller;

import com.compensation.compensation.domain.PointNoti;
import com.compensation.compensation.domain.response.Response;
import com.compensation.compensation.repository.PointRepository;
import com.compensation.compensation.service.PointService;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Response addPointNotice() {
        return new Response(200, "OK", pointService.save());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Response findPointNotice() {
        return new Response(200, "OK", pointService.findOne());
    }

}
