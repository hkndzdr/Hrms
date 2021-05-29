package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
	DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity);
}
