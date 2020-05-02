package com.dwz.xietongoa.controller;

import com.dwz.xietongoa.dto.ReturnDto;
import com.dwz.xietongoa.model.Departments;
import com.dwz.xietongoa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by DWZ
 * 2020/4/14
 * @author dwz
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 查询部门
     * @return
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public ReturnDto queryDepartment(){
        List<Departments> departments = departmentService.queryDepartment();
        return ReturnDto.buildSuccessReturnDto(departments);
    }

}
