package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="iş_pozisyonları")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="PozisyonAd")
	private String pozisyonAd;
	
	@Column(name="PozisyonTanım")
	private String pozisyonTanım;
	
	@Column(name="Şehir")
	private String sehir;
	
	@Column(name="Maaş")
	private String maaş;
	
	@Column(name="YayınTarihi")
	private Date yayınTarihi;
	
	@Column(name="SonBaşvuruTarihi")
	private Date sonBaşvuruTarihi;
	
	@Column(name="Firma")
	private String firma;
	
	@Column(name="AktifMi")
	private boolean aktifMi;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private Employers employers;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private JobSeekers jobSeekers;
	
	public JobPosition() {
		
	}

	public JobPosition(int id, String pozisyonAd, String pozisyonTanım, String sehir, String maaş, Date yayınTarihi,
			Date sonBaşvuruTarihi, String firma, Employers employers, JobSeekers jobSeekers) {
		super();
		this.id = id;
		this.pozisyonAd = pozisyonAd;
		this.pozisyonTanım = pozisyonTanım;
		this.sehir = sehir;
		this.maaş = maaş;
		this.yayınTarihi = yayınTarihi;
		this.sonBaşvuruTarihi = sonBaşvuruTarihi;
		this.firma = firma;
		this.employers = employers;
		this.jobSeekers = jobSeekers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPozisyonAd() {
		return pozisyonAd;
	}

	public void setPozisyonAd(String pozisyonAd) {
		this.pozisyonAd = pozisyonAd;
	}

	public String getPozisyonTanım() {
		return pozisyonTanım;
	}

	public void setPozisyonTanım(String pozisyonTanım) {
		this.pozisyonTanım = pozisyonTanım;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public String getMaaş() {
		return maaş;
	}

	public void setMaaş(String maaş) {
		this.maaş = maaş;
	}

	public Date getYayınTarihi() {
		return yayınTarihi;
	}

	public void setYayınTarihi(Date yayınTarihi) {
		this.yayınTarihi = yayınTarihi;
	}

	public Date getSonBaşvuruTarihi() {
		return sonBaşvuruTarihi;
	}

	public void setSonBaşvuruTarihi(Date sonBaşvuruTarihi) {
		this.sonBaşvuruTarihi = sonBaşvuruTarihi;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public boolean isAktifMi() {
		return aktifMi;
	}

	public void setAktifMi(boolean aktifMi) {
		this.aktifMi = aktifMi;
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

	
	

	
	
}
