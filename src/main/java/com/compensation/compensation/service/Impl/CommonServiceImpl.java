package com.compensation.compensation.service.Impl;

import com.compensation.compensation.exception.CustomExcepiton;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.regex.Pattern;

@Service
public class CommonServiceImpl {

    static final String REGEXP_PATTERN_CHAR = "^[\\d]{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

    public boolean nowDateCheck() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatedNow = now.format(dateTimeFormatter);

        return formatedNow.equals("00:00:00");
    }

    //오늘 포인트 발급 가능 여부 체크
    public boolean dateTimeCheck(LocalDateTime receivePointGetTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ldt = LocalDateTime.of(now.getYear(),
                now.getMonth(), now.getDayOfMonth(), 0, 0, 0);

        LocalDateTime rdt = LocalDateTime.of(now.getYear(),
                now.getMonth(), now.getDayOfMonth(), 23, 59, 59);

        if(receivePointGetTime.isAfter(ldt) && receivePointGetTime.isBefore(rdt)) {
            //포인트 발급 불가능
            return false;
        } else {
            //포인트를 발급 가능
            return true;
        }
    }

    //날짜 체크
    public void datePattern(String searchDay) throws CustomExcepiton {
        boolean matches = Pattern.matches(REGEXP_PATTERN_CHAR, searchDay);
        if(!matches)
            throw new CustomExcepiton("날짜 패턴이 잘못되었습니다.(올바른 형식 : YYYY-MM-DD)");
    }
}
