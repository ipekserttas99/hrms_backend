package kodlamaio.hrms.dataAccess.abstracts;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WebSite;

public interface WebSiteDao extends JpaRepository<WebSite, Short>{
	Optional<WebSite> findByName(String name);
}
