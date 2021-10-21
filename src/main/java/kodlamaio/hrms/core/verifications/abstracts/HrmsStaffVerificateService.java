package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface HrmsStaffVerificateService {
	Result approve(Employers employers);
}

