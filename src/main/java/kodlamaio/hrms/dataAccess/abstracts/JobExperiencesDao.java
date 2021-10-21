package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobExperiences;

public interface JobExperiencesDao extends JpaRepository<JobExperiences, Integer>{
	JobExperiences getByİşYeriAdıAndPozisyon(String işYeriAdı, String pozisyon);
	JobExperiences getByBitişYıl(String bitişYıl);
	
	@Query("From JobExperiences where bitişYıl=:bitişYıl and user.id=:id")
	List<JobExperiences> GetByBitişYılAndUser(String bitişYıl, int id);
}