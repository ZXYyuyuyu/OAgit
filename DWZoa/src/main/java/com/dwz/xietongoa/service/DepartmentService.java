package com.dwz.xietongoa.service;

import com.dwz.xietongoa.mapper.DepartmentsMapper;
import com.dwz.xietongoa.model.Departments;
import com.dwz.xietongoa.model.DepartmentsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DWZ
 * 2020/4/14
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentsMapper departmentsMapper;

    /**
     * 查询部门
     * @return
     */
    public List<Departments> queryDepartment(){
        DepartmentsExample departmentsExample = new DepartmentsExample();
        return departmentsMapper.selectByExample(departmentsExample);
    }
}
