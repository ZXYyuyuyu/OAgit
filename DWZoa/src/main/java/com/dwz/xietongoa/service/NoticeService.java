package com.dwz.xietongoa.service;


import com.dwz.xietongoa.mapper.NoticesMapper;
import com.dwz.xietongoa.model.Notices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dwz
 * @date 2020/4/2621:58
 */
@Service
public class NoticeService {
    @Autowired
    private NoticesMapper noticesMapper;

    public int insertNotice(Notices notices){
        noticesMapper.insertSelective(notices);
        return notices.getId();
    }

    /**
     * 获取具体某条公告
     */
    public Notices getNotice(Integer noticeID){
        return noticesMapper.selectByPrimaryKey(noticeID);
    }

    /**
     * 获取本人所有公告
     * 这个功能不分人 大家都收到一样
     */
    public PageInfo getAllNotices(Integer pageNum){
        PageHelper.startPage(pageNum, 10);
        List<Map<String, String>> result = noticesMapper.selectAllNotice();
        PageInfo pageInfo = new PageInfo(result);
        return pageInfo;
    }

    /**
     * 传入未读ID数组 返回未读信息 (Redis里含有的ID再Mysql中)
     */
    public List<Map<String,String>> selectByIDs(List<Integer> IDs){
        return noticesMapper.selectByIDs(IDs);
    }

    public Notices selectByID(Integer id){
        return noticesMapper.selectByPrimaryKey(id);
    }

    public List<Map<String,String>> getLastNotice(){
        return noticesMapper.selectLastOneByReceiveID();
    }
}
