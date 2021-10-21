package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PicturesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Pictures;

@RestController
@RequestMapping("/api/pictures")
public class PicturesController {
	private PicturesService picturesService;
	@Autowired
	public PicturesController(PicturesService picturesService) {
		super();
		this.picturesService = picturesService;
	}
	
	@PostMapping("/add")
	public Result add(Pictures pictures) {
		return this.picturesService.add(pictures);
	}
	
	@GetMapping("/getByUser_Id")
	public DataResult<Pictures> getByUser_Id(int id) {
		return this.picturesService.getByUser_Id(id);
	}
	
	@GetMapping("/getByUser")
	public DataResult<List<Pictures>> GetByUser(int id) {
		return this.picturesService.GetByUser(id);
	}
}
