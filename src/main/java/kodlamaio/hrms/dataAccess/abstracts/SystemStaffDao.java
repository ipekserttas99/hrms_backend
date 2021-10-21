package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.SystemStaff;

public interface SystemStaffDao extends JpaRepository<SystemStaff, Integer>{
	SystemStaff getByPersonalAdAndPersonalSoyad(String personalAd, String personalSoyad);
	SystemStaff getByPersonalTitle(String personalTitle);
	List<SystemStaff> getByPersonalAdOrUser_id(String personalAd, int id);
	List<SystemStaff> getByPersonalAdContains(String personalAd);
	
	@Query("From SystemStaff where personalAd=:personalAd and user.id=:id")
	List<SystemStaff> getByAdAndUser(String personalAd, int id);
}
