package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Schools;

public interface SchoolsService {
	Result add(Schools schools);
	DataResult<Schools> getByOkulAd(String okulAd);
	DataResult<Schools> getByBitişYıl(String bitişYıl);
	DataResult<List<Schools>> GetByBitişYılAndUser(String bitişYıl, int id);
}
