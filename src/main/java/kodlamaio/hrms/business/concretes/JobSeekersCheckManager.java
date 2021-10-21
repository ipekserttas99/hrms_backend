package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersCheckService;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersCheckManager implements JobSeekersCheckService{


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
		if(!checkFields) {
			errorMessage += "Lütfen tüm alanları doldurunuz! ";
		}
		return errorMessage;
	}


}
