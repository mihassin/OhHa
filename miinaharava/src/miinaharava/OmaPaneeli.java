package miinaharava;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logiikka.*;
/**
 * OmaPaneeli luokka on JPanel luokan aliluokka.
 * OmaPaneeli luokka toteuttaa rajapintaluokkaa MouseListener.
 * @author Marko
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
    private int miinattomatRuudut;
    /**
     * OmaPaneeli luokka yhdistää logiikan ja graafisen käyttöliittymän.
     */
    public OmaPaneeli() {
        g = new GridBagLayout();
        c = new GridBagConstraints();
        setLayout(g);
        setPreferredSize(new Dimension(400,300));
        pelikesken = true;
    }
    /**
     * Pelin luonti erotettu konstruktorista, jotta ei tarvitse luoda uutta OmaPaneeli olioita kun vaihdetaan vaikeustasoa.
     * @param leveys
     * @param korkeus
     * @param miinat 
     */
    public void luoPeli(int leveys, int korkeus, int miinat) {
        x = leveys;
        y = korkeus;
        miina = miinat;
        miinattomatRuudut = (leveys*korkeus) - miinat;
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
                nappi = new Nappi(i, j);

                ruudukko[i][j] = nappi;
                nappi.addMouseListener(this);

                c.fill = GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = j;
                add(nappi, c);
            }
        }
    }
    /**
     * Metodi määrittelee oikean ja vasemman hiiren painikkeen toiminnallisuutta.
     * @param e 
     */
    public void mouseClicked(MouseEvent e) {
        nappi = (Nappi) e.getSource();
        peliKesken();
        if(pelikesken) {
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
                nappi.naytaLippu(true);
                logiikka.asetaLippu(nappi.getKordinaattiX(), nappi.getKordinaattiY(), true);
            }

            else {
                nappi.naytaLippu(false);
                logiikka.asetaLippu(nappi.getKordinaattiX(), nappi.getKordinaattiY(), false);
            }
        }
    }
    /**
     * Vasemman hiiren painikkeen toiminta.
     */
    private void vasenHiiri() {
        int vihje;
        
        if (!logiikka.onkoAuki(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
            if (!logiikka.onkoLippu(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
                if(logiikka.onkoMiina(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
                    nappi.naytaMiina();
                    JOptionPane.showMessageDialog(null, "Hävisit pelin!");
                    pelikesken = false;
                }
                else {
                    vihje = logiikka.getVihjeNumero(nappi.getKordinaattiX(), nappi.getKordinaattiY());
                    nappi.naytaVihje(vihje);
                    if(vihje == 0) {
                        avaaTyhjat(nappi.getKordinaattiX(),nappi.getKordinaattiY());
                    }
                }
                logiikka.avaa(nappi.getKordinaattiX(), nappi.getKordinaattiY());   
            }
        }
    }
 
    /**
     * Lasketaan avattuja miinattomia ruutuja. Peli loppuu, jos kaikki miinattomat ruudut on avattu.
     * Erotettu logiikasta.
     */
    private void peliKesken() {
        int apu = miinattomatRuudut;
        for(int i = 0; i<x; i++){
            for(int j= 0; j<y; j++) {
                if(logiikka.onkoAuki(i, j))
                    apu--;
            }
        }
        if(apu == 0) {
            pelikesken = false;
            JOptionPane.showMessageDialog(null, "Voitit pelin!");
        }
    }       

    /**
     * Luodaan uudet suljetut ruudut(napit) ja käsketään logiikan resetoimaan tilastot.
     */
    public void uusiPeli() {
        for(int i = 0; i<x; i++)
            for(int j = 0; j<y; j++)
                ruudukko[i][j].alkuRuutu();
        pelikesken = true;
        logiikka.uusiPeli();
    }
    /**
     * Avaa tyhjää ruutua ympäröivät ruudut, ja jatkaa avaamista alkuperäisen ruudun(sijaintiX, sijaintiY),
     * kunnes avattu ruutu sisältää vihjenumeron(>0).
     * @param sijaintiX
     * @param sijaintiY 
     */
    private void avaaTyhjat(int sijaintiX, int sijaintiY) {
        int vihje;
        Nappi apuNappi;

        for(int i = sijaintiX-1; i < sijaintiX+2; i++) {
            for(int j = sijaintiY-1; j < sijaintiY+2; j++) {
                if((i>=0 && i<x) && (j>=0 && j<y)) {
                    if((!(i==sijaintiX && j==sijaintiY)) && !(logiikka.onkoAuki(i, j))) {
                        apuNappi = ruudukko[i][j];
                        
                        vihje = logiikka.getVihjeNumero(apuNappi.getKordinaattiX(), apuNappi.getKordinaattiY());
                        apuNappi.naytaVihje(vihje);
                        
                        logiikka.avaa(apuNappi.getKordinaattiX(), apuNappi.getKordinaattiY());
                        
                        if(vihje == 0)
                            avaaTyhjat(apuNappi.getKordinaattiX(), apuNappi.getKordinaattiY());
                    }
                }
            }
        }
    }
    /**
     * Peritty käyttämätön metodi
     * @param e 
     */
    public void mousePressed(MouseEvent e) {
    }
    /**
     * Peritty käyttämätön metodi
     * @param e 
     */
    public void mouseReleased(MouseEvent e) {
    }
    /**
     * Peritty käyttämätön metodi
     * @param e 
     */
    public void mouseEntered(MouseEvent e) {
    }
    /**
     * Peritty käyttämätön metodi
     * @param e 
     */
    public void mouseExited(MouseEvent e) {
    }
}
