package com.qianfengsix.hotel.hotel.service;

import com.qianfengsix.hotel.card.pojo.Group2;
import com.qianfengsix.hotel.hotel.pojo.Group;

import java.util.List;

/**
 * Create by lcr on 2018/11/12 0012.
 */
public interface GroupService {
    List<Group> findByPerSonNum(int group_personnum);

    void addGroup(Group group);

    List<Group2> getAllGroup(Integer pageNum, Integer pageSize);
}
