package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguagesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguagesDao;
import kodlamaio.hrms.entities.concretes.Languages;
@Service
public class LanguagesManager implements LanguagesService{
	
	private LanguagesDao languagesDao;
	
	@Autowired
	public LanguagesManager(LanguagesDao languagesDao) {
		super();
		this.languagesDao = languagesDao;
	}

	@Override
	public Result add(Languages languages) {
		this.languagesDao.save(languages);
		return new SuccessResult("Yabancı dil eklendi");
	}

	@Override
	public DataResult<Languages> getByDil(String dil) {
		return new SuccessDataResult<Languages>
		(this.languagesDao.getByDil(dil));
	}

	@Override
	public DataResult<Languages> getByLevel(String level) {
		return new SuccessDataResult<Languages>
		(this.languagesDao.getByLevel(level));
	}

	@Override
	public DataResult<Languages> getByDilOrUser_Id(String dil, int id) {
		return new SuccessDataResult<Languages>
		(this.languagesDao.getByDilOrUser_Id(dil, id));
	}

	@Override
	public DataResult<List<Languages>> GetByDilAndUser(String dil, int id) {
		return new SuccessDataResult<List<Languages>>
		(this.languagesDao.GetByDilAndUser(dil, id));
	}

}
