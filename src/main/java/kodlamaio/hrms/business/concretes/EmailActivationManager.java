package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.helpers.email.EmailService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailActivationDao;
import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.dtos.EmailActivationForVerifyDto;

@Service
public class EmailActivationManager extends BaseManager<EmailActivationDao, EmailActivation, Integer>
		implements EmailActivationService{
	private final EmailActivationDao emailActivationDao;
	private final EmailService emailService;

	@Autowired
	public EmailActivationManager(final EmailActivationDao emailActivationDao, final EmailService emailService) {
		super(emailActivationDao, "Email activation");
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result createAndSendActivationCodeByMail(User user, String... emails) {
		for (final String email : emails) {
			final EmailActivation emailActivation = EmailActivation.builder()
					.user(user)
					.email(email)
					.activationCode("EmailActivationCodeTEST") // TODO create activationCode
					.expirationDate(LocalDateTime.now().plusMonths(1))
					.build();
			super.add(emailActivation);
			emailService.send(email,
					Messages.emailActivationVerifyEmailTitle,
					String.format("%swww.localhost:8080/api/emailactivations/verify?activationCode=%s&email=%s",
							Messages.emailActivationVerifyEmailBody,
							emailActivation.getActivationCode(),
							email));
		}

		return new SuccessResult(Messages.emailActivationCreatedAndSent);
	}

	@Override
	public Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final Optional<EmailActivation> emailActivation = emailActivationDao.findByEmailAndActivationCode(
				emailActivationForVerifyDto.getEmail(),
				emailActivationForVerifyDto.getActivationCode());

		if (emailActivation.isEmpty())
			return new ErrorResult(
					kodlamaio.hrms.core.business.constants.Messages.notVerified("Email"));

		emailActivation.get().setActivated(true);
		emailActivationDao.save(emailActivation.get());

		return new SuccessResult(kodlamaio.hrms.core.business.constants.Messages.verified("Email"));
	}
	
	
}
