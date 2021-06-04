package hakandizdar.hrms.core.utilities.imageServices.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hakandizdar.hrms.core.utilities.imageServices.CloudinaryImageService;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.ErrorDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageManager implements CloudinaryImageService{
	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryImageManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "katre",
				"api_key", "872793125567218", "api_secret","Hq3pF6A-Dh879cUbGrN05KjjmNA"));
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Override
	public DataResult<Map> upload(MultipartFile file) {
		
		Map uploadResult = null;
		 try {
			 	
	            uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
	            return new SuccessDataResult<Map>(uploadResult,"Resim eklendi");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return new ErrorDataResult<Map>(uploadResult,"Resim ekleme hatası");
	}

}
