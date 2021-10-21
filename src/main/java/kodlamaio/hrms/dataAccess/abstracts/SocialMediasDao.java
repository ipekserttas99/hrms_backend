package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SocialMedias;

public interface SocialMediasDao extends JpaRepository<SocialMedias, Integer>{
	SocialMedias getByGithubLink(String githubLink);
	SocialMedias getByLinkedinLink(String linkedinLink);
	
	SocialMedias getByGithubLinkOrUser_Id(String githubLink, int id);
	SocialMedias getByLinkedinLinkOrUser_Id(String linkedinLink, int id);
}