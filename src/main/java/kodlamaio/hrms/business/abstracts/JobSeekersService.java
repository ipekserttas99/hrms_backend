package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersService {
	DataResult<List<JobSeekers>> getAll();
	DataResult<List<JobSeekers>> getAll(int pageNo, int pageSize);
	Result add(JobSeekers jobSeekers);
	
	DataResult<JobSeekers> getByAdAndSoyad(String ad, String soyad);
	DataResult<List<JobSeekers>> getByAdOrUser_id(String ad, int id);
	DataResult<List<JobSeekers>> getByTcNoContains(String tcNo);
	DataResult<List<JobSeekers>> GetByAdAndUser(String ad, int id);
}
