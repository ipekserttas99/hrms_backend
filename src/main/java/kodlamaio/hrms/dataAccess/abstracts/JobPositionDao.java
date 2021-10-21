package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	JobPosition getByPozisyonAd(String pozisyonAd);
	JobPosition getByPozisyonTanım(String pozisyonTanım);
	JobPosition getByŞehir(String sehir);
	JobPosition getByMaaş(String maaş);
	JobPosition getByYayınTarihi(Date yayınTarihi);
	JobPosition getBySonBaşvuruTarihi(Date sonBaşvuruTarihi);
	JobPosition getByAktifMi(boolean aktifMi);
	JobPosition getByAktifMiAndYayınTarihi(boolean aktifMi, Date yayınTarihi);
	JobPosition getByAktifMiAndFirma(boolean aktifMi, String firma);
	
	@Query("From JobPosition where pozisyonAd=:pozisyonAd")
	List<JobPosition> GetByPozisyonAd(String pozisyonAd);
}
