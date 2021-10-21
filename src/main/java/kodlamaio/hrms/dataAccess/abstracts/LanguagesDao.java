package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{
	Languages getByDil(String dil);
	Languages getByLevel(String level);
	Languages getByDilOrUser_Id(String dil, int id);
	
	@Query("From Languages where dil=:dil and user.id=:id")
	List<Languages> GetByDilAndUser(String dil, int id);
}