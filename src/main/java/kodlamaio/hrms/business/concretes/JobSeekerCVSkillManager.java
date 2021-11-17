package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVSkillService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVSkillDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCVSkill;

@Service
public class JobSeekerCVSkillManager extends BaseManager<JobSeekerCVSkillDao, JobSeekerCVSkill, Integer>
		implements JobSeekerCVSkillService {
	private final JobSeekerCVSkillDao jobSeekerCVSkillDao;

	@Autowired
	public JobSeekerCVSkillManager(final JobSeekerCVSkillDao jobSeekerCVSkillDao) {
		super(jobSeekerCVSkillDao, "Job seeker CV skill");
		this.jobSeekerCVSkillDao = jobSeekerCVSkillDao;
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVSkills);
	}
	
	
}
