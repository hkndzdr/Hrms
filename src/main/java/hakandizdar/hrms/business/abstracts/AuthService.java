package hakandizdar.hrms.business.abstracts;

import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.Employer;
import hakandizdar.hrms.entities.concretes.JobSeeker;

public interface AuthService {
	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword);

}
