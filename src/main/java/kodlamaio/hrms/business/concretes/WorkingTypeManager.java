package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTypeDao;
import kodlamaio.hrms.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager extends BaseManager<WorkingTypeDao, WorkingType, Short> implements WorkingTypeService{
	public WorkingTypeManager(final WorkingTypeDao workingTypeDao) {
		super(workingTypeDao, "Working type");
	}
}
