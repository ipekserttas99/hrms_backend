package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sosyal_medyalar")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SocialMedias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="GithubLink")
	private String githubLink;
	
	@Column(name="LinkedinLink")
	private String linkedinLink;
	
	@OneToOne
	@JoinColumn(name="UserId")
	private JobSeekers jobSeekers;
	
	@ManyToOne
	@JoinColumn(name="Id")
	private Cv cv;

	public SocialMedias() {
		
	}

	public SocialMedias(int id, String githubLink, String linkedinLink, JobSeekers jobSeekers, Cv cv) {
		super();
		this.id = id;
		this.githubLink = githubLink;
		this.linkedinLink = linkedinLink;
		this.jobSeekers = jobSeekers;
		this.cv = cv;
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

	public JobSeekers getJobSeekers() {
		return jobSeekers;
	}

	public void setJobSeekers(JobSeekers jobSeekers) {
		this.jobSeekers = jobSeekers;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	
	
	
}
