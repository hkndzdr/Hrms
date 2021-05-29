package hakandizdar.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.JobAdvertService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.ErrorResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.JobAdvertDao;
import hakandizdar.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if(jobAdvert.getDetail() == null ||
		jobAdvert.getCity() == null ||
		jobAdvert.getOpenPositionCount() == 0) {
	    return new ErrorResult("Lütfen ilgili alanı doldurun");
	    }
		jobAdvert.setReleaseDate(LocalDate.now());
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveAdverts() {
		 return new SuccessDataResult<>(this.jobAdvertDao.getAllActiveAdverts());
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllActiveAdvertsByReleasedDateByAsc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveAdvertsByReleasedDateByAsc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveAdvertsByReleasedDateByDesc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveAdvertsByReleasedDateByDesc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveAdvertsByEmployer(int employerId) {
		return new SuccessDataResult<>(this.jobAdvertDao.getAllActiveAdvertsByEmployer(employerId));
	}

	@Override
	public Result changeActiveStatus(int id) {
		JobAdvert toogleValue;
		toogleValue = this.jobAdvertDao.findById(id).get();
		toogleValue.setActive(!toogleValue.isActive());
        this.jobAdvertDao.save(toogleValue);
        return new SuccessResult("İlan durumu güncellendi");
	}

}
