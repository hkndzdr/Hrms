package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.JobSeekerSocialPlatformService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.JobSeekerSocialPlatformDao;
import hakandizdar.hrms.entities.concretes.JobSeekerSocialPlatform;

@Service
public class JobSeekerSocialPlatformManager implements JobSeekerSocialPlatformService {
	
	private JobSeekerSocialPlatformDao jobSeekerSocialPlatformDao;
	
	@Autowired
	public JobSeekerSocialPlatformManager(JobSeekerSocialPlatformDao jobSeekerSocialPlatformDao) {
		super();
		this.jobSeekerSocialPlatformDao = jobSeekerSocialPlatformDao;
	}

	@Override
	public Result add(JobSeekerSocialPlatform jobSeekerSocialPlatform) {
		this.jobSeekerSocialPlatformDao.save(jobSeekerSocialPlatform);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerSocialPlatform>> getAll() {
		return new SuccessDataResult<List<JobSeekerSocialPlatform>>(this.jobSeekerSocialPlatformDao.findAll());
	}

	@Override
	public DataResult<List<JobSeekerSocialPlatform>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerSocialPlatform>>(this.jobSeekerSocialPlatformDao.getAllByJobSeekerId(jobSeekerId));
	}

}
