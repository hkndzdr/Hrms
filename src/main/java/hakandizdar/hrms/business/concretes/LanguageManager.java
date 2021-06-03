package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.LanguageService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.LanguageDao;
import hakandizdar.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Language>> getAll() {
		 return new SuccessDataResult<>(this.languageDao.findAll());
	}

	@Override
	public DataResult<List<Language>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(this.languageDao.getAllByJobSeekerId(jobSeekerId));
	}

}
