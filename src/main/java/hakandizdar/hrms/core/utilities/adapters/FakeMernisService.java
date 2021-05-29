package hakandizdar.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import hakandizdar.hrms.entities.concretes.JobSeeker;

@Service
public class FakeMernisService implements ValidationService{

	@Override
	public boolean mernisValidate(JobSeeker jobSeeker) {
		if(jobSeeker.getNationality() == "12345678901" && jobSeeker.getFirstName() == "Hakan" && jobSeeker.getLastName() == "Dizdar" && jobSeeker.getDateOfBirth().getYear() == 1981) {
			return true;
		}
		return false;
	}
}
