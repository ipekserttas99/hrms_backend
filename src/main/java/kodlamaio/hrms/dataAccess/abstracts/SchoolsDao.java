package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Schools;

public interface SchoolsDao extends JpaRepository<Schools, Integer>{
	Schools getByOkulAd(String okulAd);
	Schools getByBitişYıl(String bitişYıl);
	
	@Query("From Schools where bitişYıl=:bitişYıl and user.id=:id")
	List<Schools> GetByBitişYılAndUser(String bitişYıl, int id);
}