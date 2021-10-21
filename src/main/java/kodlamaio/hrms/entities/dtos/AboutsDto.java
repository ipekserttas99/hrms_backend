package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.User;

public class AboutsDto {
	private int id;
	private String önYazı;
	private User user;
	
	public AboutsDto() {
		
	}

	public AboutsDto(int id, String önYazı, User user) {
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
