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
    /**
     * Metodi määrittelee oikean ja vasemman hiiren painikkeen toiminnallisuutta.
     * @param e 
     */
    public void mouseClicked(MouseEvent e) {
        nappi = (Nappi) e.getSource();

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!logiikka.onkoAuki(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
                if (!logiikka.onkoLippu(nappi.getKordinaattiX(), nappi.getKordinaattiY())) {
                    nappi.naytaAvattu();
                    logiikka.avaa(nappi.getKordinaattiX(), nappi.getKordinaattiY());
                }
            }
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
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
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
