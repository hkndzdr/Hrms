package hakandizdar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hakandizdar.hrms.business.abstracts.StaffService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.Staff;

	@RestController
	@RequestMapping("/api/staffs")
	@CrossOrigin
	public class StaffsController {
		
		private StaffService staffService;
		
		@Autowired
		public StaffsController(StaffService staffService) {
			super();
			this.staffService = staffService;
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody Staff staff) {
			return this.staffService.add(staff);
		}
		
		@GetMapping("/getAll")
		public DataResult<List<Staff>> getAll(){	
			return this.staffService.getAll();
		}
	}			
