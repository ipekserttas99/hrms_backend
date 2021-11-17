package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanyStaffService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CompanyStaff;
import kodlamaio.hrms.entities.dtos.CompanyStaffForUpdateDto;

@RestController
@RequestMapping("/api/companystaffs")
public class CompanyStaffsController extends BaseController<CompanyStaffService, CompanyStaff, Integer> {
	private final CompanyStaffService companyStaffService;

	@Autowired
	public CompanyStaffsController(final CompanyStaffService companyStaffService) {
		super(companyStaffService);
		this.companyStaffService = companyStaffService;
	}

	@PutMapping("/byuser")
	public ResponseEntity<Result> updateByUser(
			@Valid @RequestBody final CompanyStaffForUpdateDto employerForUpdateDto) {
		final Result result = companyStaffService.updateByUser(employerForUpdateDto);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
