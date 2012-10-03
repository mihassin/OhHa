package miinaharava;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
/**
 * Nappi luokka on luokan JButton aliluokka.
 * @author Marko Hassinen
 */
public class Nappi extends JButton {
    
    private int x;
    private int y;
    /**
     * Nappi luokka on tietoinen omasta sijainnistaan ruudukossa.
     * @param sijaintiX
     * @param sijaintiY 
     */
    public Nappi(int sijaintiX, int sijaintiY) {
        x = sijaintiX;
        y = sijaintiY;
        
        alkuRuutu();
    }
    /**
     * Luo suljetun ruudun. Jokainen ruutu on aluksi suljettu.
     * Alkuruudun pitää olla julkinen, koska uusiPeli - metodi tarvitsee sitä
     * OmaPaneeli luokassa.
     */
    public void alkuRuutu() {
        setPreferredSize(new Dimension(25,25));
        setMinimumSize(new Dimension(25,25));
        setText("");
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createRaisedBevelBorder());
    }
    /**
     * Määrittelee miltä avattu ruutu näyttää.
     */
    private void naytaAvattu() {
        setBackground(Color.white);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.lightGray, Color.gray));
    }  
    /**
     * Määrittelee miltä miinoitettu ruutu näyttää.
     */
    public void naytaMiina() {
        naytaAvattu();
        setText("X");
        setForeground(Color.black);
    }    
    /**
     * Määrittelee miltä ruutu näyttää, kun sille asetetaan tai poistetaan lippu.
     * @param lippu 
     */
    public void naytaLippu(boolean lippu) {
        if(lippu) {
            setText("?");
            setForeground(Color.black);
        }
        if(!lippu) {
            setText("");
            setForeground(Color.black);
        }
    }  
    /**
     * Määrittelee miltä ruutu näyttää kun sillä on vihjenumero.
     * @param vihjenumero 
     */
    public void naytaVihje(int vihjenumero) {
        naytaAvattu();
        Color oikea = asetaOikeaFontti(vihjenumero);
        if(vihjenumero > 0) {
            String vihje = "" + vihjenumero;
            setText(vihje);
            setForeground(oikea);
        }
    }
    /**
     * Valitsee oikean värin vihjenumerolle
     * @param vihjenumero
     * @return 
     */
    private Color asetaOikeaFontti(int vihjenumero) {
        if(vihjenumero == 1) {
            return Color.blue;
        }
        if(vihjenumero == 2) {
            return Color.green;
        }
        if(vihjenumero == 3) {
            return Color.red;
        }
        if(vihjenumero == 4) {
            return Color.pink;
        }
        if(vihjenumero == 5) {
            return Color.magenta;
        }
        if(vihjenumero == 6) {
            return Color.cyan;
        }
        if(vihjenumero == 7) {
            return Color.yellow;
        }
        if(vihjenumero == 8) {
            return Color.black;
        }
        else
            return null;
    }
    /**
     * Palauttaa napin x-kordinaatin OmaPaneelissa.
     * @return 
     */
    public int getKordinaattiX() {
        return x;
    }
    /**
     * Palauttaa napin y-kordinaatin OmaPaneelissa
     * @return 
     */
    public int getKordinaattiY() {
        return y;
    }
}
