package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.User;

public class EmployersDto {
	private String sirketAdı;
	private String webSitesi;
	private String telefon;
	private User user;
	public EmployersDto() {
		
	}
	public EmployersDto(String sirketAdı, String webSitesi, String telefon, User user) {
		super();
		this.sirketAdı = sirketAdı;
		this.webSitesi = webSitesi;
		this.telefon = telefon;
		this.user = user;
	}
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
