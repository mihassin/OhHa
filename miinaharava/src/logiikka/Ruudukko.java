package logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Logiikan toinen osa. Ruudukko on Ruutu taulukko.
 * Ruudukko hoitaa myös ruutujen miinoituksen.
 * @author Marko Hassinen
 */
public class Ruudukko {
    
    public static final int MIINA = 1;
    public static final int MIINATON = 0;
    private int x;
    private int y;
    private int vihjeNumero;
    private int miinaLkm;
    private Ruutu[][] ruudukko;
    
    /**
     * Ruudukon konstruktori.
     * Luo x * y kokoisen ruutu taulukon.
     * @param leveys
     * @param korkeus
     * @param miinat 
     */
    public Ruudukko(int leveys, int korkeus, int miinat) {
        x = leveys;
        y = korkeus;
        miinaLkm = miinat;
        ruudukko = new Ruutu[x][y];

        lisaaRuudutTauluun();
        miinoitaRuudukko();
    }
    /**
     * Luo jokaisen taulukon ruutu olion. Ruutuja on ruudukossa x * y määrä.
     */
    private void lisaaRuudutTauluun() {
        for(int i = 0; i < x; i++) {
            for(int j = 0; j< y; j++) {
                ruudukko[i][j] = new Ruutu();
            }    
        }
    }
    /**
     * Lisää Ruudukkoon satunnaisille paikoille miinat.
     * Miinoja on Ruudukossa miinaLkm määrä.
     */
    private void miinoitaRuudukko() {
        List<Integer> apu = new ArrayList<Integer>(x*y);
        
        for(int i=0; i < miinaLkm ; i++)
            apu.add(MIINA);
        for(int i=0; i<x*y-miinaLkm; i++)
            apu.add(MIINATON);
        
        Collections.shuffle(apu);
        
        int apuTaulunKoko = 0;
        
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(apu.get(apuTaulunKoko) == 1)
                    ruudukko[i][j].asetaMiina(true);
                apuTaulunKoko++;
            }
        }
    }
    /**
     * Palauttaa ruudukon sarakkeiden määrän.
     * @return 
     */
    public int getLeveys() {
        return x;
    }
    /**
     * Palauttaa ruudukon rivijen määrän.
     * @return 
     */
    public int getKorkeus() {
        return y;
    }
    /**
     * Palauttaa ruudun kohdassa (sijaintiX, sijaintiY)
     * @param sijaintiX
     * @param sijaintiY
     * @return 
     */
    public Ruutu getRuutu(int sijaintiX, int sijaintiY) {
        return ruudukko[sijaintiX][sijaintiY];
    }
    /**
     * Kertoo onko ruutu avattu kohdassa (sijaintiX, sijaintiY)
     * @param sijaintiX
     * @param sijaintiY
     * @return 
     */
    public boolean onkoAuki(int sijaintiX, int sijaintiY) {
        return ruudukko[sijaintiX][sijaintiY].onkoAvattu();
    }
    /**
     * Kertoo onko kohdassa (sijaintiX, sijaintiY) ruudulle asetettu lippu.
     * @param sijaintiX
     * @param sijaintiY
     * @return 
     */
    public boolean onkoLippu(int sijaintiX, int sijaintiY) {
        return ruudukko[sijaintiX][sijaintiY].onkoLippu();
    }
    /**
     * Kertoo onko kohdassa (sijaintiX, sijaintiY) ruutu miinoitettu.
     * @param sijaintiX
     * @param sijaintiY
     * @return 
     */
    public boolean onkoMiina(int sijaintiX, int sijaintiY) {
        return ruudukko[sijaintiX][sijaintiY].onkoMiina();
    }
    /**
     * Asettaa ruudulle kohdassa (sijaintiX, sijaintiY) lipun, jos ruudulla ei ole lippua.
     * Jos ruudulla on lippu, lippu poistetaan. Palauttaa arvon true, jos algoritmi onnistui.
     * Muussa tapauksessa palauttaa arvon false.
     * @param sijaintiX
     * @param sijaintiY
     * @param lippu
     * @return 
     */
    public boolean asetaLippu(int sijaintiX, int sijaintiY, boolean lippu) {

        if (!ruudukko[sijaintiX][sijaintiY].onkoLippu() && lippu) {
            ruudukko[sijaintiX][sijaintiY].asetaLippu(true);
            return true;
        }
        else if (ruudukko[sijaintiX][sijaintiY].onkoLippu() && !lippu) {
            ruudukko[sijaintiX][sijaintiY].asetaLippu(false);
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Avaa ruudun kohdassa(sijaintiX, sijaintiY), jos ruutu ei ole avattu.
     * @param sijaintiX
     * @param sijaintiY 
     */
    public void avaa(int sijaintiX, int sijaintiY) {
        if (!ruudukko[sijaintiX][sijaintiY].onkoAvattu()) {
            ruudukko[sijaintiX][sijaintiY].asetaAvattu(true);
        }
    }
    /**
     * Tutkii ruudun kohdassa (sijaintiX, sijaintiY) ympäröivät ruudut. 
     * Jos vierus ruudussa on miina, se kirjataan ylös.
     * Yhtä ruutua ympäröi useimmiten 8 miinaa. Nurkassa ruutua ympäröi 3 ruutua.
     * Laidoissa ruutua ympäröi 5 ruutua. Palauttaa tiedon, kuinka monta miinoitettua
     * ympäröivää ruutua on.
     * @param sijaintiX
     * @param sijaintiY
     * @return 
     */
    public int getVihjeNumero(int sijaintiX, int sijaintiY) {
        vihjeNumero = 0;
        
        for(int i = sijaintiX-1; i < sijaintiX+2; i++) {
            for(int j = sijaintiY-1; j < sijaintiY+2; j++) {
                if((i>=0 && i<x) && (j>=0 && j<y)) {
                    if((!(i==sijaintiX && j==sijaintiY)) && ruudukko[i][j].onkoMiina()) {
                        vihjeNumero++;
                    }
                }
            }
        }
         return vihjeNumero;
    }
    /**
     * Uuden pelin luodessa, metodi asettaa joka ruudulle false arvon miinoille, lipuille ja avatuille.
     */
    public void uusiPeli() {
        for(int i = 0; i<x; i++) {
            for(int j= 0; j<y; j++){
                ruudukko[i][j].asetaAvattu(false);
                ruudukko[i][j].asetaMiina(false);
                ruudukko[i][j].asetaLippu(false);
            }
        }     
        miinoitaRuudukko();
    }
}