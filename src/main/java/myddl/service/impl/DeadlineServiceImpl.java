package myddl.service.impl;

import myddl.dao.CourseProjectMapper;
import myddl.dao.DeadlineMapper;
import myddl.dao.PushDeadlineMapper;
import myddl.entity.Deadline;
import myddl.entity.PushDeadline;
import myddl.returnobject.DeadlineRO;
import myddl.service.DeadlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("deadlineService")
public class DeadlineServiceImpl implements DeadlineService {

    @Resource
    DeadlineMapper deadlineMapper;
    @Resource
    PushDeadlineMapper pushDeadlineMapper;
    @Resource
    CourseProjectMapper courseProjectMapper;

    @Override
    public DeadlineRO getDeadline(Long deadlineId) {
        Deadline deadline = deadlineMapper.selectByPrimaryKey(deadlineId);
        return deadline == null ? null : new DeadlineRO(deadline, courseProjectMapper);
    }

    @Override
    public List<DeadlineRO> getPushedDeadline(Long userId) {
        List<PushDeadline> pushDeadlines = pushDeadlineMapper.selectByUserId(userId);
        List<DeadlineRO> result = pushDeadlines.stream()
                .map(pushDeadline -> getDeadline(pushDeadline.getDeadlineId()))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void deletePushedDeadline(Long userId, Long deadlineId) {
        pushDeadlineMapper.deleteByUserIdAndDeadlineId(userId, deadlineId);
    }

    @Override
    public void modifyDeadline(Deadline deadline) {
        deadlineMapper.updateByPrimaryKeySelective(deadline);
    }

    @Override
    public long addDeadline(Deadline deadline, Long userId) {
        long deadlineId = deadlineMapper.insertSelective(deadline);
        deadlineMapper.insertUserDeadline(deadlineId, userId);
        return deadlineId;
    }

    @Override
    public void deleteDeadline(Long deadlineId) {
        deadlineMapper.deleteByPrimaryKey(deadlineId);
    }
}
