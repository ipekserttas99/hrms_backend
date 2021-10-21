package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserCheckService {
	boolean checkMail(User user);
	Result checkVerifiedMail(User user);
	boolean checkPassword(User user);
	String allMatch(User user);
}
