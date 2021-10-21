package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skills;

public interface SkillsService {
	Result add(Skills skills);
	DataResult<Skills> getByYetenekAdı(String yetenekAdı);
	DataResult<Skills> getByYetenekAdıOrUser_Id(String yetenekAdı, int id);
}
