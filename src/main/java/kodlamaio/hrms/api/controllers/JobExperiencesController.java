package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperiencesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperiences;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {
	private JobExperiencesService jobExperiencesService;
	@Autowired
	public JobExperiencesController(JobExperiencesService jobExperiencesService) {
		super();
		this.jobExperiencesService = jobExperiencesService;
	}
	
	@PostMapping("/add")
	public Result add(JobExperiences jobExperiences) {
		return this.jobExperiencesService.add(jobExperiences);
	}
	
	@GetMapping("/getByİşYeriAdıAndPozisyon")
	public DataResult<JobExperiences> getByİşYeriAdıAndPozisyon(String işYeriAdı, String pozisyon) {
		return this.jobExperiencesService.getByİşYeriAdıAndPozisyon(işYeriAdı, pozisyon);
	}
	
	@GetMapping("/GetByBitişYılAndUser")
	public DataResult<List<JobExperiences>> GetByBitişYılAndUser(String bitişYıl, int id) {
		return this.jobExperiencesService.GetByBitişYılAndUser(bitişYıl, id);
	}
	
	@GetMapping("/getByBitişYıl")
	public DataResult<JobExperiences> getByBitişYıl(String bitişYıl) {
		return this.jobExperiencesService.getByBitişYıl(bitişYıl);
	}
}
