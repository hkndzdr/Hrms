package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.WorkSchedule;

public interface WorkScheduleService {
	Result add(WorkSchedule workSchedule);
	DataResult<List<WorkSchedule>> getAll();
	DataResult<WorkSchedule> getById(int id);
}
