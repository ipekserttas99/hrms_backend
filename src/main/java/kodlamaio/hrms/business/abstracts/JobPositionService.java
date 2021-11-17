package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService extends BaseService<JobPosition, Integer>{
	Result isNotExistsJobPosition(final String title);
}
