package hakandizdar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import hakandizdar.hrms.business.abstracts.AuthService;
import hakandizdar.hrms.business.abstracts.EmployerService;
import hakandizdar.hrms.business.abstracts.JobSeekerService;
import hakandizdar.hrms.business.abstracts.UserService;
import hakandizdar.hrms.core.utilities.adapters.ValidationService;
import hakandizdar.hrms.core.utilities.results.ErrorResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.entities.concretes.Employer;
import hakandizdar.hrms.entities.concretes.JobSeeker;

public class AuthManager implements AuthService {
	
	private UserService userService;
	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private ValidationService validationService;
	
	
	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobSeekerService jobSeekerService,
			ValidationService validationService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.validationService = validationService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if (!checkEmployerMissingInfo(employer)) {
			return new ErrorResult("Lütfen tüm bilgileri eksiksiz giriniz");
		}
		else if (!checkIfEmailExists(employer.getEmail())) {	
			return new ErrorResult(employer.getEmail() + "sistemde zaten kayıtlı");
		}
		else if (!checkIfEqualMailAndWebSiteAdress(employer.getEmail(), employer.getWebsiteAdress())) {		
			return new ErrorResult("Lütfen web site domaininize ait bir mail giriniz");
		}	
		else if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Girdiğiniz parolalar birbiri ile uyuşmuyor");
		}else {
			employerService.add(employer);
			return new SuccessResult("İşveren başarıyla kaydedildi");
		}
	
	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword) {
		if (checkIfRealPerson(jobSeeker) == false) {
			return new ErrorResult("Kimlik doğrulama başarısız. Lütfen doğru bilgileri giridğinizden emin olunuz");
		}
		else if (!checkIfEmailExists(jobSeeker.getEmail())) {	
			return new ErrorResult(jobSeeker.getEmail() + "sistemde zaten kayıtlı");
		}	
		else if (!checkJobSeekerMissingInfo(jobSeeker, confirmPassword)) {	
			return new ErrorResult("Lütfen tüm bilgileri eksiksiz giriniz");
		}
		else if (!checkIfNationalIdExist(jobSeeker.getNationality())) {	
			return new ErrorResult(jobSeeker.getNationality() + "zaten kayıtlı");
		}
		else if (!checkIfEqualPasswordAndConfirmPassword(jobSeeker.getPassword(), confirmPassword)) {
			return new ErrorResult("Girdiğiniz parolalar birbiri ile uyuşmuyor");
		}else {
			jobSeekerService.add(jobSeeker);
			return new SuccessResult("İş arayan başarıyla eklendi.");
		}
		
	}
	
	
	private boolean checkIfEqualMailAndWebSiteAdress(String email,String website) {
		String[] value = email.split("@", 2);	
		String domain = website.substring(4, website.length());
		if (value[1].equals(domain)) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfEmailExists(String email) {
		if (this.userService.getUserByEmail(email).getData() == null) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		if (validationService.mernisValidate(jobSeeker)) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfNationalIdExist(String nationalIdentity) {
		if (jobSeekerService.findJobSeekerByNationalIdentity(nationalIdentity).getData() == null) {	
			return true;
		}
		return false;
	}
	
	
	private boolean checkEmployerMissingInfo(Employer employer) {
		if (employer.getEmail() != null &&
				employer.getPassword() != null &&
				employer.getWebsiteAdress() != null && 
				employer.getCompanyName() != null && 
				employer.getPhoneNumber() != null 
				) {
			return true;
		}
		return false;
	}
	
	
	private boolean checkJobSeekerMissingInfo(JobSeeker jobSeeker,String confirmPassword) {
		if (jobSeeker.getNationality() != null && 
				jobSeeker.getFirstName() != null && 
				jobSeeker.getLastName() != null && 
				jobSeeker.getEmail() != null && 	
				jobSeeker.getDateOfBirth() != null && 
				jobSeeker.getPassword() != null && 
				confirmPassword != null) {		
			return true;
		}
		return false;
	}

}
