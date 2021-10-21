package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.HrmsStaffVerificateService;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class HrmsStaffVerificateManager implements HrmsStaffVerificateService{

	private EmployersDao employersDao;
	
	@Autowired
	public HrmsStaffVerificateManager(EmployersDao employersDao) {
		this.employersDao = employersDao;
	}

	
	
	@Override
	public Result approve(Employers employers) {
		this.employersDao.getByŞirketAdıOrUser_Id(employers.getSirketAdı(), employers.getUser().getId());
		return new SuccessResult("iş veren doğrulandı");
	}

}