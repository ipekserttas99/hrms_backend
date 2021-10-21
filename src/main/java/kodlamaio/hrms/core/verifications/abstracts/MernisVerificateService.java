package kodlamaio.hrms.core.verifications.abstracts;


import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface MernisVerificateService {
	boolean checkIfRealPerson(JobSeekers jobSeekers);

}