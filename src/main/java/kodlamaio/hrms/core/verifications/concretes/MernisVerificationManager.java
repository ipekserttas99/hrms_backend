package kodlamaio.hrms.core.verifications.concretes;

import java.rmi.RemoteException;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisVerificationManager {

	
	public boolean checkIfRealPerson(String tcNo, String ad, String soyad, String dogumYılı) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = false;
		
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula
					(Long.parseLong(tcNo), 
					ad.toUpperCase(), 
					soyad.toUpperCase(), 
					Integer.parseInt(dogumYılı));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
	}
