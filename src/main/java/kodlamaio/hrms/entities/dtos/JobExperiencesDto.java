package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.User;

public class JobExperiencesDto {
	private int id;
	private String işYeriAdı;
	private String pozisyon;
	private String başlangıçYıl;
	private String bitişYıl;
	private User user;
	public JobExperiencesDto() {
		
	}
	public JobExperiencesDto(int id, String işYeriAdı, String pozisyon, String başlangıçYıl, String bitişYıl,
			User user) {
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
