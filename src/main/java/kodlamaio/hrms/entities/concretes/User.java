package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.drew.lang.annotations.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="kullanıcılar")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","kullanıcılar"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	@NotNull
	private int id;
	
	@Column(name="Email")
	@NotNull
	private String email;
	
	@Column(name="Password")
	@NotNull
	private String password;
	
	@Column(name="PasswordAgain")
	@NotNull
	private String passwordAgain;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Employers employers;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private JobSeekers jobSeekers;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private SystemStaff systemStaff;
	
    @OneToOne(mappedBy = "user")
	private JobPosition jobPosition;
	
    @OneToOne(mappedBy = "user")
	private JobExperiences jobExperiences;
	
    @OneToOne(mappedBy = "user")
	private Languages languages;
	
    @OneToOne(mappedBy = "user")
	private Pictures pictures;
	
    @OneToOne(mappedBy = "user")
	private Schools schools;
	
    @OneToOne(mappedBy = "user")
	private Skills skills;
	
    @OneToOne(mappedBy = "user")
	private SocialMedias socialMedias;
	
    @OneToOne(mappedBy = "user")
	private Abouts abouts;
	
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
