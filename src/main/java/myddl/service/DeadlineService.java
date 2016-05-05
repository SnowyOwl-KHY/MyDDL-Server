package myddl.service;

import myddl.entity.Deadline;
import myddl.returnobject.DeadlineRO;

import java.util.List;

public interface DeadlineService {

    DeadlineRO getDeadline(Long deadlineId);

    List<DeadlineRO> getPushedDeadline(Long userId);

    void deletePushedDeadline(Long userId, Long deadlineId);

    void modifyDeadline(Deadline deadline);

    long addDeadline(Deadline deadline, Long userId);

    void deleteDeadline(Long deadlineId);

}
