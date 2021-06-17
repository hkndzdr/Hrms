package hakandizdar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hakandizdar.hrms.business.abstracts.WorkScheduleService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.WorkSchedule;

@RestController
@RequestMapping("/api/workschedules")
@CrossOrigin
public class WorkSchedulesController {
	
	private WorkScheduleService workScheduleService;

	@Autowired
	public WorkSchedulesController(WorkScheduleService workScheduleService) {
		this.workScheduleService = workScheduleService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkSchedule workSchedule) {
		return this.workScheduleService.add(workSchedule);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkSchedule>> getAll() {
		return this.workScheduleService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<WorkSchedule> getById(int id) {
		return this.workScheduleService.getById(id);
	}
}