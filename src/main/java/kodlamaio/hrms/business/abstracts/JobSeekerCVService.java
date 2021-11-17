package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;

public interface JobSeekerCVService extends BaseService<JobSeekerCV, Integer>{
	DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId);
}
