package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController extends BaseController<JobPositionService, JobPosition, Integer> {
	@Autowired
	public JobPositionsController(final JobPositionService jobPositionService) {
		super(jobPositionService);
	}
}
