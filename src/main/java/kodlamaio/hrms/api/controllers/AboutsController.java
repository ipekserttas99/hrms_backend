package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AboutsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Abouts;

@RestController
@RequestMapping("/api/abouts")
public class AboutsController {

	private AboutsService aboutsService;
	@Autowired
	public AboutsController(AboutsService aboutsService) {
		super();
		this.aboutsService = aboutsService;
	}
	
	@PostMapping("/add")
	public Result add(Abouts abouts) {
		return this.aboutsService.add(abouts);
	}
	
	@GetMapping("/getByÖnYazıOrUserId")
	public DataResult<Abouts> getByÖnYazıOrUser_Id(String önYazı, int id) {
		return this.aboutsService.getByÖnYazıOrUser_Id(önYazı, id);
	}
}
