package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.Workplace;

public interface WorkplaceService {
	Result add(Workplace workplace);
	DataResult<List<Workplace>> getAll();
	DataResult<Workplace> getById(int id);
}
