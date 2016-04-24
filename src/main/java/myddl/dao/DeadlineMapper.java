package myddl.dao;

import myddl.entity.Deadline;
import org.springframework.stereotype.Component;

@Component
public interface DeadlineMapper {
    int deleteByPrimaryKey(Long deadlineId);

    int insert(Deadline record);

    int insertSelective(Deadline record);

    Deadline selectByPrimaryKey(Long deadlineId);

    int updateByPrimaryKeySelective(Deadline record);

    int updateByPrimaryKey(Deadline record);
}