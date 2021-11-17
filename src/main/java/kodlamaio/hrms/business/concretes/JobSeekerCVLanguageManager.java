package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVLanguageService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCVLanguage;

@Service
public class JobSeekerCVLanguageManager extends BaseManager<JobSeekerCVLanguageDao, JobSeekerCVLanguage, Integer>
		implements JobSeekerCVLanguageService{
	private final JobSeekerCVLanguageDao jobSeekerCVLanguageDao;

	@Autowired
	public JobSeekerCVLanguageManager(final JobSeekerCVLanguageDao jobSeekerCVLanguageDao) {
		super(jobSeekerCVLanguageDao, "Job seeker CV language");
		this.jobSeekerCVLanguageDao = jobSeekerCVLanguageDao;
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVLanguages);
	}
	
	
}
