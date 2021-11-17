package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;

@RestController
@RequestMapping("/api/jobseekers/cvs")
public class JobSeekerCVsController extends BaseController<JobSeekerCVService, JobSeekerCV, Integer> {
	private final JobSeekerCVService jobSeekerCVService;

	@Autowired
	public JobSeekerCVsController(final JobSeekerCVService jobSeekerCVService) {
		super(jobSeekerCVService);
		this.jobSeekerCVService = jobSeekerCVService;
	}

	@GetMapping("/byjobseekerid")
	public ResponseEntity<DataResult<JobSeekerCV>> getByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<JobSeekerCV> result = jobSeekerCVService.getByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}
}
