package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.User;

public class LanguagesDto {
	private int id;
	private String dil;
	private String level;
	private User user;
	public LanguagesDto() {
		
	}
	public LanguagesDto(int id, String dil, String level, User user) {
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
