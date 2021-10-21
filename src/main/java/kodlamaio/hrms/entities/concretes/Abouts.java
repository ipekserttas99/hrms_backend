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
@Table(name="hakkındalar")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Abouts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="ÖnYazı")
	private String önYazı;

	@ManyToOne
	@JoinColumn(name="UserId")
	private JobSeekers jobSeekers;

	public Abouts() {
		
	}

	public Abouts(int id, String önYazı, JobSeekers jobSeekers) {
		super();
		this.id = id;
		this.önYazı = önYazı;
		this.jobSeekers = jobSeekers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getÖnYazı() {
		return önYazı;
	}

	public void setÖnYazı(String önYazı) {
		this.önYazı = önYazı;
	}

	public JobSeekers getJobSeekers() {
		return jobSeekers;
	}

	public void setJobSeekers(JobSeekers jobSeekers) {
		this.jobSeekers = jobSeekers;
	}

	
	
	
}