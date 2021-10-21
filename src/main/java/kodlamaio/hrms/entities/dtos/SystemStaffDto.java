package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.User;

public class SystemStaffDto {
	private String personalAd;
	private String personalSoyad;
	private String personalTitle;
	private User user;
	public SystemStaffDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SystemStaffDto(String personalAd, String personalSoyad, String personalTitle, User user) {
		super();
		this.personalAd = personalAd;
		this.personalSoyad = personalSoyad;
		this.personalTitle = personalTitle;
		this.user = user;
	}
	public String getPersonalAd() {
		return personalAd;
	}
	public void setPersonalAd(String personalAd) {
		this.personalAd = personalAd;
	}
	public String getPersonalSoyad() {
		return personalSoyad;
	}
	public void setPersonalSoyad(String personalSoyad) {
		this.personalSoyad = personalSoyad;
	}
	public String getPersonalTitle() {
		return personalTitle;
	}
	public void setPersonalTitle(String personalTitle) {
		this.personalTitle = personalTitle;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
