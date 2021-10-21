package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.hrms.entities.concretes.SystemStaff;

@Service
public class SystemStaffManager implements SystemStaffService{

	private SystemStaffDao systemStaffDao;
	
	@Autowired
	public SystemStaffManager(SystemStaffDao systemStaffDao) {
		super();
		this.systemStaffDao = systemStaffDao;
	}



	@Override
	public DataResult<List<SystemStaff>> getAll() {
		return new SuccessDataResult<List<SystemStaff>>
		(this.systemStaffDao.findAll(),"Data listelendi");
	}



	@Override
	public Result add(SystemStaff systemStaff) {
		this.systemStaffDao.save(systemStaff);
		return new SuccessResult("Sistem personeli eklendi");
	}



	@Override
	public DataResult<SystemStaff> getByPersonalAdAndPersonalSoyad(String personalAd, String personalSoyad) {
		return new SuccessDataResult<SystemStaff>
		(this.systemStaffDao.getByPersonalAdAndPersonalSoyad(personalAd, personalSoyad));
	}



	@Override
	public DataResult<SystemStaff> getByPersonalTitle(String personalTitle) {
		return new SuccessDataResult<SystemStaff>
		(this.systemStaffDao.getByPersonalTitle(personalTitle));
	}



	@Override
	public DataResult<List<SystemStaff>> getByPersonalAdOrUser_id(String personalAd, int id) {
		return new SuccessDataResult<List<SystemStaff>>
		(this.systemStaffDao.getByPersonalAdOrUser_id(personalAd, id));
	}



	@Override
	public DataResult<List<SystemStaff>> getByPersonalAdContains(String personalAd) {
		return new SuccessDataResult<List<SystemStaff>>
		(this.systemStaffDao.getByPersonalAdContains(personalAd));
	}



	@Override
	public DataResult<List<SystemStaff>> getByAdAndUser(String personalAd, int id) {
		return new SuccessDataResult<List<SystemStaff>>
		(this.systemStaffDao.getByAdAndUser(personalAd, id));
	}

}
