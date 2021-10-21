package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	
	private JobSeekersService jobSeekersService;

	@Autowired
	public JobSeekersController(JobSeekersService jobSeekersService) {
		this.jobSeekersService = jobSeekersService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeekers>> getAll(){
		return this.jobSeekersService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekers jobSeekers) {
		return this.jobSeekersService.add(jobSeekers);
	}
	
	@GetMapping("/getByAdAndSoyad")
	public DataResult<JobSeekers> getByAdAndSoyad(String ad, String soyad) {
		return this.jobSeekersService.getByAdAndSoyad(ad, soyad);
	}
	
	@GetMapping("/getByTcNoContains")
	public DataResult<List<JobSeekers>> getByTcNoContains(String tcNo) {
		return this.jobSeekersService.getByTcNoContains(tcNo);
	}
	
	@GetMapping("/GetByAdAndUser")
	public DataResult<List<JobSeekers>> GetByAdAndUser(String ad, int id) {
		return this.jobSeekersService.GetByAdAndUser(ad, id);
	}
}
