package kodlamaio.hrms.core.adapters;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudServiceAdapter implements CloudService{

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudServiceAdapter(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<?> upload(MultipartFile multipartFile) {
		try {
			Map<?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<>(uploadResult);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>();
		}
	}

	@Override
	public DataResult<?> delete(String publicIdOfImage) {
		List<String> publicIdsOfImages = new ArrayList<String>();
		publicIdsOfImages.add(publicIdOfImage);
		
		try {			
			Map<?, ?> deleteResult = cloudinary.api().deleteResources(publicIdsOfImages, ObjectUtils.emptyMap());
			return new SuccessDataResult<>(deleteResult);
		} catch (Throwable e) {
			e.printStackTrace();
			return new ErrorDataResult<>();
		}
	}
}
