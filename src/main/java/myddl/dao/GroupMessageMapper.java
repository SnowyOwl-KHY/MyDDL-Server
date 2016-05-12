package myddl.dao;

import myddl.entity.GroupMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupMessageMapper")
public interface GroupMessageMapper {
    List<GroupMessage> selectByGroupId(Long groupId);


    int deleteByPrimaryKey(Long groupMessageId);

    int insert(GroupMessage record);

    int insertSelective(GroupMessage record);

    GroupMessage selectByPrimaryKey(Long groupMessageId);

    int updateByPrimaryKeySelective(GroupMessage record);

    int updateByPrimaryKey(GroupMessage record);
}