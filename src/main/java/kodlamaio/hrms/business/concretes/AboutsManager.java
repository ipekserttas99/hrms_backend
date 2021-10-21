package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.AboutsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AboutsDao;
import kodlamaio.hrms.entities.concretes.Abouts;
@Service
public class AboutsManager implements AboutsService{

	private AboutsDao aboutsDao;
	
	@Autowired
	public AboutsManager(AboutsDao aboutsDao) {
		super();
		this.aboutsDao = aboutsDao;
	}

	@Override
	public DataResult<Abouts> getByÖnYazıOrUser_Id(String önYazı, int id) {
		return new SuccessDataResult<Abouts>
		(this.aboutsDao.getByÖnYazıOrUser_Id(önYazı, id));
	}

	@Override
	public Result add(@RequestBody Abouts abouts) {
		this.aboutsDao.save(abouts);
		return new SuccessResult("Hakkında eklendi");
	}

}
