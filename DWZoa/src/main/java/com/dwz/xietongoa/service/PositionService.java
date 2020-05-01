package com.dwz.xietongoa.service;

import com.dwz.xietongoa.mapper.PositionsMapper;
import com.dwz.xietongoa.model.Positions;
import com.dwz.xietongoa.model.PositionsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DWZ
 * 2020/4/14
 */
@Service
public class PositionService {

    @Autowired
    PositionsMapper positionsMapper;

    /**
     * 查询职位
     * @return
     */
    public List<Positions> queryPosition(){
        PositionsExample positionsExample = new PositionsExample();
        List<Positions> positions = positionsMapper.selectByExample(positionsExample);
        return positions;
    }
}
