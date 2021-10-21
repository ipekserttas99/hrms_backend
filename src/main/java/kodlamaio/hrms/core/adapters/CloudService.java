package kodlamaio.hrms.core.adapters;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudService {
	DataResult<?> upload(MultipartFile multipartFile);
	
	DataResult<?> delete(String publicIdOfImage);

}