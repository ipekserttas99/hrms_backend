package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.dataAccess.abstracts.LanguagesDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager extends BaseManager<LanguagesDao, Language, String> implements LanguageService{
	@Autowired
	public LanguageManager(final LanguagesDao languageDao) {
		super(languageDao, "Language");
	}
}
