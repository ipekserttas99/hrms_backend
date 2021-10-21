package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService{

	private EmployersDao employersDao;
	
	@Autowired
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}


	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>
		(this.employersDao.findAll(),"Data listelendi");
	}


	@Override
	public Result add(Employers employers) {
		this.employersDao.save(employers);
		return new SuccessResult("İş veren eklendi");
	}


	@Override
	public DataResult<List<Employers>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"sirketAdı");
		return new SuccessDataResult<List<Employers>>
		(this.employersDao.findAll(sort),"Başarılı");
	}


	@Override
	public DataResult<List<Employers>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Employers>>
		(this.employersDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<Employers> getByŞirketAdıAndWebSitesi(String sirketAdı, String webSitesi) {
		return new SuccessDataResult<Employers>
		(this.employersDao.getBySirketAdıAndWebSitesi(sirketAdı, webSitesi));
	}


	@Override
	public DataResult<Employers> getByŞirketAdıOrUser_Id(String sirketAdı, int id) {
		return new SuccessDataResult<Employers>
		(this.employersDao.getBySirketAdıOrUser_Id(sirketAdı, id));
	}


	@Override
	public DataResult<List<Employers>> GetByŞirketAdıAndUser(String sirketAdı, int id) {
		return new SuccessDataResult<List<Employers>>
		(this.employersDao.GetBySirketAdıAndUser(sirketAdı, id));
	}

}
