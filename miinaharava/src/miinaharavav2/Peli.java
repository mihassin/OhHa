
package miinaharavav2;

public class Peli {
    
    private int korkeus;
    private int leveys;
    private int miinojenLkm;
    private int liputetutRuudut;
    
    public Peli(Miinaharava miinaharava, int l, int k, int miinoja){
        miinaharava = new Miinaharava();
        this.leveys = l;
        this.korkeus = k;
        this.miinojenLkm = miinoja;
    }  
    
    public int getKorkeus() {
        return korkeus;
    }
    
    public int getLeveys() {
        return leveys;
    }
    
    public int getMiinojenLkm() {
        return miinojenLkm;
    }
    
    public int getMiinojaJaljella() {
        return miinojenLkm - liputetutRuudut;
    }
}
