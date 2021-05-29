package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	DataResult<JobPosition> getByName(String name);
}
