package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SkillsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skills;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

	private SkillsService skillsService;
	@Autowired
	public SkillsController(SkillsService skillsService) {
		super();
		this.skillsService = skillsService;
	}
	
	@PostMapping("/add")
	public Result add(Skills skills) {
		return this.skillsService.add(skills);
	}
	
	@GetMapping("/getByYetenekAdı")
	public DataResult<Skills> getByYetenekAdı(String yetenekAdı) {
		return this.skillsService.getByYetenekAdı(yetenekAdı);
	}
	
	@GetMapping("/getByYetenekAdıOrUser_Id")
	public DataResult<Skills> getByYetenekAdıOrUser_Id(String yetenekAdı, int id) {
		return this.skillsService.getByYetenekAdıOrUser_Id(yetenekAdı, id);
	}
}
