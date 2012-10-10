package miinaharava;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logiikka.Ruudukko;

/**
 * OmaPaneeli luokka on JPanel luokan aliluokka. OmaPaneeli luokka toteuttaa
 * rajapintaluokkaa MouseListener.
 *
 * @author Marko Hassinen
 */
public class OmaPaneeli extends JPanel implements MouseListener {

    private GridBagLayout g;
    private GridBagConstraints c;
    private Nappi nappi;
    private int x;
    private int y;
    private int miina;
    private Nappi[][] ruudukko;
    private Ruudukko logiikka;
    private boolean pelikesken;
    private ImageIcon kuva;

    /**
     * OmaPaneeli luokka yhdistää logiikan ja graafisen käyttöliittymän.
     */
    public OmaPaneeli() {
        g = new GridBagLayout();
        c = new GridBagConstraints();
        setLayout(g);
        setPreferredSize(new Dimension(400, 300));
        pelikesken = true;
    }

    /**
     * Pelin luonti erotettu konstruktorista, jotta ei tarvitse luoda uutta
     * OmaPaneeli olioita kun vaihdetaan vaikeustasoa.
     *
     * @param leveys
     * @param korkeus
     * @param miinat
     */
    public void luoPeli(int leveys, int korkeus, int miinat) {
        x = leveys;
        y = korkeus;
        miina = miinat;
        logiikka = new Ruudukko(x, y, miina);
        ruudukko = new Nappi[x][y];
        ruudukonLuonti();
    }

    /**
     * Metodi lisää OmaPaneeliin kaikki nappi oliot.
     */
    private void ruudukonLuonti() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ruudunLuonti(i, j);
            }
        }
    }

    /**
     * Yksittäisen nappi-olion luonti
     *
     * @param x
     * @param y
     */
    private void ruudunLuonti(int x, int y) {
        nappi = new Nappi(x, y);
        nappi.addMouseListener(this);
        ruudukko[x][y] = nappi;

        c.fill = GridBagConstraints.BOTH;
        c.gridx = x;
        c.gridy = y;
        add(nappi, c);
    }

    /**
     * Metodi määrittelee oikean ja vasemman hiiren painikkeen
     * toiminnallisuutta.
     *
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        nappi = (Nappi) e.getSource();

        if (pelikesken) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                vasenHiiri();
            }

            if (e.getButton() == MouseEvent.BUTTON3) {
                oikeaHiiri();
            }
        }
    }

    /**
     * Oikean hiiren painikkeen toiminta.
     */
    private void oikeaHiiri() {
        if (!logiikka.onkoAuki(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
            if (!logiikka.onkoLippu(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
                oikeaHiiriApu(true);
            } else {
                oikeaHiiriApu(false);
            }
        }
    }

    /**
     * Asettaa lipun tai poistaa sen.
     *
     * @param apu
     */
    private void oikeaHiiriApu(boolean apu) {
        nappi.naytaLippu(apu);
        logiikka.asetaLippu(nappi.getKordinaattiX(), nappi.getKordinaattiY(), apu);
    }

    /**
     * Vasemman hiiren painikkeen toiminta.
     */
    private void vasenHiiri() {
        int vihje;

        if (!logiikka.onkoAuki(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
            if (!logiikka.onkoLippu(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
                if (logiikka.onkoMiina(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
                    havio();
                } else {
                    eiMiinaa();
                }
                logiikka.avaa(nappi.getKordinaattiX(), nappi.getKordinaattiY());

                onkoVoitettu();
            }
        }
    }
    
    /**
     * Jos avattavassa ruudussa ei ollutkaan miinaa.
     */
    private void eiMiinaa() {
        int vihje = logiikka.getVihjeNumero(nappi.getKordinaattiX(), nappi.getKordinaattiY());
        nappi.naytaVihje(vihje);
        
        if (vihje == 0) {
            avaaTyhjat(nappi.getKordinaattiX(), nappi.getKordinaattiY());
        }
    }
    /**
     * Jos avattavassa ruudussa oli miina.
     */
    private void havio() {
        nappi.naytaMiina();
        naytaMiinat();
        kuva = new ImageIcon(getClass().getResource("/miinaharava/res/havio.png"));
        JOptionPane.showMessageDialog(null,null, "Häviö!", JOptionPane.PLAIN_MESSAGE, kuva);
        pelikesken = false;
    }

    /**
     * Luodaan uudet suljetut ruudut(napit) ja käsketään logiikan resetoimaan
     * tilastot.
     */
    public void uusiPeli() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ruudukko[i][j].alkuRuutu();
            }
        }

        pelikesken = true;
        logiikka.uusiPeli();
    }

    /**
     * Avaa tyhjää ruutua ympäröivät ruudut, ja jatkaa avaamista alkuperäisen
     * ruudun(sijaintiX, sijaintiY), kunnes avattu ruutu sisältää
     * vihjenumeron(>0).
     *
     * @param sijaintiX
     * @param sijaintiY
     */
    private void avaaTyhjat(int sijaintiX, int sijaintiY) {
        int vihje;
        Nappi apuNappi;

        for (int i = sijaintiX - 1; i < sijaintiX + 2; i++) {
            for (int j = sijaintiY - 1; j < sijaintiY + 2; j++) {
                if ((i >= 0 && i < x) && (j >= 0 && j < y)) {
                    if ((!(i == sijaintiX && j == sijaintiY)) && !(logiikka.onkoAuki(i, j)) && !(logiikka.onkoLippu(i, j))) {
                        apuNappi = ruudukko[i][j];

                        vihje = logiikka.getVihjeNumero(apuNappi.getKordinaattiX(), apuNappi.getKordinaattiY());
                        apuNappi.naytaVihje(vihje);

                        logiikka.avaa(apuNappi.getKordinaattiX(), apuNappi.getKordinaattiY());


                        if (vihje == 0) {
                            avaaTyhjat(apuNappi.getKordinaattiX(), apuNappi.getKordinaattiY());
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Näytetään pelaajalle kaikkien miinojen sijainti.
     */
    private void naytaMiinat() {
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++)
                if(logiikka.onkoMiina(i, j) && !(logiikka.onkoAuki(i, j))) {
                    nappi = ruudukko[i][j];
                    nappi.naytaMiina();
                }    
    }

    /**
     * Selvittää onko peli voitettu.
     */
    private void onkoVoitettu() {
        if (logiikka.voitettuPeli()) {
            pelikesken = false;
            naytaLipuilla();
            kuva = new ImageIcon(getClass().getResource("/miinaharava/res/voitto.png"));
            JOptionPane.showMessageDialog(null,null, "Voitto!", JOptionPane.PLAIN_MESSAGE, kuva);
        }
    }
    
    private void naytaLipuilla() {
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++)
                if(logiikka.onkoMiina(i, j) && !(logiikka.onkoAuki(i, j))) {
                    nappi = ruudukko[i][j];
                    nappi.naytaLippu(true);
                }    
    }

    /**
     * Peritty käyttämätön metodi
     *
     * @param e
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Peritty käyttämätön metodi
     *
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Peritty käyttämätön metodi
     *
     * @param e
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Peritty käyttämätön metodi
     *
     * @param e
     */
    public void mouseExited(MouseEvent e) {
    }
}