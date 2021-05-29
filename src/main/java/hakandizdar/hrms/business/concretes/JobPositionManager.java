package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.JobPositionService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.ErrorResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.JobPositionDao;
import hakandizdar.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"İş pozisyonları listelendi");
	}


	@Override
	public Result add(JobPosition jobPosition) {
	    if(getByName(jobPosition.getName()).getData() != null){
            return new ErrorResult("Girdiğiniz iş poziyonu sistemde mevcut");
        }
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("İş pozisyonu eklendi");
	}


	@Override
	public DataResult<JobPosition> getByName(String name) {
		 return new SuccessDataResult<>(this.jobPositionDao.getByName(name));
	}
	
}
