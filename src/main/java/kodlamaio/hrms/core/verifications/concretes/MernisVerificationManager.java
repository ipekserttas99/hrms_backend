package kodlamaio.hrms.core.verifications.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlamaio.hrms.core.verifications.abstracts.MernisVerificateService;
import kodlamaio.hrms.entities.concretes.JobSeekers;

public class MernisVerificationManager implements MernisVerificateService{

	@Override
	public boolean checkIfRealPerson(JobSeekers jobSeekers) {
		tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy client = new tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getTcNo()),
					jobSeekers.getAd().toUpperCase(new Locale("tr")),
					jobSeekers.getSoyad().toUpperCase(new Locale("tr")), Integer.parseInt(jobSeekers.getDogumYılı()));
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return true;
	}
	}
