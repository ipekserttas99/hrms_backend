package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertForListDto;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController extends BaseController<JobAdvertService, JobAdvert, Integer> {
	private final JobAdvertService jobAdvertService;
 
	@Autowired
	public JobAdvertsController(final JobAdvertService jobAdvertService) {
		super(jobAdvertService);
		this.jobAdvertService = jobAdvertService;
	}

	@GetMapping({ "/byisactive" })
	public ResponseEntity<DataResult<Page<JobAdvert>>> getAllByIsActive(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvert>> result = this.jobAdvertService
				.getAllByIsActive(isActive, page, size, sortProperties, sortDirection);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/forlist/byisactiveandemployercompanyname" })
	public ResponseEntity<DataResult<Page<JobAdvertForListDto>>> getAllByIsActiveAndEmployer_CompanyNameForList(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam final String companyName,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvertForListDto>> result = this.jobAdvertService
				.getAllByIsActiveAndEmployer_CompanyNameForList(isActive,
						companyName,
						page,
						size,
						sortProperties,
						sortDirection);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/forlist/byisactive" })
	public ResponseEntity<DataResult<Page<JobAdvertForListDto>>> getAllByIsActiveForList(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvertForListDto>> result = this.jobAdvertService
				.getAllByIsActiveForList(isActive, page, size, sortProperties, sortDirection);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/forlist/byisactiveandcityandworkingtime" })
	public ResponseEntity<DataResult<Page<JobAdvertForListDto>>> getAllByIsActiveAndCityAndWorkingTimeForList(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam final short cityId,
			@RequestParam final short workingTimeId, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvertForListDto>> result = this.jobAdvertService
				.getAllByIsActiveAndCityAndWorkingTimeForList(isActive,
						cityId,
						workingTimeId,
						page,
						size,
						sortProperties,
						sortDirection);

		return ResponseEntity.ok(result);
	}

	@PutMapping({ "/verify/byid" })
	public ResponseEntity<Result> verifyById(final int id) {
		Result result = this.jobAdvertService.verifyById(id);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
