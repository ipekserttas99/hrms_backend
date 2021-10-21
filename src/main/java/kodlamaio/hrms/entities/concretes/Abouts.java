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
@Table(name="hakkındalar")
public class Abouts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="ÖnYazı")
	private String önYazı;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserId", referencedColumnName = "Id")
	private User user;

	public Abouts() {
		
	}

	public Abouts(int id, String önYazı, User user) {
		super();
		this.id = id;
		this.önYazı = önYazı;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getÖnYazı() {
		return önYazı;
	}

	public void setÖnYazı(String önYazı) {
		this.önYazı = önYazı;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}