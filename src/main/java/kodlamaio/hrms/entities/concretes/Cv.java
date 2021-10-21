package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;

@Entity
@Table(name="cv")
@JsonIgnoreProperties({ "HybernateLazyInitializer", "handler", "cv" })
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="UserId", referencedColumnName = "Id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserId", referencedColumnName = "UserId")
	private JobSeekers jobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<SocialMedias> socialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Pictures> pictures;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Schools> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Languages> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Skills> skills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<JobExperiences> jobExperiences;
	
	public Cv() {
		
	}

	public Cv(int id, User user, JobSeekers jobSeekers, List<SocialMedias> socialMedias, List<Pictures> pictures,
			List<Schools> schools, List<Languages> languages, List<Skills> skills,
			List<JobExperiences> jobExperiences) {
		super();
		this.id = id;
		this.user = user;
		this.jobSeekers = jobSeekers;
		this.socialMedias = socialMedias;
		this.pictures = pictures;
		this.schools = schools;
		this.languages = languages;
		this.skills = skills;
		this.jobExperiences = jobExperiences;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobSeekers getJobSeekers() {
		return jobSeekers;
	}

	public void setJobSeekers(JobSeekers jobSeekers) {
		this.jobSeekers = jobSeekers;
	}

	public List<SocialMedias> getSocialMedias() {
		return socialMedias;
	}

	public void setSocialMedias(List<SocialMedias> socialMedias) {
		this.socialMedias = socialMedias;
	}

	public List<Pictures> getPictures() {
		return pictures;
	}

	public void setPictures(List<Pictures> pictures) {
		this.pictures = pictures;
	}

	public List<Schools> getSchools() {
		return schools;
	}

	public void setSchools(List<Schools> schools) {
		this.schools = schools;
	}

	public List<Languages> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public List<JobExperiences> getJobExperiences() {
		return jobExperiences;
	}

	public void setJobExperiences(List<JobExperiences> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}
	
	
}
