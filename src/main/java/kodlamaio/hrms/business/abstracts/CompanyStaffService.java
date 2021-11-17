package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CompanyStaff;
import kodlamaio.hrms.entities.dtos.CompanyStaffForUpdateDto;

public interface CompanyStaffService extends BaseService<CompanyStaff, Integer>{
	Result updateByUser(CompanyStaffForUpdateDto companyStaffForUpdateDto);
}
