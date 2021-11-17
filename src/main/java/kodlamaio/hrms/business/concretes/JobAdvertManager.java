package kodlamaio.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertForListDto;

@Service
public class JobAdvertManager extends BaseManager<JobAdvertDao, JobAdvert, Integer> implements JobAdvertService{
	private final JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(final JobAdvertDao jobAdvertDao) {
		super(jobAdvertDao, "Job advert");
		this.jobAdvertDao = jobAdvertDao;
	}
	
	
	@Override
	public Result verifyById(int id) {
		Optional<JobAdvert> jobAdvert = this.jobAdvertDao.findById(id);
		if (jobAdvert.isEmpty())
			return new ErrorDataResult(Messages.notFound("Job advert"));

		jobAdvert.get().setActive(true);

		return super.update(jobAdvert.get());
	}

	@Override
	public DataResult<Page<JobAdvert>> getAllByIsActive(boolean isActive, int page, int size, String[] sortProperties,
			Direction sortDirection) {
		Page<JobAdvert> jobAdverts = jobAdvertDao.findAllByIsActive(isActive,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdverts);
	}

	@Override
	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName, int page, int size, String[] sortProperties, Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveAndEmployer_CompanyNameForList(
				isActive,
				companyName,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive, int page, int size,
			String[] sortProperties, Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveForList(isActive,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndCityAndWorkingTimeForList(boolean isActive,
			short cityId, short workingTimeId, int page, int size, String[] sortProperties, Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveAndCityAndWorkingTimeForList(
				isActive,
				cityId,
				workingTimeId,
				PageRequest.of(page, size, Sort.by(sortDirection, sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}
	
}
