package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployersService employersService;
	
	@Autowired
	public EmployersController(EmployersService employersService) {
		this.employersService = employersService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employers>> getAll(){
		return this.employersService.getAll();
	}

	@PostMapping("/add")
	public Result add(Employers employers) {
		return this.employersService.add(employers);
	}
	
	@GetMapping("/getallsorted")
	public DataResult<List<Employers>> getAllSorted() {
		return this.employersService.getAllSorted();
	}

	@GetMapping("/getallpagination")
	public DataResult<List<Employers>> getAll(int pageNo, int pageSize) {
		return this.employersService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getByŞirketAdıAndWebSitesi")
	public DataResult<Employers> getByŞirketAdıAndWebSitesi(String sirketAdı, String webSitesi) {
		return this.employersService.getByŞirketAdıAndWebSitesi(sirketAdı, webSitesi);
	}
	
	@GetMapping("/GetByŞirketAdıAndUser")
	public DataResult<List<Employers>> GetByŞirketAdıAndUser(String sirketAdı, int id) {
		return this.employersService.GetByŞirketAdıAndUser(sirketAdı, id);
	}
}
	
	
