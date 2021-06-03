package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobSeeker;
import hakandizdar.hrms.entities.dtos.CvDto;

public interface JobSeekerService {
	Result add(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity);
	DataResult<JobSeeker> getById(int jobSeekerId);
	DataResult<CvDto> getCvByJobSeekerId(int jobSeekerId);
}
