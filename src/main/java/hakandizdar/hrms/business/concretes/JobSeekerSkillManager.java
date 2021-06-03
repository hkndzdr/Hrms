package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.JobSeekerSkillService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.JobSeekerSkillDao;
import hakandizdar.hrms.entities.concretes.JobSeekerSkill;

@Service
public class JobSeekerSkillManager implements JobSeekerSkillService{
	
	private JobSeekerSkillDao jobSeekerSkillDao;
	
	@Autowired
	public JobSeekerSkillManager(JobSeekerSkillDao jobSeekerSkillDao) {
		super();
		this.jobSeekerSkillDao = jobSeekerSkillDao;
	}

	@Override
	public Result add(JobSeekerSkill jobSeekerSkill) {
		this.jobSeekerSkillDao.save(jobSeekerSkill);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAll() {
		return new SuccessDataResult<List<JobSeekerSkill>>(this.jobSeekerSkillDao.findAll());
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerSkill>>(this.jobSeekerSkillDao.getAllByJobSeekerId(jobSeekerId));
	}

}
