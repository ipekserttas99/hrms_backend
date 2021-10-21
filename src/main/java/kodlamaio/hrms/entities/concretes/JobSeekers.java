package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.User;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="iş_arayanlar")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "UserId", referencedColumnName = "Id")
public class JobSeekers extends User{
	
	@Column(name="Ad")
	private String ad;
	
	@Column(name="Soyad")
	private String soyad;
	
	@Column(name="TcNo")
	private String tcNo;
	
	@Column(name="DoğumYılı")
	private String dogumYılı;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "UserId")
	private User user;
	
	public JobSeekers(String ad, String soyad, String tcNo, String dogumYılı, User user) {
		//int userId, 
		super();
		//this.userId = userId;
		this.ad = ad;
		this.soyad = soyad;
		this.tcNo = tcNo;
		this.dogumYılı = dogumYılı;
		this.user = user;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getDogumYılı() {
		return dogumYılı;
	}

	public void setDogumYılı(String dogumYılı) {
		this.dogumYılı = dogumYılı;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
