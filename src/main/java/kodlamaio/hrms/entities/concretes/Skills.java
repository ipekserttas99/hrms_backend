package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="yetenekler")
public class Skills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="TeknolojiAd")
	private String yetenekAdı;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserId", referencedColumnName = "Id")
	private User user;

	public Skills() {
		
	}

	public Skills(int id, String yetenekAdı, User user) {
		super();
		this.id = id;
		this.yetenekAdı = yetenekAdı;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String YetenekAdı() {
		return yetenekAdı;
	}

	public void setYetenekAdı(String yetenekAdı) {
		this.yetenekAdı = yetenekAdı;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
