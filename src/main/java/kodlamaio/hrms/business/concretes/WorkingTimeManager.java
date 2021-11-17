package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrms.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager extends BaseManager<WorkingTimeDao, WorkingTime, Short> implements WorkingTimeService {
	public WorkingTimeManager(final WorkingTimeDao workingTimeDao) {
		super(workingTimeDao, "Working time");
	}
}
