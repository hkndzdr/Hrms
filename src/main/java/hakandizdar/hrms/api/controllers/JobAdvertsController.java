package hakandizdar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hakandizdar.hrms.business.abstracts.JobAdvertService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getAllActiveAdverts")
	public DataResult<List<JobAdvert>> getAllActiveAdverts() {
		return this.jobAdvertService.getAllActiveAdverts();
	}
	
	@GetMapping("/getAllActiveAdvertsByReleasedDateByAsc")
	public DataResult<List<JobAdvert>> getAllActiveAdvertsByReleasedDateByAsc() {
		return this.jobAdvertService.getAllActiveAdvertsByReleasedDateByAsc();
	}
	
	@GetMapping("/getAllActiveAdvertsByReleasedDateByDsc")
	public DataResult<List<JobAdvert>> getAllActiveAdvertsByReleasedDateByDsc() {
		return this.jobAdvertService.getAllActiveAdvertsByReleasedDateByAsc();
	}
	
	@GetMapping("/getAllActiveAdvertsByEmployer")
	public DataResult<List<JobAdvert>> getAllActiveAdvertsByEmployer(int employerId) {
		return this.jobAdvertService.getAllActiveAdvertsByEmployer(employerId);
	}
	
	@PostMapping("/changeActiveStatus")
	public Result closeAdvert(int id) {
		return this.jobAdvertService.changeActiveStatus(id);
	}
	
}
