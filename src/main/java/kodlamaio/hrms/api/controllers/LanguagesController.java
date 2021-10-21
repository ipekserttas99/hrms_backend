package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguagesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Languages;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguagesService languagesService;
	@Autowired
	public LanguagesController(LanguagesService languagesService) {
		super();
		this.languagesService = languagesService;
	}
	
	@PostMapping("/add")
	public Result add(Languages languages) {
		return this.languagesService.add(languages);
	}

	@GetMapping("/getByDil")
	public DataResult<Languages> getByDil(String dil) {
		return this.languagesService.getByDil(dil);
	}
	
	@GetMapping("/getByLevel")
	public DataResult<Languages> getByLevel(String level) {
		return this.languagesService.getByLevel(level);
	}
	
	@GetMapping("/getByDilOrUser_Id")
	public DataResult<Languages> getByDilOrUser_Id(String dil, int id) {
		return this.languagesService.getByDilOrUser_Id(dil, id);
	}
	
	@GetMapping("/GetByDilAndUser")
	public DataResult<List<Languages>> GetByDilAndUser(String dil, int id) {
		return this.languagesService.GetByDilAndUser(dil, id);
	}
}
