package hakandizdar.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import hakandizdar.hrms.entities.concretes.JobSeeker;

@Service
public class MernisServiceAdapter implements ValidationService{
	
	FakeMernisService fakeMernisService = new FakeMernisService();

	@Override
	public boolean mernisValidate(JobSeeker jobSeeker) {
		return fakeMernisService.mernisValidate(jobSeeker);
	}
	

}
