package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	Result add(CoverLetter coverLetter);
	DataResult<List<CoverLetter>> getAll();
	DataResult<List<CoverLetter>> getAllByJobSeekerId(int jobSeekerId);
}
