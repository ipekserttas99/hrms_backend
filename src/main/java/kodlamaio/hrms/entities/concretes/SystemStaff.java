package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.User;

@Entity
@Table(name="sistem_personelleri")
@PrimaryKeyJoinColumn(name = "UserId", referencedColumnName = "Id")
public class SystemStaff extends User{
	
	@Column(name="PersonalAd")
	private String personalAd;
	
	@Column(name="PersonalSoyad")
	private String personalSoyad;
	
	@Column(name="PersonalTitle")
	private String personalTitle;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "UserId")
	private User user;

	public SystemStaff(String personalAd, String personalSoyad, String personalTitle, User user) {
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
