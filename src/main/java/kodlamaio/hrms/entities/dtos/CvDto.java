package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.JobExperiences;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.Pictures;
import kodlamaio.hrms.entities.concretes.Schools;
import kodlamaio.hrms.entities.concretes.Skills;
import kodlamaio.hrms.entities.concretes.SocialMedias;

public class CvDto {
	private int id;
	private kodlamaio.hrms.core.entities.User user;
	private JobSeekers jobSeekers;
	private List<SocialMedias> socialMedias;
	private List<Pictures> pictures;
	private List<Schools> schools;
	private List<Languages> languages;
	private List<Skills> skills;
	private List<JobExperiences> jobExperiences;
	
	public CvDto() {
		
	}

	public CvDto(int id, User user, JobSeekers jobSeekers, List<SocialMedias> socialMedias, List<Pictures> pictures,
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
