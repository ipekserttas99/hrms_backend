package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Cv;

public interface CvService {
	DataResult<Cv> findByJobSeekersId(int id);
}
