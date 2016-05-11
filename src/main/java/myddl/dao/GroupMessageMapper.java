package myddl.dao;

import myddl.entity.GroupMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupMessageMapper {
    List<GroupMessage> selectByGroupId(Long groupId);


    int deleteByPrimaryKey(Long groupMessageId);

    int insert(GroupMessage record);

    int insertSelective(GroupMessage record);

    GroupMessage selectByPrimaryKey(Long groupMessageId);

    int updateByPrimaryKeySelective(GroupMessage record);

    int updateByPrimaryKey(GroupMessage record);
}