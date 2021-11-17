package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingtimes")
public class WorkingTimesController extends BaseController<WorkingTimeService, WorkingTime, Short> {
	public WorkingTimesController(final WorkingTimeService workingTimeService) {
		super(workingTimeService);
	}
}