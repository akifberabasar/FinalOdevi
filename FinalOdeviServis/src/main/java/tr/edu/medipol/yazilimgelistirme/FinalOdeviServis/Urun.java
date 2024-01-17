package tr.edu.medipol.yazilimgelistirme.FinalOdeviServis;

public class Urun {
	
	// Ürün sınıfı oluşturuldu.
    private String ad;
    private double fiyat;
    private String barkodNo;

    public Urun() {
        
    }

    public Urun(String ad, double fiyat, String barkodNo) {
        this.ad = ad;
        this.fiyat = fiyat;
        this.barkodNo = barkodNo;
    }
    
    // getter vee setter metodları yazıldı.

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
    
    public String getbarkodNo() {
        return barkodNo;
    }

    public void setbarkodNo(String barkodNo) {
        this.barkodNo = barkodNo;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
