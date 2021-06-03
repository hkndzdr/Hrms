package hakandizdar.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hakandizdar.hrms.business.abstracts.ImageService;
import hakandizdar.hrms.core.utilities.imageServices.CloudinaryImageService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.ImageDao;
import hakandizdar.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private CloudinaryImageService cloudinaryImageService;
	
	
	public ImageManager(ImageDao imageDao, CloudinaryImageService cloudinaryImageService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryImageService = cloudinaryImageService;
	}


	@Override
	public Result add(Image image, MultipartFile file) {
		@SuppressWarnings("unchecked")
		Map<String,String> img = this.cloudinaryImageService.upload(file).getData();
		image.setUrl(img.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Resim eklendi");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}


	@Override
	public DataResult<List<Image>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Image>>(this.imageDao.getAllByJobSeekerId(jobSeekerId));
	}







}
