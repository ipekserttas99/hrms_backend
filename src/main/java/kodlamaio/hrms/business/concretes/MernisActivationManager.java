package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisActivationService;
import kodlamaio.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.MernisActivationDao;
import kodlamaio.hrms.entities.concretes.MernisActivation;

@Service
public class MernisActivationManager extends BaseManager<MernisActivationDao, MernisActivation, Integer>
		implements MernisActivationService{
	private final MernisActivationDao mernisActivationDao;

	@Autowired
	public MernisActivationManager(final MernisActivationDao mernisActivationDao) {
		super(mernisActivationDao, "Mernis activation");
		this.mernisActivationDao = mernisActivationDao;
	}

	@Override
	public Result check(PersonForValidateFromMernisService personForValidateFromMernisService) {
		return new SuccessResult(Messages.verified("Mernis activation"));
	}

}
