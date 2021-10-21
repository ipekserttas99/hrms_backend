package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Languages;

public interface LanguagesService {
	Result add(Languages languages);
	DataResult<Languages> getByDil(String dil);
	DataResult<Languages> getByLevel(String level);
	DataResult<Languages> getByDilOrUser_Id(String dil, int id);
	DataResult<List<Languages>> GetByDilAndUser(String dil, int id);
}
