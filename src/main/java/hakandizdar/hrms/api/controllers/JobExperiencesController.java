package hakandizdar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hakandizdar.hrms.business.abstracts.JobExperienceService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperince) {
		return this.jobExperienceService.add(jobExperince);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll(){	
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getallByJobSeekerIdOrderByLeaveYearDesc")
	public DataResult<List<JobExperience>> getAllByJobSeekerIdOrderByGraduationYearDesc(@RequestParam int jobSeekerId){	
		return this.jobExperienceService.getAllByJobSeekerIdOrderByLeaveYearDesc(jobSeekerId);
	}
	
}
