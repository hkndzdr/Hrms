package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.StaffService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.StaffDao;
import hakandizdar.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService{
	
	private StaffDao staffDao;
	
	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public Result add(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("Personel eklendi");
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), "Tüm personeller listelendi");
	}

}
