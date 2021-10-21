package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Skills;

public interface SkillsDao extends JpaRepository<Skills, Integer>{
	Skills getByYetenekAdı(String yetenekAdı);
	Skills getByYetenekAdıOrUser_Id(String yetenekAdı, int id);
}