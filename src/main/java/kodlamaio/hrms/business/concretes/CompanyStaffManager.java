package kodlamaio.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.business.abstracts.CompanyStaffService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CompanyStaffDao;
import kodlamaio.hrms.entities.concretes.CompanyStaff;
import kodlamaio.hrms.entities.dtos.CompanyStaffForUpdateDto;

@Service
public class CompanyStaffManager extends BaseManager<CompanyStaffDao, CompanyStaff, Integer>
		implements CompanyStaffService{
	private final CompanyStaffDao companyStaffDao;

	@Autowired
	public CompanyStaffManager(final CompanyStaffDao companyStaffDao) {
		super(companyStaffDao, "Company staff");
		this.companyStaffDao = companyStaffDao;
	}
	
	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
	}
	
	@Override
	public Result updateByUser(CompanyStaffForUpdateDto companyStaffForUpdateDto) {
		final Optional<CompanyStaff> companyStaff = companyStaffDao.findById(companyStaffForUpdateDto.getId());
		if (companyStaff.isEmpty())
			return new ErrorResult(Messages.notFound("Company staff"));

		final Result businessRulesResult = BusinessRules
				.run(arePasswordMatch(companyStaff.get().getPassword(), companyStaffForUpdateDto.getPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		companyStaff.get().setFirstName(companyStaffForUpdateDto.getFirstName());
		companyStaff.get().setLastName(companyStaffForUpdateDto.getLastName());
		companyStaffDao.save(companyStaff.get());

		return new SuccessResult(Messages.updated("Company Staff"));
	}

}
