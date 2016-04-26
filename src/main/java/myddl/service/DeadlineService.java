package myddl.service;

import myddl.entity.Deadline;
import myddl.returnobject.DeadlineRO;

public interface DeadlineService {

    DeadlineRO getDeadline(Long deadlineId);

    void modifyDeadline(Deadline deadline);

    void deleteDeadline(Long deadlineId);

}
