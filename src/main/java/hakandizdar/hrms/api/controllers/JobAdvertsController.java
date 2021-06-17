package hakandizdar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hakandizdar.hrms.business.abstracts.JobAdvertService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.JobAdvert;
import hakandizdar.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getAllSorted")
	DataResult<List<JobAdvert>> getAllSorted() {
		return this.jobAdvertService.getAllSorted();
	}
	
	@PostMapping("/getAllByCompanyName")
	DataResult<List<JobAdvert>> getAllByCompanyName(@RequestParam String companyName) {
		return this.jobAdvertService.getAllByCompanyName(companyName);
	}
	
	@GetMapping("/getAllByCompanyId")
	DataResult<List<JobAdvert>> getAllByCompanyId(@RequestParam int id) {
		return this.jobAdvertService.getAllByCompanyId(id);
	}
	
	@PutMapping("/activate")
	Result activate(@RequestParam("id") int id, @RequestParam("isActive") boolean status) {
		return this.jobAdvertService.activate(id, status);
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobAdvertDto jobAdvertDto) {
		return this.jobAdvertService.add(jobAdvertDto);
	}
	
	@GetMapping("/getAllPassiveJobs")
	public DataResult<List<JobAdvert>> getAllByIsActiveFalse() {
		return this.jobAdvertService.getAllByIsActiveFalse();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(@RequestParam int id) {
		return this.jobAdvertService.getById(id);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.delete(jobAdvert);
	}
}
