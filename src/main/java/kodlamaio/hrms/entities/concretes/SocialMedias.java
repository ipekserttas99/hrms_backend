package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sosyal_medyalar")
public class SocialMedias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="GithubLink")
	private String githubLink;
	
	@Column(name="LinkedinLink")
	private String linkedinLink;
	
	@OneToOne()
	@JoinColumn(name= "Id")
	private User user;

	public SocialMedias() {
		
	}

	public SocialMedias(int id, String githubLink, String linkedinLink, User user) {
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
