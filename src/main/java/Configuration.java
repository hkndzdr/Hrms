import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hakandizdar.hrms.core.utilities.imageServices.CloudinaryImageService;
import hakandizdar.hrms.core.utilities.imageServices.cloudinary.CloudinaryImageManager;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public CloudinaryImageService cloudinaryImageService() {
		return new CloudinaryImageManager(cloudinary());
	}

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "katre",
				"api_key", "872793125567218", "api_secret","Hq3pF6A-Dh879cUbGrN05KjjmNA"));
	}
}
