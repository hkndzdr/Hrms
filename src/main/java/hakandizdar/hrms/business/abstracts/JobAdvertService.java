package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobAdvert;
import hakandizdar.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	Result add(JobAdvertDto jobAdvertDto);
	Result delete(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllSorted();
	DataResult<List<JobAdvert>> getAllByCompanyId(int id);
	DataResult<List<JobAdvert>> getAllByCompanyName(String companyName);
	DataResult<List<JobAdvert>> getAllByIsActiveFalse();
	DataResult<JobAdvert> getById(int id);
	Result activate(int id, boolean activationStatus);

}
