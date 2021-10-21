package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillsDao;
import kodlamaio.hrms.entities.concretes.Skills;

@Service
public class SkillsManager implements SkillsService{

	private SkillsDao skillsDao;
	
	@Autowired
	public SkillsManager(SkillsDao skillsDao) {
		super();
		this.skillsDao = skillsDao;
	}

	@Override
	public Result add(Skills skills) {
		this.skillsDao.save(skills);
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public DataResult<Skills> getByYetenekAdı(String yetenekAdı) {
		return new SuccessDataResult<Skills>
		(this.skillsDao.getByYetenekAdı(yetenekAdı));
	}

	@Override
	public DataResult<Skills> getByYetenekAdıOrUser_Id(String yetenekAdı, int id) {
		return new SuccessDataResult<Skills>
		(this.skillsDao.getByYetenekAdıOrUser_Id(yetenekAdı, id));
	}

}
