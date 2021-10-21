package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.MailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class MailVerificationManager implements MailVerificationService{

	private UserDao userDao;
	
	@Autowired
	public MailVerificationManager(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public Result verificate(User user) {
		this.userDao.getByEmail(user.getEmail());
		return new SuccessResult("Mail doğrulandı");
	}

}