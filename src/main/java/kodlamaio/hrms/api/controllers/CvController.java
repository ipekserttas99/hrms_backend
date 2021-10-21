package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
public class CvController {
	private CvService cvService;
	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/findByJobSeekersId")
	public DataResult<Cv> findByJobSeekersId(int id) {
		return this.cvService.findByJobSeekersId(id);
	}
	
}
