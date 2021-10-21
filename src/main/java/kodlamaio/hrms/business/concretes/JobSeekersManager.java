package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService{

	private JobSeekersDao jobSeekersDao;
	
	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao) {
		super();
		this.jobSeekersDao = jobSeekersDao;
	}


	@Override
	public DataResult<List<JobSeekers>> getAll() {
		return new SuccessDataResult<List<JobSeekers>>
		(this.jobSeekersDao.findAll(),"Data listelendi");
	}


	@Override
	public Result add(JobSeekers jobSeekers) {
		this.jobSeekersDao.save(jobSeekers);
		return new SuccessResult("İş arayan eklendi");
	}


	@Override
	public DataResult<List<JobSeekers>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobSeekers>>
		(this.jobSeekersDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<JobSeekers> getByAdAndSoyad(String ad, String soyad) {
		return new SuccessDataResult<JobSeekers>
		(this.jobSeekersDao.getByAdAndSoyad(ad, soyad));
	}


	@Override
	public DataResult<List<JobSeekers>> getByAdOrUser_id(String ad, int id) {
		return new SuccessDataResult<List<JobSeekers>>
		(this.jobSeekersDao.getByAdOrUser_id(ad, id));
	}


	@Override
	public DataResult<List<JobSeekers>> getByTcNoContains(String tcNo) {
		return new SuccessDataResult<List<JobSeekers>>
		(this.jobSeekersDao.getByTcNoContains(tcNo));
	}


	@Override
	public DataResult<List<JobSeekers>> GetByAdAndUser(String ad, int id) {
		return new SuccessDataResult<List<JobSeekers>>
		(this.jobSeekersDao.GetByAdAndUser(ad, id));
	}

}
