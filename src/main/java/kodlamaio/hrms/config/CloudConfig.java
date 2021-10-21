package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.adapters.CloudService;
import kodlamaio.hrms.core.adapters.CloudServiceAdapter;

@Configuration
public class CloudConfig {
	@Bean
	public Cloudinary cloudinaryAccount() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "deoersguu",
				"api_key", "453782418893178",
				"api_secret", "STGIuusaOHfzQmeWrTf_LZgqoaw"
				));
	}
	
	@Bean
	public CloudService cloudStorageService() {
		return new CloudServiceAdapter(cloudinaryAccount());
	}
}
