package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController extends BaseController<CityService, City, Short>{
	private final CityService cityService;

	@Autowired
	public CitiesController(final CityService cityService) {
		super(cityService);
		this.cityService = cityService;
	}

	@GetMapping("/byname")
	public ResponseEntity<DataResult<City>> getByName(final String name) {
		final DataResult<City> result = cityService.getByName(name);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/bynamecontains")
	public ResponseEntity<DataResult<List<City>>> getByNameContains(final String name) {
		final DataResult<List<City>> result = cityService.getByNameContains(name);

		return ResponseEntity.ok(result);
	}
}
