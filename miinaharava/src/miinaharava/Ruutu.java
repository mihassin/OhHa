package miinaharava;

public class Ruutu {
    
    private boolean miinoitettuRuutu;
    private boolean avattuRuutu;
    private boolean liputettuRuutu;
    
    public Ruutu() {
        miinoitettuRuutu = false;
        avattuRuutu = false;
        liputettuRuutu = false;
    }
    
    public boolean onkoMiina() {
        return miinoitettuRuutu;
    }
    
    public boolean onkoAvattu() {
        return avattuRuutu;
    }
    
    public boolean onkoLippu() {
        return liputettuRuutu;
    }
    
    public void asetaMiina(){
        miinoitettuRuutu = true;
    }
    
    public void asetaAvattu() {
        avattuRuutu = true;
    }
    
    public void asetaLippu() {
        liputettuRuutu = true;
    }
    
    public String toString() {
        return "i exist";
    }
}
