package miinaharava;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
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
    private Nappi[][] ruudukko;
    private Ruudukko logiikka;
    /**
     * OmaPaneeli luokka yhdistää logiikan ja graafisen käyttöliittymän.
     * OmaPaneeli luokam konstruktori määrittelee Ruudukko luokan leveyden, korkeuden ja miinojen lukumäärän.
     * @param leveys
     * @param korkeus
     * @param miinat 
     */
    public OmaPaneeli(int leveys, int korkeus, int miinat) {
        g = new GridBagLayout();
        c = new GridBagConstraints();
        setLayout(g);

        x = leveys;
        y = korkeus;

        logiikka = new Ruudukko(x, y, miinat);
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
    
//    public void uusiPeli() {
//        ruudukonLuonti();
//        logiikka.uusiPeli();
//    }
    /**
     * Metodi määrittelee oikean ja vasemman hiiren painikkeen toiminnallisuutta.
     * @param e 
     */
    public void mouseClicked(MouseEvent e) {
        nappi = (Nappi) e.getSource();

        if (e.getButton() == MouseEvent.BUTTON1) {
            vasenHiiri();
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            oikeaHiiri();
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
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
                if(logiikka.onkoMiina(nappi.getKordinaattiX(), nappi.getKordinaattiY()))
                    nappi.naytaMiina();
                
                else {
                    vihje = logiikka.getVihjeNumero(nappi.getKordinaattiX(), nappi.getKordinaattiY());
//                    
//                    if(vihje == 0)
//                        avaaTyhjatRuudut(nappi.getKordinaattiX(), nappi.getKordinaattiY());
                    
                    nappi.naytaVihje(vihje);
                }
//                logiikka.avaaTyhjatRuudutRuudukossa(nappi.getKordinaattiX(), nappi.getKordinaattiY());
                logiikka.avaa(nappi.getKordinaattiX(), nappi.getKordinaattiY());
            }
        }
    }
    
//    private void avaaTyhjatRuudut(int kordinaattiX, int kordinaattiY) {
//        for(int i = kordinaattiX-1; i < kordinaattiX+2; i++) {
//                for(int j = kordinaattiY-1; j < kordinaattiY+2; j++) {
//                    if((i>=0 && i<x) && (j>=0 && j<y)) {
//                    
//                        int apuvihje = logiikka.getVihjeNumero(i , j);
//                        if((!(i==kordinaattiX && j==kordinaattiY)) && apuvihje == 0) {
//                            nappi.naytaVihje(apuvihje);
//                    }
//                }   
//            }       
//        }
//    }
}
