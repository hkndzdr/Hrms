package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.JobSeekerService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.JobSeekerDao;
import hakandizdar.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "İş arayanlar listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
	}

	@Override
	public DataResult<JobSeeker> getByNationalIdentity(String nationality) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByNationality(nationality));
	}
	
	

}
