package tr.edu.medipol.yazilimgelistirme.FinalOdeviServis;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/urun")
public class UrunWebServisi {

    public record Urun(String ad, double fiyat,String barkodNo) {};

    private static final List<Urun> URUN_LISTESI = new ArrayList<>();

    static {
        URUN_LISTESI.add(new Urun("laptop", 2500.0, "1"));
        URUN_LISTESI.add(new Urun("telefon", 1000.0, "2"));
        URUN_LISTESI.add(new Urun("tablet", 500.0, "3"));
        URUN_LISTESI.add(new Urun("kamera", 50.0, "4"));
        URUN_LISTESI.add(new Urun("poşet", 0.5, "0"));
    }

    @GetMapping("/")
    public List<Urun> listele() {
        return URUN_LISTESI;
    }

    @GetMapping("/{barkodNo}")
    public  Urun bul(@PathVariable String barkodNo) {
        for (Urun urun : URUN_LISTESI) {
            if (urun.barkodNo.equals(barkodNo)) {
                return urun;
            }
        }
        return null;
    }

    /*
    @DeleteMapping("/{barkodNo}")
    public boolean sil(@PathVariable String barkodNo) {
        Urun urun = bul(barkodNo);
        if (urun != null) {
            URUN_LISTESI.remove(urun);
            return true;
        }
        return false;
    } */
    
    @PostMapping("/")
    public boolean ekle(@RequestBody Urun urun) {
        if (!URUN_LISTESI.contains(urun)) {
            URUN_LISTESI.add(urun);
            System.out.println("Ürün eklendi.");
            return true;
        } else {
        	System.out.println("Ürün zaten var.");
        	return false;
        }
    }
}
