package kodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	DataResult<List<JobPosition>> getAllSorted();
	Result add(JobPosition jobPosition);
	
	DataResult<JobPosition> getByPozisyonAd(String pozisyonAd);
	DataResult<JobPosition> getByPozisyonTanım(String pozisyonTanım);
	DataResult<JobPosition> getByŞehir(String sehir);
	DataResult<JobPosition> getByMaaş(String maaş);
	DataResult<JobPosition> getByYayınTarihi(Date yayınTarihi);
	DataResult<JobPosition> getBySonBaşvuruTarihi(Date sonBaşvuruTarihi);
	DataResult<JobPosition> getByAktifMi(boolean aktifMi);
	DataResult<JobPosition> getByAktifMiAndYayınTarihi(boolean aktifMi, Date yayınTarihi);
	DataResult<JobPosition> getByAktifMiAndFirma(boolean aktifMi, String firma);
	
	DataResult<List<JobPosition>> GetByPozisyonAd(String pozisyonAd);
}
