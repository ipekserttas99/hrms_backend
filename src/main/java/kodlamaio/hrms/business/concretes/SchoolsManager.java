package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolsDao;
import kodlamaio.hrms.entities.concretes.Schools;
@Service
public class SchoolsManager implements SchoolsService{

	private SchoolsDao schoolsDao;
	@Autowired
	public SchoolsManager(SchoolsDao schoolsDao) {
		super();
		this.schoolsDao = schoolsDao;
	}

	@Override
	public Result add(Schools schools) {
		this.schoolsDao.save(schools);
		return new SuccessResult("Okul eklendi");
	}

	@Override
	public DataResult<Schools> getByOkulAd(String okulAd) {
		return new SuccessDataResult<Schools>
		(this.schoolsDao.getByOkulAd(okulAd));
	}

	@Override
	public DataResult<Schools> getByBitişYıl(String bitişYıl) {
		return new SuccessDataResult<Schools>
		(this.schoolsDao.getByBitişYıl(bitişYıl));
	}

	@Override
	public DataResult<List<Schools>> GetByBitişYılAndUser(String bitişYıl, int id) {
		return new SuccessDataResult<List<Schools>>
		(this.schoolsDao.GetByBitişYılAndUser(bitişYıl, id));
	}

}
