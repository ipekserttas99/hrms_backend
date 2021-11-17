package kodlamaio.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WebSiteService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.WebSiteDao;
import kodlamaio.hrms.entities.concretes.WebSite;

@Service
public class WebSiteManager  extends BaseManager<WebSiteDao, WebSite, Short> implements WebSiteService{
	private final WebSiteDao webSiteDao;

	@Autowired
	public WebSiteManager(final WebSiteDao webSiteDao) {
		super(webSiteDao, "Website");
		this.webSiteDao = webSiteDao;
	}

	@Override
	public DataResult<WebSite> getByName(String name) {
		final Optional<WebSite> webSite = webSiteDao.findByName(name);

		if (webSite.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("A user with the mail"));

		return new SuccessDataResult<>(webSite.get());
	}

}
