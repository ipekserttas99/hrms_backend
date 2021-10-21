package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.User;

public class JobSeekersDto {
	private String ad;
	private String soyad;
	private String tcNo;
	private String dogumYılı;
	private User user;
	public JobSeekersDto() {
		
	}
	public JobSeekersDto(String ad, String soyad, String tcNo, String dogumYılı, User user) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.tcNo = tcNo;
		this.dogumYılı = dogumYılı;
		this.user = user;
	}
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
