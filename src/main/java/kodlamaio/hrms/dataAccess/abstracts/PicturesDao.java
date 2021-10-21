package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Pictures;

public interface PicturesDao extends JpaRepository<Pictures, Integer>{
	Pictures getByUser_Id(int id);
	
	@Query("From Pictures where user.id=:id")
	List<Pictures> GetByUser(int id);
}