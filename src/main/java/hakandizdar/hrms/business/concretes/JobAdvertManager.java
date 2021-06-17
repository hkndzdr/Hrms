package hakandizdar.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.JobAdvertService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.ErrorDataResult;
import hakandizdar.hrms.core.utilities.results.ErrorResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.CityDao;
import hakandizdar.hrms.dataAccess.abstracts.EmployerDao;
import hakandizdar.hrms.dataAccess.abstracts.JobAdvertDao;
import hakandizdar.hrms.dataAccess.abstracts.JobPositionDao;
import hakandizdar.hrms.dataAccess.abstracts.WorkScheduleDao;
import hakandizdar.hrms.dataAccess.abstracts.WorkplaceDao;
import hakandizdar.hrms.entities.concretes.JobAdvert;
import hakandizdar.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	private JobPositionDao jobPositionDao;
	private WorkplaceDao workplaceDao;
	private WorkScheduleDao workScheduleDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, EmployerDao employerDao, CityDao cityDao, 
			JobPositionDao jobPositionDao, WorkplaceDao workplaceDao, WorkScheduleDao workScheduleDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobPositionDao = jobPositionDao;
		this.workplaceDao = workplaceDao;
		this.workScheduleDao = workScheduleDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByIsActiveTrue(), "Tüm aktif iş ilanları listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveFalse() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByIsActiveFalse(), "Tüm pasif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "releasedDate");
		return new SuccessDataResult<List<JobAdvert>> 
		(this.jobAdvertDao.getAllByIsActiveTrue(sort));
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByCompanyId(int id) {
		if (!this.employerDao.existsById(id)) {
			return new ErrorDataResult<List<JobAdvert>>("Şirkete ait ilan bulunamadı");
		}
		
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByEmployerId(id), id + "'ye ait şirket ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByCompanyName(String companyName) {
		if (this.employerDao.getAllByCompanyName(companyName).isEmpty()) {
			return new ErrorDataResult<List<JobAdvert>>("Şirkete ait ilan bulunamadı");
		}
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByEmployer_CompanyName(companyName), companyName + "isimli şirketin ilanlatı listelendi");
	}

	@Override
	public Result add(JobAdvertDto jobAdvertDto) {
		JobAdvert jobAdvert = new JobAdvert();
		jobAdvert.setEmployer(this.employerDao.getOne(jobAdvertDto.getEmployerId()));
		jobAdvert.setCity(this.cityDao.getOne(jobAdvertDto.getCityId()));
		jobAdvert.setDetail(jobAdvertDto.getDetail());
		jobAdvert.setApplicationDeadline(jobAdvertDto.getApplicationDeadline());
		jobAdvert.setJobPosition(this.jobPositionDao.getOne(jobAdvertDto.getJobPositionId()));
		jobAdvert.setMaxSalary(jobAdvertDto.getMaxSalary());
		jobAdvert.setMinSalary(jobAdvertDto.getMinSalary());
		jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
		jobAdvert.setWorkplace(this.workplaceDao.getOne(jobAdvertDto.getWorkplaceId()));
		jobAdvert.setWorkSchedule(this.workScheduleDao.getOne(jobAdvertDto.getWorkScheduleId()));
		jobAdvert.setReleaseDate(LocalDate.now());
		jobAdvert.setActive(false);;
		
		if (!isAllFieldsFilled(jobAdvert)) {
			return new ErrorResult("Tüm alanlar doldurulmalıdır");
		}
		
		if (!isCityExist(jobAdvert)) {
			return new ErrorResult("Şehir bilgisi eksik");
		}
		
		if (!isExistEmployer(jobAdvert)) {
			return new ErrorResult("İşveren bilgisi eksik");
		}
		
		if (!isExistOpenPosition(jobAdvert)) {
			return new ErrorResult("En az 1 açık iş pozisyonu olmalıdır");
		}
		
		if (!isDifferentReleasedAndApplicationDeadline(jobAdvert)) {
			return new ErrorResult("Yayın başlangıç ve bitiş tarihi aynı olamaz"); 
		}
		
		else {
			this.jobAdvertDao.save(jobAdvert);
			return new SuccessResult("İş ilanı eklendi");			
		}
	}

	@Override
	public Result activate(int id, boolean status) {
		JobAdvert jobAdvertToActivate = this.jobAdvertDao.findById(id).orElse(null);
		jobAdvertToActivate.setActive(status);	
		this.jobAdvertDao.save(jobAdvertToActivate);
		return new SuccessResult("İş pozisyonu durumu değiştirildi" + Boolean.toString(status));
	}
	
	@Override
	public DataResult<JobAdvert> getById(int id) {
		if (!this.jobAdvertDao.existsById(id)) {
			return new ErrorDataResult<JobAdvert>("İş ilanı bulunamadı");
		}	
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id));
	}
	
	
	private boolean isCityExist(JobAdvert jobAdvert) {
		if (this.cityDao.existsById(jobAdvert.getCity().getId())) {
			return true;			
		}	
		return false;
	}
	
	
	private boolean isExistEmployer(JobAdvert jobAdvert) {
		if (this.employerDao.existsById(jobAdvert.getEmployer().getId())) {
			return true;
		}
		return false;
	}
	
	
	private boolean isAllFieldsFilled(JobAdvert jobAdvert) {
		if (jobAdvert.getDetail().length() != 0 && jobAdvert.getApplicationDeadline() != null) {
			return true;
		}
		return false;
	}
	
	private boolean isExistOpenPosition(JobAdvert jobAdvert) {
		if (jobAdvert.getOpenPositionCount() > 0) {
			return true;
		}
		return false;
	}
	
	
	private boolean isDifferentReleasedAndApplicationDeadline(JobAdvert jobAdvert) {
		if (!jobAdvert.getReleaseDate().equals(jobAdvert.getApplicationDeadline())) {
			return true;
		}	
		return false;
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		this.jobAdvertDao.delete(jobAdvert);
		return new SuccessResult("İş ilanı silindi");
	}
}
