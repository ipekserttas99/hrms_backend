package kodlamaio.hrms.business.abstracts;

public interface UserCheckService {
	boolean checkIfRealPerson(String tcNo, String ad, String soyad, String dogumYılı);
}
