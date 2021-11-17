package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WebSiteService;
import kodlamaio.hrms.core.api.abstracts.BaseController;
import kodlamaio.hrms.entities.concretes.WebSite;

@RestController
@RequestMapping("/api/websites")
public class WebSitesController extends BaseController<WebSiteService, WebSite, Short> {
	@Autowired
	public WebSitesController(final WebSiteService webSiteService) {
		super(webSiteService);
	}
}
