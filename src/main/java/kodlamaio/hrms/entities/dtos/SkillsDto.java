package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.User;

public class SkillsDto {
	private int id;
	private String yetenekAdı;
	private User user;
	public SkillsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SkillsDto(int id, String yetenekAdı, User user) {
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
	public String getYetenekAdı() {
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
