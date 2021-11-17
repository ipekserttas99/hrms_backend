package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForUpdateDto;

@RestController
@RequestMapping("/api/employers")
public class EmployersController extends BaseController<EmployerService, Employer, Integer> {
	private final EmployerService employerService;

	@Autowired
	public EmployersController(final EmployerService employerService) {
		super(employerService);
		this.employerService = employerService;
	}

	@GetMapping("/update/byuserid/last")
	public ResponseEntity<DataResult<EmployerUpdate>> getLastUpdateByUserId(@RequestParam final int employerId) {
		final DataResult<EmployerUpdate> result = employerService.getLastUpdateByUserId(employerId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/update/byisapprovedandisdeleted")
	public ResponseEntity<DataResult<List<EmployerUpdate>>> getAllByIsApprovedAndIsDeleted(
			@RequestParam final boolean isApproved,
			@RequestParam final boolean isDeleted) {
		final DataResult<List<EmployerUpdate>> result = employerService.getAllByIsApprovedAndIsDeleted(isApproved,
				isDeleted);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/register")
	public ResponseEntity<Result> register(@Valid @RequestBody final EmployerForRegisterDto employerForRegisterDto) {
		final Result result = employerService.register(employerForRegisterDto);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/byuser")
	public ResponseEntity<Result> updateByUser(@Valid @ModelAttribute EmployerForUpdateDto employerForUpdateDto,
			@RequestBody MultipartFile companyImage) {
		final Result result = employerService.updateByUser(employerForUpdateDto, companyImage);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/verify/update")
	public ResponseEntity<Result> verifyUpdate(@RequestParam final int employerUpdateId) {
		final Result result = employerService.verifyUpdate(employerUpdateId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/deny/update")
	public ResponseEntity<Result> denyUpdate(@RequestParam final int employerUpdateId) {
		final Result result = employerService.denyUpdate(employerUpdateId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
