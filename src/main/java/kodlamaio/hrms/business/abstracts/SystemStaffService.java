package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;

public interface SystemStaffService {
	DataResult<List<SystemStaff>> getAll();
	Result add(SystemStaff systemStaff);
	
	DataResult<SystemStaff> getByPersonalAdAndPersonalSoyad(String personalAd, String personalSoyad);
	DataResult<SystemStaff> getByPersonalTitle(String personalTitle);
	DataResult<List<SystemStaff>> getByPersonalAdOrUser_id(String personalAd, int id);
	DataResult<List<SystemStaff>> getByPersonalAdContains(String personalAd);
	DataResult<List<SystemStaff>> getByAdAndUser(String personalAd, int id);
}
