package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.User;

public class PicturesDto {
	private int id;
	private String fotoğrafUrl;
	private User user;
	public PicturesDto() {
		
	}
	public PicturesDto(int id, String fotoğrafUrl, User user) {
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
