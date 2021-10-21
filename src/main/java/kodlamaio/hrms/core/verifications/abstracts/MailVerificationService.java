package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface MailVerificationService {
	Result verificate(User user);
}