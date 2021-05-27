package hakandizdar.hrms.core.utilities.adapters;

import hakandizdar.hrms.entities.concretes.JobSeeker;

public class MernisServiceAdapter implements ValidationService{
	
	FakeMernisService fakeMernisService = new FakeMernisService();

	@Override
	public boolean mernisValidate(JobSeeker jobSeeker) {
		return fakeMernisService.mernisValidate(jobSeeker);
	}
	

}
