package miinaharava;

import javax.swing.JOptionPane;

/**
 * Luokka GUI sisältää main metodin.
 *
 * @author Marko Hassinen
 */
public class GUI {

    /**
     * Kaiken alku. Aloitetaan peli pelaajan valitsemalla vaikeustasolla.
     *
     * @param args
     */
    public static void main(String[] args) {
        aloitus(vaikeustasonKysyminen());
    }

    /**
     * Kysytään aluksi pelaajalta vaikeustaso
     *
     * @return
     */
    private static Object vaikeustasonKysyminen() {
        Object s = JOptionPane.showInputDialog(null, "Tervetuloa pelaamaan!\nValitse vaikeustaso!", "Miinaharava",
                JOptionPane.PLAIN_MESSAGE, null, new String[]{"helppo", "normaali", "vaikea"}, "vaikuestaso");
        return s;
    }

    /**
     * Kutsutaan vaikeustasonMaaritys-metodia pelaajan valitsemalla
     * vaikeustasolla.
     *
     * @param vaikeus
     */
    private static void aloitus(Object vaikeus) {
        if (vaikeus == "helppo") {
            vaikeustasonMaaritys(9, 9, 10);
        }
        if (vaikeus == "normaali") {
            vaikeustasonMaaritys(16, 16, 40);
        }
        if (vaikeus == "vaikea") {
            vaikeustasonMaaritys(30, 16, 99);
        }
    }

    /**
     * Määritetään ruudukon leveys, korkeus ja miinojen määrä.
     *
     * @param x
     * @param y
     * @param miinat
     */
    private static void vaikeustasonMaaritys(int x, int y, int miinat) {
        MiinapeliKehys gui = new MiinapeliKehys(x, y, miinat);
        gui.guiInit(x, y, miinat);
    }
}
