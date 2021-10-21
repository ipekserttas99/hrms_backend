package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;


public interface MailVerificationService {
	Result verificate(User user);
}