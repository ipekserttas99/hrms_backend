package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.MernisActivation;

public interface MernisActivationService extends BaseService<MernisActivation, Integer>{
	Result check(PersonForValidateFromMernisService personForValidateFromMernisService);
}
