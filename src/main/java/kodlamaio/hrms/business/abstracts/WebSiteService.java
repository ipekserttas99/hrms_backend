package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WebSite;

public interface WebSiteService extends BaseService<WebSite, Short>{
	DataResult<WebSite> getByName(String name);
}
