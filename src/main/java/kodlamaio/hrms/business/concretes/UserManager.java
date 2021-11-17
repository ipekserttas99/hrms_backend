package kodlamaio.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;

@Service
public class UserManager extends BaseManager<UserDao, User, Integer> implements UserService{
	private final UserDao userDao;

	@Autowired
	public UserManager(final UserDao userDao) {
		super(userDao, "User");
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		final Optional<User> user = userDao.findByEmail(email);

		if (user.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("User"));

		return new SuccessDataResult<>(user.get());
	}

	@Override
	public Result isNotEmailExist(String email) {
		return userDao.findByEmail(email).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.verified("A user with the mail"));
	}
}
