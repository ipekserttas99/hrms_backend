package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PicturesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PicturesDao;
import kodlamaio.hrms.entities.concretes.Pictures;
@Service
public class PicturesManager implements PicturesService{

	private PicturesDao picturesDao;
	
	@Autowired
	public PicturesManager(PicturesDao picturesDao) {
		super();
		this.picturesDao = picturesDao;
	}

	
	@Override
	public Result add(Pictures pictures) {
		this.picturesDao.save(pictures);
		return new SuccessResult("Fotoğraf eklendi");
	}

	@Override
	public DataResult<Pictures> getByUser_Id(int id) {
		return new SuccessDataResult<Pictures>
		(this.picturesDao.getByUser_Id(id));
	}

	@Override
	public DataResult<List<Pictures>> GetByUser(int id) {
		return new SuccessDataResult<List<Pictures>>
		(this.picturesDao.GetByUser(id));
	}

}
