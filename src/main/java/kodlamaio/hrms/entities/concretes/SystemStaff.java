package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sistem_personelleri")
public class SystemStaff {
	
	@Id
	@GeneratedValue
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="PersonalAd")
	private String personalAd;
	
	@Column(name="PersonalSoyad")
	private String personalSoyad;
	
	@Column(name="PersonalTitle")
	private String personalTitle;
	
	@OneToOne()
	@JoinColumn(name= "Id")
	private User user;

	public SystemStaff(String personalAd, String personalSoyad, String personalTitle, User user) {
		//int userId, 
		super();
		//this.userId = userId;
		this.personalAd = personalAd;
		this.personalSoyad = personalSoyad;
		this.personalTitle = personalTitle;
		this.user = user;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

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
