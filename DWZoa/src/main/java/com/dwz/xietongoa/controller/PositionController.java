package com.dwz.xietongoa.controller;

import com.dwz.xietongoa.dto.ReturnDto;
import com.dwz.xietongoa.model.Positions;
import com.dwz.xietongoa.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by DWZ
 * 2020/4/14
 */
@Controller
@RequestMapping("/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    /**
     * 查询职位
     * @return
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public ReturnDto queryPosition(){
        List<Positions> positions = positionService.queryPosition();
        return ReturnDto.buildSuccessReturnDto(positions);
    }
}
