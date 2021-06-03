package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.EducationService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.EducationDao;
import hakandizdar.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Okul bilgisi eklendi");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Tüm okul bilgisi listelendi");
	}

	@Override
	public DataResult<List<Education>> getAllByJobSeekerIdOrderByGraduationYearDesc(int jobSeekerId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getAllByJobSeekerIdOrderByGraduationYearDesc(jobSeekerId),"Adayın okul bilgileri listelendi");
	}

}
