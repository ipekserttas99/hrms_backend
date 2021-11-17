package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.JobSeekersFavoriteJobAdvert;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegisterDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController extends BaseController<JobSeekerService, JobSeeker, Integer> {
	private final JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(final JobSeekerService jobSeekerService) {
		super(jobSeekerService);
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping("/register")
	public ResponseEntity<Result> register(@Valid @RequestBody final JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		final Result result = jobSeekerService.register(jobSeekerForRegisterDto);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/favorite/jobadvert/byjobseekeridandjobadvertid" })
	public ResponseEntity<DataResult<JobSeekersFavoriteJobAdvert>> getByJobSeekerIdAndJobAdvertId(
			@RequestParam final int jobSeekerId, @RequestParam final int jobAdvertId) {
		DataResult<JobSeekersFavoriteJobAdvert> result = this.jobSeekerService
				.getFavoriteByJobSeekerIdAndJobAdvertId(jobSeekerId, jobAdvertId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PostMapping({ "/favorite/jobadvert" })
	public ResponseEntity<Result> favoriteJobAdvert(
			@RequestBody final JobSeekersFavoriteJobAdvert jobSeekersFavoriteJobAdvert) {
		Result result = this.jobSeekerService.favoriteJobAdvert(jobSeekersFavoriteJobAdvert);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping({ "/favorite/jobadvert" })
	public ResponseEntity<Result> undoFavoriteJobAdvert(@RequestParam final int jobSeekersFavoriteJobAdvertId) {
		Result result = this.jobSeekerService.undoFavoriteJobAdvert(jobSeekersFavoriteJobAdvertId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
