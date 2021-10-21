package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserCheckService;


@Service
public class UserCheckManager implements UserCheckService{


	@Override
	public boolean checkIfRealPerson(String tcNo, String ad, String soyad, String dogumYılı) {
		return true;
	}

}
