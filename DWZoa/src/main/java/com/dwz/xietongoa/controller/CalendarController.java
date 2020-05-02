package com.dwz.xietongoa.controller;

import com.dwz.xietongoa.dto.ReturnDto;
import com.dwz.xietongoa.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalendarController {
    @Autowired
    private RedisService redisService;

    /**
     * 日程表
     */
    @RequestMapping(value = "/calendar")
    public String calendar() {
        return "calendar";
    }

    /**
     * 缓存日程表备注
     * key是 calendar加userID
     * value是 JSON格式备注
     */
    @RequestMapping(value = "/calendarSetValue")
    @ResponseBody
    public ReturnDto calendarSetValue(@RequestParam("value") String value, HttpServletRequest request) {
        String key = "calendar_" + request.getSession().getAttribute("userID");
        redisService.setValue(key, value);
        return ReturnDto.buildSuccessReturnDto();
    }

    /**
     * 获取日程表备注
     * key是 calendar加userID
     * return是 JSON格式备注
     */
    @RequestMapping(value = "/calendarGetValue")
    @ResponseBody
    public ReturnDto calendarGetValue(HttpServletRequest request) {
        String key = "calendar_" + request.getSession().getAttribute("userID");
        String value = redisService.getValue(key);
        if (value != null) {
            return ReturnDto.buildSuccessReturnDto(value);
        } else {
            return ReturnDto.buildFailedReturnDto("value is null");
        }
    }

}
