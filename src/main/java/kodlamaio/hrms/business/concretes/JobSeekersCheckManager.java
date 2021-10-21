package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersCheckService;
import kodlamaio.hrms.core.verifications.abstracts.MernisVerificateService;
import kodlamaio.hrms.entities.concretes.JobSeekers;
@Service
public class JobSeekersCheckManager implements JobSeekersCheckService{

	
	private MernisVerificateService mernisVerificateService;
	@Autowired
	public JobSeekersCheckManager(MernisVerificateService mernisVerificateService) {
		this.mernisVerificateService = mernisVerificateService;
	}

	@Override
	public boolean allFieldsAreRequired(JobSeekers jobSeekers) {
		 if (jobSeekers.getAd().strip().isEmpty()
	                || jobSeekers.getSoyad().strip().isEmpty()
	                || jobSeekers.getTcNo().isEmpty()
	                || jobSeekers.getDogumYılı().isEmpty()) {
	            return false;
	        }
		 else {
	            return true;
	        }
	}


	@Override
	public String allMatch(JobSeekers jobSeekers) {
		String errorMessage = "";
		boolean checkFields = allFieldsAreRequired(jobSeekers);
		boolean checkJobSeeker = checkJobSeeker(jobSeekers);
		if(!checkFields || !checkJobSeeker) {
			if(!checkFields) {
				errorMessage += "Lütfen tüm alanları doldurunuz! ";
			}
			if(!checkJobSeeker) {
				  errorMessage += "Bilgilerinizi kontrol ediniz! ";
			}
		}
		return errorMessage;
	}

	@Override
	public boolean checkJobSeeker(JobSeekers jobSeekers) {
		return this.mernisVerificateService.checkIfRealPerson(jobSeekers);
	}

}
