package myddl.dao;

import myddl.entity.Deadline;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeadlineMapper {
    List<Deadline> selectByUserId(Long userId);

    List<Deadline> selectByGroupId(Long groupId);

    List<Deadline> selectByCourseProjectId(Long courseProjectId);

    int insertUserDeadline(@Param("userId") Long userId, @Param("deadlineId") Long deadlineId);


    int deleteByPrimaryKey(Long deadlineId);

    int insert(Deadline record);

    int insertSelective(Deadline record);

    Deadline selectByPrimaryKey(Long deadlineId);

    int updateByPrimaryKeySelective(Deadline record);

    int updateByPrimaryKey(Deadline record);
}