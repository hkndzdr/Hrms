package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
    DataResult<List<JobAdvert>> getAllActiveAdverts();
    DataResult<List<JobAdvert>> getAllActiveAdvertsByReleasedDateByAsc();
    DataResult<List<JobAdvert>> getAllActiveAdvertsByReleasedDateByDesc();
    DataResult<List<JobAdvert>> getAllActiveAdvertsByEmployer(int employerId);
    Result changeActiveStatus(int id);
}
