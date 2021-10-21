package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.verifications.abstracts.HrmsStaffVerificateService;
import kodlamaio.hrms.entities.concretes.Employers;
@Service
public class EmployersCheckManager implements EmployersCheckService{
	
	private HrmsStaffVerificateService hrmsStaffVerificateService;
	
	@Autowired
	public EmployersCheckManager(HrmsStaffVerificateService hrmsStaffVerificateService) {
		this.hrmsStaffVerificateService = hrmsStaffVerificateService;
	}

	
	@Override
	public boolean allFieldsAreRequired(Employers employers) {
		if(employers.getSirketAdı().strip().isEmpty()
				|| employers.getTelefon().isEmpty()
				|| employers.getWebSitesi().isEmpty()) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public Result checkAddedEmployers(Employers employers) {
		return this.hrmsStaffVerificateService.approve(employers);
	}

	@Override
	public String allMatch(Employers employers) {
		String errorMessage = "";
		boolean checkFields = allFieldsAreRequired(employers);
		boolean checkAddedEmployers = false;
		if(checkAddedEmployers(employers).isSuccess()) {
			checkAddedEmployers = true;
		}else if(!checkAddedEmployers(employers).isSuccess()) {
			checkAddedEmployers = false;
		}
		
		if(!checkFields || checkAddedEmployers==false) {
			if(!checkFields) {
				errorMessage += "Lütfen tüm alanları doldurunuz! ";
			}
			if(!checkAddedEmployers) {
				  errorMessage += "Bilgilerinizi kontrol ediniz! ";
			}
		}
		return errorMessage;
	}

}
