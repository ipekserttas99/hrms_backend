package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;

@Entity
@Table(name="fotoğraflar")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pictures {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Fotoğraf")
	private String fotoğrafUrl;

	@OneToOne
	@JoinColumn(name="UserId")
	private User user;

	public Pictures() {
		
	}

	public Pictures(int id, String fotoğrafUrl, User user) {
		super();
		this.id = id;
		this.fotoğrafUrl = fotoğrafUrl;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFotoğrafUrl() {
		return fotoğrafUrl;
	}

	public void setFotoğrafUrl(String fotoğrafUrl) {
		this.fotoğrafUrl = fotoğrafUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
	
	
}
