package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperiencesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperiencesDao;
import kodlamaio.hrms.entities.concretes.JobExperiences;
@Service
public class JobExperiencesManager implements JobExperiencesService{

	private JobExperiencesDao jobExperiencesDao;
	
	@Autowired
	public JobExperiencesManager(JobExperiencesDao jobExperiencesDao) {
		super();
		this.jobExperiencesDao = jobExperiencesDao;
	}

	@Override
	public DataResult<JobExperiences> getByİşYeriAdıAndPozisyon(String işYeriAdı, String pozisyon) {
		return new SuccessDataResult<JobExperiences>
		(this.jobExperiencesDao.getByİşYeriAdıAndPozisyon(işYeriAdı, pozisyon));
	}

	@Override
	public DataResult<JobExperiences> getByBitişYıl(String bitişYıl) {
		return new SuccessDataResult<JobExperiences>
		(this.jobExperiencesDao.getByBitişYıl(bitişYıl));
	}

	@Override
	public DataResult<List<JobExperiences>> GetByBitişYılAndUser(String bitişYıl, int id) {
		return new SuccessDataResult<List<JobExperiences>>
		(this.jobExperiencesDao.GetByBitişYılAndUser(bitişYıl, id));
	}

	@Override
	public Result add(JobExperiences jobExperiences) {
		this.jobExperiencesDao.save(jobExperiences);
		return new SuccessResult("İş deneyimi eklendi");
	}

}
