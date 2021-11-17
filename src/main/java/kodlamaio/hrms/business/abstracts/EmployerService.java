package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForUpdateDto;

public interface EmployerService extends BaseService<Employer, Integer>{
	DataResult<EmployerUpdate> getLastUpdateByUserId(int employerId);

	DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted);

	Result isNotCorporateEmailExist(String corporateEmail);

	Result register(EmployerForRegisterDto employerForRegister);

	Result updateByUser(EmployerForUpdateDto employerForUpdateDto, MultipartFile companyImage);

	Result verifyUpdate(int employerUpdateId);

	Result denyUpdate(final int employerUpdateId);
}
