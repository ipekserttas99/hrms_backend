package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Schools;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private SchoolsService schoolsService;
	@Autowired
	public SchoolsController(SchoolsService schoolsService) {
		super();
		this.schoolsService = schoolsService;
	}
	
	@PostMapping("/add")
	public Result add(Schools schools) {
		return this.schoolsService.add(schools);
	}
	
	@GetMapping("/getByOkulAd")
	public DataResult<Schools> getByOkulAd(String okulAd) {
		return this.schoolsService.getByOkulAd(okulAd);
	}
	
	@GetMapping("/getByBitişYıl")
	public DataResult<Schools> getByBitişYıl(String bitişYıl) {
		return this.schoolsService.getByBitişYıl(bitişYıl);
	}
	
	@GetMapping("/GetByBitişYılAndUser")
	public DataResult<List<Schools>> GetByBitişYılAndUser(String bitişYıl, int id) {
		return this.schoolsService.GetByBitişYılAndUser(bitişYıl, id);
	}
}
