package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersCheckService {
	boolean allFieldsAreRequired(JobSeekers jobSeekers);
	String allMatch(JobSeekers jobSeekers);
	boolean checkJobSeeker(JobSeekers jobSeekers);
}
