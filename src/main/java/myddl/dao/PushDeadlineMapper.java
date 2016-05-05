package myddl.dao;

import myddl.entity.PushDeadline;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PushDeadlineMapper {
    List<PushDeadline> selectByUserId(Long userId);

    int deleteByUserIdAndDeadlineId(@Param("userId") Long userId, @Param("deadlineId") Long deadlineId);


    int deleteByPrimaryKey(Long pushDeadlineId);

    int insert(PushDeadline record);

    int insertSelective(PushDeadline record);

    PushDeadline selectByPrimaryKey(Long pushDeadlineId);

    int updateByPrimaryKeySelective(PushDeadline record);

    int updateByPrimaryKey(PushDeadline record);
}