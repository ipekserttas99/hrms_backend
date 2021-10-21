package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="iş_verenler")
public class Employers {
	
	@Id
	@GeneratedValue
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="ŞirketAdı")
	private String sirketAdı;
	
	@Column(name="WebSitesi")
	private String webSitesi;
	
	@Column(name="Telefon")
	private String telefon;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "UserId")
	private User user;
	
	public Employers() {
		
	}

	public Employers(String sirketAdı, String webSitesi, String telefon, User user) {
			//int userId, 
		super();
		//this.userId = userId;
		this.sirketAdı = sirketAdı;
		this.webSitesi = webSitesi;
		this.telefon = telefon;
		this.user = user;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public String getSirketAdı() {
		return sirketAdı;
	}

	public void setSirketAdı(String sirketAdı) {
		this.sirketAdı = sirketAdı;
	}

	public String getWebSitesi() {
		return webSitesi;
	}

	public void setWebSitesi(String webSitesi) {
		this.webSitesi = webSitesi;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
