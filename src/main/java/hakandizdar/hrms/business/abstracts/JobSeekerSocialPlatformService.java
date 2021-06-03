package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobSeekerSocialPlatform;

public interface JobSeekerSocialPlatformService {
	Result add(JobSeekerSocialPlatform jobSeekerSocialPlatform);
	DataResult<List<JobSeekerSocialPlatform>> getAll();
	DataResult<List<JobSeekerSocialPlatform>> getAllByJobSeekerId(int jobSeekerId);
}
