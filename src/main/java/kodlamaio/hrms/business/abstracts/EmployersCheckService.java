package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersCheckService {
	boolean allFieldsAreRequired(Employers employers);
    Result checkAddedEmployers(Employers employers);
    String allMatch(Employers employers);
}
