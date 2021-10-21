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
@Table(name="iş_tecrübeleri")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class JobExperiences {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	
	@Column(name="İşYeriAdı")
	private String işYeriAdı;
	
	@Column(name="Pozisyon")
	private String pozisyon;
	
	@Column(name="BaşlangıçYıl")
	private String başlangıçYıl;
	
	@Column(name="BitişYıl")
	private String bitişYıl;
	
	@ManyToOne
	@JoinColumn(name="Id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private JobSeekers jobSeekers;

	public JobExperiences() {
		
	}

	public JobExperiences(int id, String işYeriAdı, String pozisyon, String başlangıçYıl, String bitişYıl, Cv cv, JobSeekers jobSeekers) {
		super();
		this.id = id;
		this.işYeriAdı = işYeriAdı;
		this.pozisyon = pozisyon;
		this.başlangıçYıl = başlangıçYıl;
		this.bitişYıl = bitişYıl;
		this.cv = cv;
		this.jobSeekers = jobSeekers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIşYeriAdı() {
		return işYeriAdı;
	}

	public void setIşYeriAdı(String işYeriAdı) {
		this.işYeriAdı = işYeriAdı;
	}

	public String getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

	public String getBaşlangıçYıl() {
		return başlangıçYıl;
	}

	public void setBaşlangıçYıl(String başlangıçYıl) {
		this.başlangıçYıl = başlangıçYıl;
	}

	public String getBitişYıl() {
		if(bitişYıl==null) {
			return "Devam ediyor";
		}
		return bitişYıl.toString();
	}

	public void setBitişYıl(String bitişYıl) {
		this.bitişYıl = bitişYıl;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public JobSeekers getJobSeekers() {
		return jobSeekers;
	}

	public void setJobSeekers(JobSeekers jobSeekers) {
		this.jobSeekers = jobSeekers;
	}

	


}
