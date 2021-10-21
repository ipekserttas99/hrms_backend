package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
	Employers getByŞirketAdıAndWebSitesi(String sirketAdı, String webSitesi);
	Employers getByŞirketAdıOrUser_Id(String sirketAdı, int id);
	
	@Query("From Employers where sirketAdı=:sirketAdı and user.id=:id")
	List<Employers> GetByŞirketAdıAndUser(String sirketAdı, int id);
	
}
