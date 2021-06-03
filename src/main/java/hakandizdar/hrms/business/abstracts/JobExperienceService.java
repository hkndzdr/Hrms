package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result add(JobExperience jobExperience);
	Result update(JobExperience jobExperience);
	Result delete(int id);
    DataResult<List<JobExperience>> getAll();
    DataResult<List<JobExperience>> getAllByJobSeekerIdOrderByLeaveYearDesc(int jobSeekerId);
}
