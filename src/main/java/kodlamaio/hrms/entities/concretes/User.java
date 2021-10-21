package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="kullanıcılar")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","kullanıcılar"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="PasswordAgain")
	private String passwordAgain;
	
	@OneToOne(mappedBy = "kullanıcılar")
	private Employers employers;
	@OneToOne(mappedBy = "kullanıcılar")
	private JobSeekers jobSeekers;
	@OneToOne(mappedBy = "kullanıcılar")
	private SystemStaff systemStaff;
	@OneToOne(mappedBy = "kullanıcılar")
	private JobPosition jobPosition;
	@OneToOne(mappedBy = "kullanıcılar")
	private Abouts abouts;
	@OneToOne(mappedBy = "kullanıcılar")
	private JobExperiences jobExperiences;
	@OneToOne(mappedBy = "kullanıcılar")
	private Languages languages;
	@OneToOne(mappedBy = "kullanıcılar")
	private Pictures pictures;
	@OneToOne(mappedBy = "kullanıcılar")
	private Schools schools;
	@OneToOne(mappedBy = "kullanıcılar")
	private Skills skills;
	@OneToOne(mappedBy = "kullanıcılar")
	private SocialMedias socialMedias;

	public User() {
		
	}
	
	public User(int id, String email, String password, String passwordAgain, Employers employers, 
	JobSeekers jobSeekers, SystemStaff systemStaff, JobPosition jobPosition, Abouts abouts, JobExperiences jobExperiences,
	Languages languages, Pictures pictures, Schools schools, Skills skills, SocialMedias socialMedias) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.employers = employers;
		this.jobSeekers = jobSeekers;
		this.systemStaff = systemStaff;
		this.jobPosition = jobPosition;
		this.abouts = abouts;
		this.jobExperiences = jobExperiences;
		this.languages = languages;
		this.pictures = pictures;
		this.schools = schools;
		this.skills = skills;
		this.socialMedias = socialMedias;
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

	public Abouts getAbouts() {
		return abouts;
	}

	public void setAbouts(Abouts abouts) {
		this.abouts = abouts;
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
	
}
