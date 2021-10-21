package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.MailVerificationService;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserCheckManager implements UserCheckService{

	private MailVerificationService mailVerificationService;
	
	@Autowired
	public UserCheckManager(MailVerificationService mailVerificationService) {
		this.mailVerificationService = mailVerificationService;
	}

	@Override
	public boolean checkMail(User user) {
		if(user.getEmail().isEmpty()) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public Result checkVerifiedMail(User user) {
		this.mailVerificationService.verificate(user);
		return new SuccessResult("Mail doğrulandı");
	}

	@Override
	public boolean checkPassword(User user) {
		if(!user.getPassword().isEmpty() && !user.getPasswordAgain().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String allMatch(User user) {
		String errorMessage = "";
		boolean checkMail = checkMail(user);
		boolean checkPassword = checkPassword(user);
		if(!checkMail || !checkPassword) {
			if(!checkMail) {
				errorMessage += "Mailinizi giriniz!  ";
			}
			if(!checkPassword) {
				errorMessage += "Parolanızı giriniz! ";
			}
		}
		return errorMessage;
	}

}
