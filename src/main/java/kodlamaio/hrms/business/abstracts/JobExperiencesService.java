package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperiences;

public interface JobExperiencesService {
	DataResult<JobExperiences> getByİşYeriAdıAndPozisyon(String işYeriAdı, String pozisyon);
	DataResult<JobExperiences> getByBitişYıl(String bitişYıl);
	DataResult<List<JobExperiences>> GetByBitişYılAndUser(String bitişYıl, int id);
	Result add(JobExperiences jobExperiences);
}
