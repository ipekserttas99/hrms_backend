package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Abouts;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobExperiences;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.Pictures;
import kodlamaio.hrms.entities.concretes.Schools;
import kodlamaio.hrms.entities.concretes.Skills;
import kodlamaio.hrms.entities.concretes.SocialMedias;
import kodlamaio.hrms.entities.concretes.SystemStaff;

public class UserDto {
	private int id;
	private String email;
	private String password;
	private String passwordAgain;
	private Employers employers;
	private JobSeekers jobSeekers;
	private SystemStaff systemStaff;
	private JobPosition jobPosition;
	private JobExperiences jobExperiences;
	private Languages languages;
	private Pictures pictures;
	private Schools schools;
	private Skills skills;
	private SocialMedias socialMedias;
	private Abouts abouts;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, String email, String password, String passwordAgain, Employers employers,
			JobSeekers jobSeekers, SystemStaff systemStaff, JobPosition jobPosition, JobExperiences jobExperiences,
			Languages languages, Pictures pictures, Schools schools, Skills skills, SocialMedias socialMedias,
			Abouts abouts) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.employers = employers;
		this.jobSeekers = jobSeekers;
		this.systemStaff = systemStaff;
		this.jobPosition = jobPosition;
		this.jobExperiences = jobExperiences;
		this.languages = languages;
		this.pictures = pictures;
		this.schools = schools;
		this.skills = skills;
		this.socialMedias = socialMedias;
		this.abouts = abouts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordAgain() {
		return passwordAgain;
	}
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
	public Employers getEmployers() {
		return employers;
	}
	public void setEmployers(Employers employers) {
		this.employers = employers;
	}
	public JobSeekers getJobSeekers() {
		return jobSeekers;
	}
	public void setJobSeekers(JobSeekers jobSeekers) {
		this.jobSeekers = jobSeekers;
	}
	public SystemStaff getSystemStaff() {
		return systemStaff;
	}
	public void setSystemStaff(SystemStaff systemStaff) {
		this.systemStaff = systemStaff;
	}
	public JobPosition getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}
	public JobExperiences getJobExperiences() {
		return jobExperiences;
	}
	public void setJobExperiences(JobExperiences jobExperiences) {
		this.jobExperiences = jobExperiences;
	}
	public Languages getLanguages() {
		return languages;
	}
	public void setLanguages(Languages languages) {
		this.languages = languages;
	}
	public Pictures getPictures() {
		return pictures;
	}
	public void setPictures(Pictures pictures) {
		this.pictures = pictures;
	}
	public Schools getSchools() {
		return schools;
	}
	public void setSchools(Schools schools) {
		this.schools = schools;
	}
	public Skills getSkills() {
		return skills;
	}
	public void setSkills(Skills skills) {
		this.skills = skills;
	}
	public SocialMedias getSocialMedias() {
		return socialMedias;
	}
	public void setSocialMedias(SocialMedias socialMedias) {
		this.socialMedias = socialMedias;
	}
	public Abouts getAbouts() {
		return abouts;
	}
	public void setAbouts(Abouts abouts) {
		this.abouts = abouts;
	}
	
	
}
