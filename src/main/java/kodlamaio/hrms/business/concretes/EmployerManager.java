package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CompanyStaffVerificationService;
import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.business.abstracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.helpers.image.ImageService;
import kodlamaio.hrms.core.utilities.helpers.image.cloudinary.CloudinaryImageHelper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.hrms.entities.concretes.CompanyStaffVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForUpdateDto;

@Service
public class EmployerManager extends BaseManager<EmployerDao, Employer, Integer> implements EmployerService{
	private final EmployerDao employerDao;
	private final EmployerUpdateDao employerUpdateDao;
	private final UserService userService;
	private final EmailActivationService emailActivationService;
	private final CompanyStaffVerificationService companyStaffVerificationService;
	private final ImageService imageService;

	@Autowired
	public EmployerManager(final EmployerDao employerDao, final EmployerUpdateDao employerUpdateDao,
			final UserService userService, final EmailActivationService emailActivationService,
			final CompanyStaffVerificationService companyStaffVerificationService, final ImageService imageService) {
		super(employerDao, "Employer");
		this.employerDao = employerDao;
		this.employerUpdateDao = employerUpdateDao;
		this.userService = userService;
		this.emailActivationService = emailActivationService;
		this.companyStaffVerificationService = companyStaffVerificationService;
		this.imageService = imageService;
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult()
				: new ErrorResult(Messages.passwordsNotMatch);
	}

	private Result isCorporateEmail(final String email, final String website) {
		return email.split("@")[1].equals(website) ? new SuccessResult() : new ErrorResult(kodlamaio.hrms.business.constants.Messages.emailNotCorporate);
	}

	@Override
	public DataResult<EmployerUpdate> getLastUpdateByUserId(int employerId) {
		final List<EmployerUpdate> employerUpdates = employerUpdateDao
				.findAllByEmployer_IdOrderByUpdatedAtDesc(employerId);

		if (employerUpdates.size() == 0)
			return new ErrorDataResult<>(Messages
					.notFound("Pending update approval"));

		return new SuccessDataResult<EmployerUpdate>(employerUpdates.get(0));
	}

	@Override
	public DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted) {
		final List<EmployerUpdate> employerUpdates = employerUpdateDao.findAllByIsApprovedAndIsDeleted(isApproved,
				isDeleted);

		return new SuccessDataResult<List<EmployerUpdate>>(employerUpdates);
	}

	@Override
	public Result isNotCorporateEmailExist(String corporateEmail) {
		return employerDao.findByCorporateEmail(corporateEmail).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages
						.alreadyExists("A employer with the corporate email"));
	}

	@Override
	public Result register(EmployerForRegisterDto employerForRegister) {
		final Result businessRulesResult = BusinessRules.run(
				userService.isNotEmailExist(employerForRegister.getEmail()),
				isNotCorporateEmailExist(employerForRegister.getCorporateEmail()),
				arePasswordMatch(employerForRegister.getPassword(), employerForRegister.getConfirmPassword()),
				isCorporateEmail(employerForRegister.getCorporateEmail(), employerForRegister.getWebsite()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final Employer employer = Employer.childBuilder()
				.email(employerForRegister.getEmail())
				.password(employerForRegister.getPassword())
				.companyName(employerForRegister.getCompanyName())
				.website(employerForRegister.getWebsite())
				.corporateEmail(employerForRegister.getCorporateEmail())
				.phone(employerForRegister.getPhone())
				.build();
		super.add(employer);

		emailActivationService
				.createAndSendActivationCodeByMail(employer, employer.getEmail(), employer.getCorporateEmail());
		companyStaffVerificationService.add(CompanyStaffVerification.builder().user(employer).build());

		return new SuccessResult(
				Messages.complete("Employer registration"));
	}

	@Override
	public Result updateByUser(EmployerForUpdateDto employerForUpdateDto, MultipartFile companyImage) {
		final Optional<Employer> employer = employerDao.findById(employerForUpdateDto.getEmployerId());
		if (employer.isEmpty())
			return new ErrorResult(
					Messages.notFound("Employer"));

		final Result businessRulesResult = BusinessRules
				.run(arePasswordMatch(employer.get().getPassword(), employerForUpdateDto.getPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final EmployerUpdate.EmployerUpdateBuilder employerUpdate = EmployerUpdate.builder()
				.employer(employer.get())
				.companyName(employerForUpdateDto.getCompanyName())
				.website(employerForUpdateDto.getWebsite())
				.corporateEmail(employerForUpdateDto.getCorporateEmail())
				.phone(employerForUpdateDto.getPhone());
		if (companyImage != null) {
			String companyImageUrl = imageService.save(companyImage).getData().getUrl();
			employerUpdate.companyImageUrl(companyImageUrl);
		}
		employerUpdateDao.save(employerUpdate.build());

		return new SuccessResult(
				Messages.awaitingApproval("Employer update"));
	}

	@Override
	public Result verifyUpdate(int employerUpdateId) {
		final Optional<EmployerUpdate> employerUpdate = employerUpdateDao.findById(employerUpdateId);
		if (employerUpdate.isEmpty())
			return new ErrorResult(
					Messages.notFound("Employer update"));

		final Employer employer = super.getById(employerUpdate.get().getEmployer().getId()).getData();
		employer.setCompanyName(employerUpdate.get().getCompanyName());
		if (employerUpdate.get().getCompanyImageUrl() != null) {
			if (employer.getCompanyImageUrl() != null) {
				String imagePublicId = CloudinaryImageHelper.getImagePublicIdFromUrl(employer.getCompanyImageUrl());
				imageService.delete(imagePublicId);
			}
			employer.setCompanyImageUrl(employerUpdate.get().getCompanyImageUrl());
		}
		employer.setWebsite(employerUpdate.get().getWebsite());
		employer.setCorporateEmail(employerUpdate.get().getCorporateEmail());
		employer.setPhone(employerUpdate.get().getPhone());
		super.update(employer);

		employerUpdate.get().setApproved(true);
		employerUpdate.get().setDeleted(true);
		employerUpdateDao.save(employerUpdate.get());

		return new SuccessResult(
				Messages.verified("Employer update"));
	}

	@Override
	public Result denyUpdate(int employerUpdateId) {
		final Optional<EmployerUpdate> employerUpdate = employerUpdateDao.findById(employerUpdateId);
		if (employerUpdate.isEmpty())
			return new ErrorResult(
					Messages.notFound("Employer update"));

		if (employerUpdate.get().getCompanyImageUrl() != null) {
			String imagePublicId = CloudinaryImageHelper
					.getImagePublicIdFromUrl(employerUpdate.get().getCompanyImageUrl());
			imageService.delete(imagePublicId);
		}
		employerUpdate.get().setApproved(false);
		employerUpdate.get().setDeleted(true);
		employerUpdateDao.save(employerUpdate.get());

		return new SuccessResult(
				Messages.denied("Employer update"));
	}
}
