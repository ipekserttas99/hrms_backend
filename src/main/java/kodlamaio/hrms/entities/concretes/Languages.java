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
@Table(name="yabancı_diller")
public class Languages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="Dil")
	private String dil;
	
	@Column(name="Seviye")
	private String level;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserId", referencedColumnName = "Id")
	private User user;

	public Languages() {
		
	}

	public Languages(int id, String dil, String level, User user) {
		super();
		this.id = id;
		this.dil = dil;
		this.level = level;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDil() {
		return dil;
	}

	public void setDil(String dil) {
		this.dil = dil;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
