package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="yetenekler")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Skills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="TeknolojiAd")
	private String yetenekAdı;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private JobSeekers jobSeekers;
	
	@ManyToOne
	@JoinColumn(name="Id")
	private Cv cv;

	public Skills() {
		
	}

	public Skills(int id, String yetenekAdı, JobSeekers jobSeekers, Cv cv) {
		super();
		this.id = id;
		this.yetenekAdı = yetenekAdı;
		this.jobSeekers = jobSeekers;
		this.cv = cv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String YetenekAdı() {
		return yetenekAdı;
	}

	public void setYetenekAdı(String yetenekAdı) {
		this.yetenekAdı = yetenekAdı;
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

	public String getYetenekAdı() {
		return yetenekAdı;
	}

	
	
}
