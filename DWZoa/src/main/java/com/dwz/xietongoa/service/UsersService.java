package com.dwz.xietongoa.service;

import com.dwz.xietongoa.dto.ReturnDto;
import com.dwz.xietongoa.mapper.UserinfoMapper;
import com.dwz.xietongoa.mapper.UsersMapper;
import com.dwz.xietongoa.model.Userinfo;
import com.dwz.xietongoa.model.Users;
import com.dwz.xietongoa.model.UsersExample;
import com.dwz.xietongoa.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by DWZ
 * 2020/4/14
 */
@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    UserinfoMapper userinfoMapper;

    /**
     * 创建职工
     * @param users
     * @return
     */
    public int createUser(Users users){
        String password = MD5Util.string2MD5("123456");
        users.setPassword(password);

        int count = usersMapper.insertSelective(users);

        if (count != 1){
            return 0;
        }

        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andUsernameEqualTo(users.getUsername());
        Users user = queryUserByUsername(users);

        Userinfo userinfo = new Userinfo();
        userinfo.setUserId(user.getId());

        count = userinfoMapper.insertSelective(userinfo);

        return count;
    }

    /**
     * 根据用户名查找用户
     * @param users
     * @return
     */
    public Users queryUserByUsername(Users users){
        return usersMapper.queryUserByUsername(users.getUsername());
    }

    /**
     * 分页查询
     * @param userDto
     * @return
     */
    public PageInfo userList(Map<String, Object> map, Integer pageNum){

        map.put("isDel", "0");

        PageHelper.startPage(pageNum, 10);
        List<Users> list = usersMapper.queryBySelective(map);
        PageInfo page = new PageInfo(list);

        return page;
    }

    /**
     * 用户回显
     * @param id
     * @return
     */
    public Users detailUser(Integer id){
        Users user = usersMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 修改用户
     * @param id
     * @param user
     * @return
     */
    public int editUser(Integer id, Users user){
        user.setUsername(null);
        user.setId(id);
        int result = usersMapper.updateByPrimaryKeySelective(user);
        return result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(Integer id){
        Users user = new Users();
        user.setId(id);
        user.setIsDel("1");

        Userinfo userinfo = userinfoMapper.queryUserinfoByUserid(id);
        userinfo.setIsDel("1");
        int result = usersMapper.updateByPrimaryKeySelective(user);
        int result2 = userinfoMapper.updateByPrimaryKeySelective(userinfo);
        if (result == 1 && result2 == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 重置密码
     * @param id
     * @return
     */
    public int reverseUser(Integer id){
        Users user = new Users();
        user.setId(id);
        String password = MD5Util.string2MD5("123456");
        user.setPassword(password);

        int result = usersMapper.updateByPrimaryKeySelective(user);

        return result;
    }


    /**
     * 取所有用户 下拉框使用
     * @return
     */
    public ReturnDto getAllUser(Integer id){
        List<Map<String,String>> list = usersMapper.queryAll(id);
        return ReturnDto.buildSuccessReturnDto(list);
    }

    public List<Users> getAllUsers(){
        return usersMapper.queryAllUsers();
    }
}
