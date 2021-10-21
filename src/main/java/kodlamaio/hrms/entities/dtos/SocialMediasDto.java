package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.User;

public class SocialMediasDto {
	private int id;
	private String githubLink;
	private String linkedinLink;
	private User user;
	public SocialMediasDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SocialMediasDto(int id, String githubLink, String linkedinLink, User user) {
		super();
		this.id = id;
		this.githubLink = githubLink;
		this.linkedinLink = linkedinLink;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGithubLink() {
		return githubLink;
	}
	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}
	public String getLinkedinLink() {
		return linkedinLink;
	}
	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
