package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);
    DataResult<List<Education>> getAll();
    DataResult<List<Education>> getAllByJobSeekerIdOrderByGraduationYearDesc(int jobSeekerId);
}
