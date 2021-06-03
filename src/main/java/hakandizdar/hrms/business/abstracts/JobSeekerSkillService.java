package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobSeekerSkill;

public interface JobSeekerSkillService {
	Result add(JobSeekerSkill jobSeekerSkill);
	DataResult<List<JobSeekerSkill>> getAll();
	DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(int jobSeekerId);
}
