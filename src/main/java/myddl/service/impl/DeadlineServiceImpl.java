package myddl.service.impl;

import myddl.dao.CourseProjectMapper;
import myddl.dao.DeadlineMapper;
import myddl.entity.Deadline;
import myddl.returnobject.DeadlineRO;
import myddl.service.DeadlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("deadlineService")
public class DeadlineServiceImpl implements DeadlineService {

    @Resource
    DeadlineMapper deadlineMapper;
    @Resource
    CourseProjectMapper courseProjectMapper;

    @Override
    public DeadlineRO getDeadline(Long deadlineId) {
        Deadline deadline = deadlineMapper.selectByPrimaryKey(deadlineId);
        return deadline == null ? null : new DeadlineRO(deadline, courseProjectMapper);
    }

    @Override
    public void deleteDeadline(Long deadlineId) {
        deadlineMapper.deleteByPrimaryKey(deadlineId);
    }
}
