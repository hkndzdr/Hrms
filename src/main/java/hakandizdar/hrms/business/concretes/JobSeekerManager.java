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
import hakandizdar.hrms.entities.dtos.JobSeekerCvDto;

@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "İş arayanlar listelendi");
	}


	@Override
	public DataResult<JobSeeker> getByNationalIdentity(String nationality) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByNationality(nationality));
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByEmail(email));
	}
	
	
	@Override
	public DataResult<JobSeeker> getById(int jobSeekerId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(jobSeekerId).get());
	}

	@Override
	public DataResult<JobSeekerCvDto> getCvByJobSeekerId(int jobSeekerId) {
		JobSeekerCvDto jobSeekerCvDto = new JobSeekerCvDto();
		JobSeeker jobSeeker = this.jobSeekerDao.findById(jobSeekerId).get();		
		jobSeekerCvDto.setJobSeeker(jobSeeker);
		jobSeekerCvDto.setEducations(jobSeeker.getEducations());
		jobSeekerCvDto.setJobExperiences(jobSeeker.getJobExperience());
		jobSeekerCvDto.setImages(jobSeeker.getImages());
		jobSeekerCvDto.setLanguages(jobSeeker.getLanguages());
		jobSeekerCvDto.setJobSeekerSocialPlatforms(jobSeeker.getJobSeekerSocialPlatforms());
		jobSeekerCvDto.setJobSeekerSkills(jobSeeker.getJobSeekerSkills());
		jobSeekerCvDto.setCoverLetters(jobSeeker.getCoverLetters());
		return new SuccessDataResult<JobSeekerCvDto>(jobSeekerCvDto);
	}

}
