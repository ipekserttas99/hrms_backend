package kodlamaio.hrms.business.concretes;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager extends BaseManager<CityDao, City, Short> implements CityService{
	private final CityDao cityDao;

	@Autowired
	public CityManager(final CityDao cityDao) {
		super(cityDao, "City");
		this.cityDao = cityDao;
	}
	
	@Override
	public DataResult<City> getByName(String name) {
		final Optional<City> city = cityDao.findByName(name);

		if (city.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("City"));

		return new SuccessDataResult<>(city.get());
	}

	@Override
	public DataResult<List<City>> getByNameContains(String name) {
		final Optional<List<City>> city = cityDao.findByNameContains(name);

		return new SuccessDataResult<>(city.get());
	}

}
