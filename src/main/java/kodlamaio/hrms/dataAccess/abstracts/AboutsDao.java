package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Abouts;

public interface AboutsDao extends JpaRepository<Abouts, Integer>{
	Abouts getByÖnYazıOrUser_Id(String önYazı, int id);
}