package kodlamaio.hrms.entities.dtos;

import java.util.Date;

public class JobPositionDto {
	private int id;
	private String pozisyonAd;
	private String pozisyonTanım;
	private String sehir;
	private String maaş;
	private Date yayınTarihi;
	private Date sonBaşvuruTarihi;
	private String firma;
	private boolean aktifMi;
	
	public JobPositionDto() {
		
	}

	public JobPositionDto(int id, String pozisyonAd, String pozisyonTanım, String sehir, String maaş, Date yayınTarihi,
			Date sonBaşvuruTarihi, String firma, boolean aktifMi) {
		super();
		this.id = id;
		this.pozisyonAd = pozisyonAd;
		this.pozisyonTanım = pozisyonTanım;
		this.sehir = sehir;
		this.maaş = maaş;
		this.yayınTarihi = yayınTarihi;
		this.sonBaşvuruTarihi = sonBaşvuruTarihi;
		this.firma = firma;
		this.aktifMi = aktifMi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPozisyonAd() {
		return pozisyonAd;
	}

	public void setPozisyonAd(String pozisyonAd) {
		this.pozisyonAd = pozisyonAd;
	}

	public String getPozisyonTanım() {
		return pozisyonTanım;
	}

	public void setPozisyonTanım(String pozisyonTanım) {
		this.pozisyonTanım = pozisyonTanım;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public String getMaaş() {
		return maaş;
	}

	public void setMaaş(String maaş) {
		this.maaş = maaş;
	}

	public Date getYayınTarihi() {
		return yayınTarihi;
	}

	public void setYayınTarihi(Date yayınTarihi) {
		this.yayınTarihi = yayınTarihi;
	}

	public Date getSonBaşvuruTarihi() {
		return sonBaşvuruTarihi;
	}

	public void setSonBaşvuruTarihi(Date sonBaşvuruTarihi) {
		this.sonBaşvuruTarihi = sonBaşvuruTarihi;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public boolean isAktifMi() {
		return aktifMi;
	}

	public void setAktifMi(boolean aktifMi) {
		this.aktifMi = aktifMi;
	}
}
