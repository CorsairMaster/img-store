package com.qianfengsix.hotel.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfengsix.hotel.card.pojo.Group2;
import com.qianfengsix.hotel.hotel.pojo.Group;
import com.qianfengsix.hotel.hotel.service.GroupService;
import com.qianfengsix.hotel.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by lcr on 2018/11/10 0010.
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Override
    public List<Group> findByPerSonNum(int group_personnum) {
        return groupMapper.findByPerSonNum(group_personnum);
    }

    @Override
    public void addGroup(Group group) {
        groupMapper.addGroup(group);
    }

    @Override
    public List<Group2> getAllGroup(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Group2> list = groupMapper.findAllGroup();
        PageInfo<Group2> pageInfo = new PageInfo<>(list);
        return list;
    }
}
