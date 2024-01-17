package tr.edu.medipol.yazilimgelistirme.FinalOdeviServis;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/urun")
public class UrunWebServisi {
	
    // Ürün nesnesi oluşturuldu.
    public record Urun(String ad, double fiyat,String barkodNo, int adet) {};

    private static final List<Urun> URUN_LISTESI = new ArrayList<>();

    static {
        URUN_LISTESI.add(new Urun("laptop", 2500.0, "1",1));
        URUN_LISTESI.add(new Urun("telefon", 1000.0, "2",2));
        URUN_LISTESI.add(new Urun("tablet", 500.0, "3",3));
        URUN_LISTESI.add(new Urun("kamera", 50.0, "4",4));
        URUN_LISTESI.add(new Urun("poşet", 0.5, "0",0));
    }

 // Urun listeleme metodu
    @GetMapping("/")
    public List<Urun> listele() {
        return URUN_LISTESI;
    }
        
    // Urun bulma metodu
    @GetMapping("/{barkodNo}")
    public  Urun bul(@PathVariable String barkodNo) {
        for (Urun urun : URUN_LISTESI) {
            if (urun.barkodNo.equals(barkodNo)) {
                return urun;
            }
        }
        return null;
    }

    // Urun silme metodu
    @DeleteMapping("/{barkodNo}")
    public boolean sil(@PathVariable String barkodNo) {
        Urun urun = bul(barkodNo);
        if (urun != null) {
            URUN_LISTESI.remove(urun);
            return true;
        }
        return false;
    }
    
    // Urun ekleme metodu
    @PostMapping("/")
    public static boolean ekle(@RequestBody Urun urun) {
        if (!URUN_LISTESI.contains(urun)) {
            URUN_LISTESI.add(urun);         
            System.out.println("Ürün eklendi."+ urun.adet);
            return true;   
        } else {
        	System.out.println("Ürün zaten var.");
        	return false;
        }
    }
}
