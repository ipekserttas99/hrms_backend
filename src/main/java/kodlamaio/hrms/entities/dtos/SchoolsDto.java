package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.User;

public class SchoolsDto {
	private int id;
	private String okulAd;
	private String başlangıçYıl;
	private String bitişYıl;
	private User user;
	public SchoolsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchoolsDto(int id, String okulAd, String başlangıçYıl, String bitişYıl, User user) {
		super();
		this.id = id;
		this.okulAd = okulAd;
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
	public String getOkulAd() {
		return okulAd;
	}
	public void setOkulAd(String okulAd) {
		this.okulAd = okulAd;
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
