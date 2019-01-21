package com.qianfengsix.hotel.mapper;

import com.qianfengsix.hotel.card.pojo.Group2;
import com.qianfengsix.hotel.hotel.pojo.Group;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by lcr on 2018/11/10 0010.
 */
@Component
public interface GroupMapper {
    List<Group> findByPerSonNum(int group_personnum);

    void addGroup(Group group);

    List<Group2> findAllGroup();
}
