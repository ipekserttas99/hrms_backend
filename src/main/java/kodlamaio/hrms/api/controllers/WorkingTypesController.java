package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingtypes")
public class WorkingTypesController extends BaseController<WorkingTypeService, WorkingType, Short> {
	public WorkingTypesController(final WorkingTypeService workingTypeService) {
		super(workingTypeService);
	}
}