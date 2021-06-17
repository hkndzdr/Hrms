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

import hakandizdar.hrms.business.abstracts.JobSeekerSkillService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobSeekerSkill;

@RestController
@RequestMapping("/api/jobseekerskills")
@CrossOrigin
public class JobSeekerSkillsController {

	private JobSeekerSkillService jobSeekerSkillService;

	@Autowired
	public JobSeekerSkillsController(JobSeekerSkillService jobSeekerSkillService) {
		super();
		this.jobSeekerSkillService = jobSeekerSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerSkill jobSeekerSkill) {
		return this.jobSeekerSkillService.add(jobSeekerSkill);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerSkill>> getAll(){	
		return this.jobSeekerSkillService.getAll();
	}
	
	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(@RequestParam int jobSeekerId){	
		return this.jobSeekerSkillService.getAllByJobSeekerId(jobSeekerId);
	}
	
}
