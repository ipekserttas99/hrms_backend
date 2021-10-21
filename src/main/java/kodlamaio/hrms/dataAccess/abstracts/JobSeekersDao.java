package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer>{
	JobSeekers getByAdAndSoyad(String ad, String soyad);
	List<JobSeekers> getByAdOrUser_id(String ad, int id);
	List<JobSeekers> getByTcNoContains(String tcNo);
	
	@Query("From JobSeekers where ad=:ad and user.id=:id")
	List<JobSeekers> GetByAdAndUser(String ad, int id);
}
