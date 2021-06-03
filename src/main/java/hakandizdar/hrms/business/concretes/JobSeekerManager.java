package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.CoverLetterService;
import hakandizdar.hrms.business.abstracts.EducationService;
import hakandizdar.hrms.business.abstracts.ImageService;
import hakandizdar.hrms.business.abstracts.JobExperienceService;
import hakandizdar.hrms.business.abstracts.JobSeekerService;
import hakandizdar.hrms.business.abstracts.JobSeekerSkillService;
import hakandizdar.hrms.business.abstracts.JobSeekerSocialPlatformService;
import hakandizdar.hrms.business.abstracts.LanguageService;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.JobSeekerDao;
import hakandizdar.hrms.entities.concretes.JobSeeker;
import hakandizdar.hrms.entities.dtos.CvDto;

@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	private EducationService educationService;
	private JobExperienceService jobExperienceService;
	private ImageService imageService;
	private LanguageService languageService;
	private JobSeekerSocialPlatformService jobSeekerSocialPlatformService;
	private JobSeekerSkillService jobSeekerSkillService;
	private CoverLetterService coverLetterService;

	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EducationService educationService,
			JobExperienceService jobExperienceService, ImageService imageService, LanguageService languageService,
			JobSeekerSocialPlatformService jobSeekerSocialPlatformService, JobSeekerSkillService jobSeekerSkillService,
			CoverLetterService coverLetterService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.educationService = educationService;
		this.jobExperienceService = jobExperienceService;
		this.imageService = imageService;
		this.languageService = languageService;
		this.jobSeekerSocialPlatformService = jobSeekerSocialPlatformService;
		this.jobSeekerSkillService = jobSeekerSkillService;
		this.coverLetterService = coverLetterService;
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
	public DataResult<JobSeeker> getById(int jobSeekerId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(jobSeekerId).get());
	}

	@Override
	public DataResult<CvDto> getCvByJobSeekerId(int jobSeekerId) {
		CvDto cVDto = new CvDto();
		cVDto.setJobSeeker(this.getById(jobSeekerId).getData());
		cVDto.setEducations(this.educationService.getAllByJobSeekerIdOrderByGraduationYearDesc(jobSeekerId).getData());
		cVDto.setJobExperiences(this.jobExperienceService.getAllByJobSeekerIdOrderByLeaveYearDesc(jobSeekerId).getData());
		cVDto.setImages(this.imageService.getAllByJobSeekerId(jobSeekerId).getData());
		cVDto.setLanguages(this.languageService.getAllByJobSeekerId(jobSeekerId).getData());
		cVDto.setJobSeekerSocialPlatforms(this.jobSeekerSocialPlatformService.getAllByJobSeekerId(jobSeekerId).getData());
		cVDto.setJobSeekerSkills(this.jobSeekerSkillService.getAllByJobSeekerId(jobSeekerId).getData());
		cVDto.setCoverLetters(this.coverLetterService.getAllByJobSeekerId(jobSeekerId).getData());
		return new SuccessDataResult<CvDto>(cVDto);
	}
	
	
	

}
