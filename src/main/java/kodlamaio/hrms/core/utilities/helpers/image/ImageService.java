package kodlamaio.hrms.core.utilities.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.entities.Image;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface ImageService {
	DataResult<Image> save(MultipartFile file);

	Result delete(String id);
}
