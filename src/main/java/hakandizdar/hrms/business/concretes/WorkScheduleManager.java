package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hakandizdar.hrms.business.abstracts.WorkScheduleService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.WorkScheduleDao;
import hakandizdar.hrms.entities.concretes.WorkSchedule;

@Service
public class WorkScheduleManager implements WorkScheduleService {
	
	private WorkScheduleDao workScheduleDao;

	@Autowired
	public WorkScheduleManager (WorkScheduleDao workScheduleDao) {
		this.workScheduleDao = workScheduleDao;
	}
	

	@Override
	public Result add(WorkSchedule workSchedule) {
		this.workScheduleDao.save(workSchedule);
		return new SuccessResult("Çalışma zamanı eklendi");
	}

	@Override
	public DataResult<List<WorkSchedule>> getAll() {
		return new SuccessDataResult<List<WorkSchedule>>(this.workScheduleDao.findAll(), "Tüm çalışma zamanları listelendi");
	}

	@Override
	public DataResult<WorkSchedule> getById(int id) {
		return new SuccessDataResult<WorkSchedule>
		(this.workScheduleDao.findById(id).get(), id + "'li çalışma zamanı listelendi");	
	}

}
