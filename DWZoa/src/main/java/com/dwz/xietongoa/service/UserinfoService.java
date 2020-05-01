package com.dwz.xietongoa.service;

import com.dwz.xietongoa.mapper.UserinfoMapper;
import com.dwz.xietongoa.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DWZ
 * 2020/4/25
 */
@Service
public class UserinfoService {
    @Autowired
    UserinfoMapper userinfoMapper;

    public Userinfo getUserinfoByUserId(Integer id){
        Userinfo userinfo = userinfoMapper.queryUserinfoByUserid(id);
        return userinfo;
    }

    public int saveUserinfo(Userinfo userinfo){
        Integer id = userinfoMapper.queryUserinfoByUserid(userinfo.getUserId()).getId();
        userinfo.setId(id);
        int result = userinfoMapper.updateByPrimaryKeySelective(userinfo);
        return result;
    }
}
