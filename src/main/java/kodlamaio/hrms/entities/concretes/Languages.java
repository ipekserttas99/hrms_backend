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
@Table(name="yabancı_diller")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Languages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	
	@Column(name="Dil")
	private String dil;
	
	@Column(name="Seviye")
	private String level;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private JobSeekers jobSeekers;

	public Languages() {
		
	}

	public Languages(int id, String dil, String level, JobSeekers jobSeekers) {
		super();
		this.id = id;
		this.dil = dil;
		this.level = level;
		this.jobSeekers = jobSeekers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDil() {
		return dil;
	}

	public void setDil(String dil) {
		this.dil = dil;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public JobSeekers getJobSeekers() {
		return jobSeekers;
	}

	public void setJobSeekers(JobSeekers jobSeekers) {
		this.jobSeekers = jobSeekers;
	}

	
	
}
