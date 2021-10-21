package kodlamaio.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="kullanıcılar")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","kullanıcılar"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Email(message = "Lütfen geçerli bir e-posta adresi giriniz.")
	@NotNull(message = "E-posta alanı boş geçilemez.")
	@NotBlank(message = "E-posta alanı boş geçilemez.")
	@Column(name = "Email", unique = true)
	private String email;
	
	@NotNull(message = "Parola alanı boş geçilemez.")
	@NotBlank(message = "Parola alanı boş geçilemez.")
	@Column(name = "Password")
	private String password;

	@NotNull(message = "Parola tekrar alanı boş geçilemez.")
	@NotBlank(message = "Parola tekrar alanı boş geçilemez.")
	@Column(name = "PasswordAgain")
	private String passwordAgain;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id,
			@Email(message = "Lütfen geçerli bir e-posta adresi giriniz.") @NotNull(message = "E-posta alanı boş geçilemez.") @NotBlank(message = "E-posta alanı boş geçilemez.") String email,
			@NotNull(message = "Parola alanı boş geçilemez.") @NotBlank(message = "Parola alanı boş geçilemez.") String password,
			@NotNull(message = "Parola tekrar alanı boş geçilemez.") @NotBlank(message = "Parola tekrar alanı boş geçilemez.") String passwordAgain) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.passwordAgain = passwordAgain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

}
