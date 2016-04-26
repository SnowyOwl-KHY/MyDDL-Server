package myddl.service;

import myddl.entity.Deadline;
import myddl.returnobject.DeadlineRO;

public interface DeadlineService {

    DeadlineRO getDeadline(Long deadlineId);

    void modifyDeadline(Deadline deadline);

    long addDeadline(Deadline deadline, Long userId);

    void deleteDeadline(Long deadlineId);

}
