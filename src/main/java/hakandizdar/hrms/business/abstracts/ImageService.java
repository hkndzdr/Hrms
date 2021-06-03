package hakandizdar.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.entities.concretes.Image;

public interface ImageService {
	  Result add(Image image, MultipartFile file);
	  DataResult<List<Image>> getAll();
	  DataResult<List<Image>> getAllByJobSeekerId(int jobSeekerId);
}
