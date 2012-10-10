package logiikka;

/**
 * Logiikka on jaettu kahteen luokkaan: Ruutu ja Ruudukko. Ruutu sisältää
 * yksittäisen ruudun tietoa.
 *
 * @author Marko Hassinen
 */
public class Ruutu {

    private boolean miinoitettuRuutu;
    private boolean avattuRuutu;
    private boolean liputettuRuutu;

    /**
     * Ruutu luokan konstruktori. Asettaa jokaiselle muuttujalle arvon false.
     */
    public Ruutu() {
        miinoitettuRuutu = false;
        avattuRuutu = false;
        liputettuRuutu = false;
    }

    /**
     * Kertoo onko ruudussa miina.
     */
    public boolean onkoMiina() {
        return miinoitettuRuutu;
    }

    /**
     * Kertoo onko ruutu avattu.
     */
    public boolean onkoAvattu() {
        return avattuRuutu;
    }

    /**
     * Kertoo onko ruudun päälle asetettu lippu.
     */
    public boolean onkoLippu() {
        return liputettuRuutu;
    }

    /**
     * Asettaa miinan ruudulle ehdolla miina. Jos ehto miina ei päde, miina
     * poistetaan.
     *
     * @param miina
     */
    public void asetaMiina(boolean miina) {
        if (miina) {
            miinoitettuRuutu = true;
        } else {
            miinoitettuRuutu = false;
        }
    }

    /**
     * Avaa ruudun ehdolla avaa. Jos ehto avaa ei päde, ruutu suljetaan.
     *
     * @param avaa
     */
    public void asetaAvattu(boolean avaa) {
        if (avaa) {
            avattuRuutu = true;
        } else {
            avattuRuutu = false;
        }
    }

    /**
     * Asettaa ruudulle lipun jos metodia kutsutaan lipun arvolla true. Jos
     * metodia kutsutaan lipun arvolla false, lippu poistetaan ruudulta
     *
     * @param lippu
     */
    public void asetaLippu(boolean lippu) {
        if (lippu) {
            liputettuRuutu = true;
        } else {
            liputettuRuutu = false;
        }
    }
}
