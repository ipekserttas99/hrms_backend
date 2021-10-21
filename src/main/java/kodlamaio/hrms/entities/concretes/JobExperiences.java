package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="iş_tecrübeleri")
public class JobExperiences {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	//@Column(name="UserId")
	//private int userId;
	
	@Column(name="İşYeriAdı")
	private String işYeriAdı;
	
	@Column(name="Pozisyon")
	private String pozisyon;
	
	@Column(name="BaşlangıçYıl")
	private String başlangıçYıl;
	
	@Column(name="BitişYıl")
	private String bitişYıl;
	
	@OneToOne()
	@JoinColumn(name= "Id")
	private User user;

	public JobExperiences() {
		
	}

	public JobExperiences(int id, String işYeriAdı, String pozisyon, String başlangıçYıl, String bitişYıl, User user) {
		super();
		this.id = id;
		this.işYeriAdı = işYeriAdı;
		this.pozisyon = pozisyon;
		this.başlangıçYıl = başlangıçYıl;
		this.bitişYıl = bitişYıl;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIşYeriAdı() {
		return işYeriAdı;
	}

	public void setIşYeriAdı(String işYeriAdı) {
		this.işYeriAdı = işYeriAdı;
	}

	public String getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

	public String getBaşlangıçYıl() {
		return başlangıçYıl;
	}

	public void setBaşlangıçYıl(String başlangıçYıl) {
		this.başlangıçYıl = başlangıçYıl;
	}

	public String getBitişYıl() {
		return bitişYıl;
	}

	public void setBitişYıl(String bitişYıl) {
		this.bitişYıl = bitişYıl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
