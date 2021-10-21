package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediasService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedias;

@RestController
@RequestMapping("/api/socialmedias")
public class SocialMediasController {

	private SocialMediasService socialMediasService;
	@Autowired
	public SocialMediasController(SocialMediasService socialMediasService) {
		super();
		this.socialMediasService = socialMediasService;
	}
	
	@GetMapping("/getByGithubLink")
	public DataResult<SocialMedias> getByGithubLink(String githubLink) {
		return this.socialMediasService.getByGithubLink(githubLink);
	}
	
	@GetMapping("/getByLinkedinLink")
	public DataResult<SocialMedias> getByLinkedinLink(String linkedinLink) {
		return this.socialMediasService.getByLinkedinLink(linkedinLink);
	}
	
	@PostMapping("/add")
	public Result add(SocialMedias socialMedias) {
		return this.socialMediasService.add(socialMedias);
	}
	
	@GetMapping("/getByGithubLinkOrUser_Id")
	public DataResult<SocialMedias> getByGithubLinkOrUser_Id(String githubLink, int id) {
		return this.socialMediasService.getByGithubLinkOrUser_Id(githubLink, id);
	}
	
	@GetMapping("/getByLinkedinLinkOrUser_Id")
	public DataResult<SocialMedias> getByLinkedinLinkOrUser_Id(String linkedinLink, int id) {
		return this.socialMediasService.getByLinkedinLinkOrUser_Id(linkedinLink, id);
	}
}
