package myddl.dao;

import myddl.entity.Deadline;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeadlineMapper {
    int deleteByPrimaryKey(Long deadlineId);

    int insert(Deadline record);

    int insertSelective(Deadline record);

    Deadline selectByPrimaryKey(Long deadlineId);

    List<Deadline> selectByUserId(Long userId);

    int updateByPrimaryKeySelective(Deadline record);

    int updateByPrimaryKey(Deadline record);
}