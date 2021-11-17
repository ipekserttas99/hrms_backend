package kodlamaio.hrms.business.concretes;

import java.util.Optional;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyStaffVerificationService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CompanyStaffVerificationDao;
import kodlamaio.hrms.entities.concretes.CompanyStaffVerification;

@Service
public class CompanyStaffVerificationManager extends BaseManager<CompanyStaffVerificationDao, CompanyStaffVerification, Integer>
		implements CompanyStaffVerificationService{
	private final CompanyStaffVerificationDao companyStaffVerificationDao;

	@Autowired
	public CompanyStaffVerificationManager(final CompanyStaffVerificationDao companyStaffVerificationDao) {
		super(companyStaffVerificationDao, "Company staff verification");
		this.companyStaffVerificationDao = companyStaffVerificationDao;
	}
	@Override
	public DataResult<CompanyStaffVerification> getByUserId(int userId) {
		final Optional<CompanyStaffVerification> companyStaffVerification = companyStaffVerificationDao
				.findByUser_Id(userId);

		if (companyStaffVerification.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Company staff verification"));

		return new SuccessDataResult<>(companyStaffVerification.get());
	}

	@Override
	public Result verify(final int userId) {
		final DataResult<CompanyStaffVerification> companyStaffVerification = getByUserId(userId);

		if (!companyStaffVerification.isSuccess())
			return new ErrorResult(Messages.notFound("Company staff verification"));

		companyStaffVerification.getData().setApproved(true);
		companyStaffVerificationDao.save(companyStaffVerification.getData());

		return new SuccessResult(Messages.verified("User"));
	}

}
