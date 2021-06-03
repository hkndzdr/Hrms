package hakandizdar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hakandizdar.hrms.business.abstracts.ImageService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.entities.concretes.Image;
import hakandizdar.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody MultipartFile file, @RequestParam int jobSeekerId) {
	    Image image = new Image();
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setId(jobSeekerId);
		image.setJobSeeker(jobSeeker);
		return ResponseEntity.ok(this.imageService.add(image, file));
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){	
		return this.imageService.getAll();
	}
	
	@GetMapping("/getallByJobSeekerId")
	public DataResult<List<Image>> getAllByJobSeekerId(@RequestParam int id){	
		return this.imageService.getAllByJobSeekerId(id);
	}


}
