package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.WorkplaceService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.WorkplaceDao;
import hakandizdar.hrms.entities.concretes.Workplace;

@Service
public class WorkplaceManager implements WorkplaceService{

	private WorkplaceDao workplaceDao;

	@Autowired
	public WorkplaceManager (WorkplaceDao workplaceDao) {
		this.workplaceDao = workplaceDao;
	}
	
	@Override
	public Result add(Workplace workplace) {
		this.workplaceDao.save(workplace);
		return new SuccessResult("Çalışma türü eklendi");
	}

	@Override
	public DataResult<List<Workplace>> getAll() {
		return new SuccessDataResult<List<Workplace>>(this.workplaceDao.findAll(), "Tüm çalışma türleri listelendi");
	}

	@Override
	public DataResult<Workplace> getById(int id) {
		return new SuccessDataResult<Workplace>
		(this.workplaceDao.findById(id).get(), id + "'li çalışma türü listelendi");	
	}
}
