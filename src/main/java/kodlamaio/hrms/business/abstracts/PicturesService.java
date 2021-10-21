package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Pictures;

public interface PicturesService {
	Result add(Pictures pictures);
	DataResult<Pictures> getByUser_Id(int id);
	DataResult<List<Pictures>> GetByUser(int id);
}
