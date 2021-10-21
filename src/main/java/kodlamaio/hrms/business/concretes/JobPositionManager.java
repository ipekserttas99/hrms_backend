package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(),"Data listelendi");
	}


	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"pozisyonAd");
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(sort),"Başarılı");
	}

	@Override
	public DataResult<JobPosition> getByPozisyonAd(String pozisyonAd) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByPozisyonAd(pozisyonAd));
	}

	@Override
	public DataResult<List<JobPosition>> GetByPozisyonAd(String pozisyonAd) {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.GetByPozisyonAd(pozisyonAd));
	}

	@Override
	public DataResult<JobPosition> getByPozisyonTanım(String pozisyonTanım) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByPozisyonTanım(pozisyonTanım));
	}

	@Override
	public DataResult<JobPosition> getByŞehir(String sehir) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByŞehir(sehir));
	}

	@Override
	public DataResult<JobPosition> getByMaaş(String maaş) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByMaaş(maaş));
	}

	@Override
	public DataResult<JobPosition> getByYayınTarihi(Date yayınTarihi) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByYayınTarihi(yayınTarihi));
	}

	@Override
	public DataResult<JobPosition> getBySonBaşvuruTarihi(Date sonBaşvuruTarihi) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getBySonBaşvuruTarihi(sonBaşvuruTarihi));
	}

	@Override
	public DataResult<JobPosition> getByAktifMi(boolean aktifMi) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByAktifMi(aktifMi));
	}

	@Override
	public DataResult<JobPosition> getByAktifMiAndYayınTarihi(boolean aktifMi, Date yayınTarihi) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByAktifMiAndYayınTarihi(aktifMi,yayınTarihi));
	}

	@Override
	public DataResult<JobPosition> getByAktifMiAndFirma(boolean aktifMi, String firma) {
		return new SuccessDataResult<JobPosition>
		(this.jobPositionDao.getByAktifMiAndFirma(aktifMi,firma));
	}

}
