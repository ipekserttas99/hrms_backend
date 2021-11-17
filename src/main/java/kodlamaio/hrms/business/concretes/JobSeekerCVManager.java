package kodlamaio.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;

@Service
public class JobSeekerCVManager extends BaseManager<JobSeekerCVDao, JobSeekerCV, Integer>
		implements JobSeekerCVService{
	private final JobSeekerCVDao jobSeekerCVDao;

	@Autowired
	public JobSeekerCVManager(final JobSeekerCVDao jobSeekerCVDao) {
		super(jobSeekerCVDao, "Job seeker CV");
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

		if (jobSeekerCV.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Job seeker"));

		return new SuccessDataResult<>(jobSeekerCV.get());
	}

	
}
