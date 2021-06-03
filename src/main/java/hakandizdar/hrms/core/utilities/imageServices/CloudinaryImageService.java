package hakandizdar.hrms.core.utilities.imageServices;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import hakandizdar.hrms.core.utilities.results.DataResult;

public interface CloudinaryImageService {
	@SuppressWarnings("rawtypes")
	DataResult<Map> upload(MultipartFile file);
}
