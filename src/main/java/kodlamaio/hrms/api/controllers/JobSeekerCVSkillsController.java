package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVSkillService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeekerCVSkill;

@RestController
@RequestMapping("/api/jobseekers/cvs/skills")
public class JobSeekerCVSkillsController extends BaseController<JobSeekerCVSkillService, JobSeekerCVSkill, Integer> {
	private final JobSeekerCVSkillService jobSeekerCVSkillService;

	@Autowired
	public JobSeekerCVSkillsController(final JobSeekerCVSkillService jobSeekerCVSkillService) {
		super(jobSeekerCVSkillService);
		this.jobSeekerCVSkillService = jobSeekerCVSkillService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVSkill>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVSkill>> result = jobSeekerCVSkillService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}
