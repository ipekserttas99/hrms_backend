package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Data listelendi");
	}


	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Ürün eklendi");
	}


	@Override
	public DataResult<List<User>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "email");
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(sort),"Başarılı");
	}


	@Override
	public DataResult<List<User>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<User> getByUserEmail(String email) {
		return new SuccessDataResult<User>
		(this.userDao.getByUserEmail(email),"Data listelendi");
	}

}