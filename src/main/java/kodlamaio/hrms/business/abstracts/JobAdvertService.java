package kodlamaio.hrms.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertForListDto;

public interface JobAdvertService extends BaseService<JobAdvert, Integer>{
	Result verifyById(int id);

	DataResult<Page<JobAdvert>> getAllByIsActive(boolean isActive, int page, int size, String[] sortProperties,
			Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName, int page, int size, String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive, int page, int size,
			String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndCityAndWorkingTimeForList(boolean isActive, short cityId,
			short workingTimeId, int page, int size, String[] sortProperties, Sort.Direction sortDirection);
}
