package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediasService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediasDao;
import kodlamaio.hrms.entities.concretes.SocialMedias;

@Service
public class SocialMediasManager implements SocialMediasService{

	private SocialMediasDao socialMediasDao;
	
	@Autowired
	public SocialMediasManager(SocialMediasDao socialMediasDao) {
		super();
		this.socialMediasDao = socialMediasDao;
	}

	@Override
	public DataResult<SocialMedias> getByGithubLink(String githubLink) {
		return new SuccessDataResult<SocialMedias>
		(this.socialMediasDao.getByGithubLink(githubLink));
	}

	@Override
	public DataResult<SocialMedias> getByLinkedinLink(String linkedinLink) {
		return new SuccessDataResult<SocialMedias>
		(this.socialMediasDao.getByLinkedinLink(linkedinLink));
	}

	@Override
	public Result add(SocialMedias socialMedias) {
		this.socialMediasDao.save(socialMedias);
		return new SuccessResult("Sosyal medya eklendi");
	}

	@Override
	public DataResult<SocialMedias> getByGithubLinkOrUser_Id(String githubLink, int id) {
		return new SuccessDataResult<SocialMedias>
		(this.socialMediasDao.getByGithubLinkOrUser_Id(githubLink, id));
	}

	@Override
	public DataResult<SocialMedias> getByLinkedinLinkOrUser_Id(String linkedinLink, int id) {
		return new SuccessDataResult<SocialMedias>
		(this.socialMediasDao.getByLinkedinLinkOrUser_Id(linkedinLink, id));
	}

}
