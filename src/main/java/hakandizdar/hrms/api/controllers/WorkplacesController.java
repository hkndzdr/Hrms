package hakandizdar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hakandizdar.hrms.business.abstracts.WorkplaceService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.Workplace;

@RestController
@RequestMapping("/api/workplaces")
@CrossOrigin
public class WorkplacesController {
	
	private WorkplaceService workplaceService;

	@Autowired
	public WorkplacesController(WorkplaceService workplaceService) {
		this.workplaceService = workplaceService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Workplace workplace) {
		return this.workplaceService.add(workplace);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Workplace>> getAll() {
		return this.workplaceService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Workplace> getById(int id) {
		return this.workplaceService.getById(id);
	}
}