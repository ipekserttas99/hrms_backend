package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersService {
	DataResult<List<Employers>> getAll();
	DataResult<List<Employers>> getAllSorted();
	DataResult<List<Employers>> getAll(int pageNo, int pageSize);
	Result add(Employers employers);
	
	DataResult<Employers> getByŞirketAdıAndWebSitesi(String sirketAdı, String webSitesi);
	DataResult<Employers> getByŞirketAdıOrUser_Id(String sirketAdı, int id);
	DataResult<List<Employers>> GetByŞirketAdıAndUser(String sirketAdı, int id);
}
