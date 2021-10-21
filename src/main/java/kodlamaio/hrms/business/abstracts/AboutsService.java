package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Abouts;

public interface AboutsService {
	DataResult<Abouts> getByÖnYazıOrUser_Id(String önYazı, int id);
	Result add(Abouts abouts);
}
