package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedias;

public interface SocialMediasService {
	DataResult<SocialMedias> getByGithubLink(String githubLink);
	DataResult<SocialMedias> getByLinkedinLink(String linkedinLink);
	Result add(SocialMedias socialMedias);
	DataResult<SocialMedias> getByGithubLinkOrUser_Id(String githubLink, int id);
	DataResult<SocialMedias> getByLinkedinLinkOrUser_Id(String linkedinLink, int id);
}
