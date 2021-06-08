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
import hakandizdar.hrms.business.abstracts.JobSeekerSocialPlatformService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobSeekerSocialPlatform;

@RestController
@RequestMapping("/api/jobseekersocialplatforms")
@CrossOrigin
public class JobSeekerSocialPlatformsController {

	private JobSeekerSocialPlatformService jobSeekerSocialPlatformService;

	@Autowired
	public JobSeekerSocialPlatformsController(JobSeekerSocialPlatformService jobSeekerSocialPlatformService) {
		super();
		this.jobSeekerSocialPlatformService = jobSeekerSocialPlatformService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerSocialPlatform jobSeekerSkillSocialPlatform) {
		return this.jobSeekerSocialPlatformService.add(jobSeekerSkillSocialPlatform);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeekerSocialPlatform>> getAll(){	
		return this.jobSeekerSocialPlatformService.getAll();
	}
	
	@GetMapping("/getallByJobSeekerId")
	public DataResult<List<JobSeekerSocialPlatform>> getAllByJobSeekerId(@RequestParam int jobSeekerId){	
		return this.jobSeekerSocialPlatformService.getAllByJobSeekerId(jobSeekerId);
	}
}
