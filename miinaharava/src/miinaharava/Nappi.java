package miinaharava;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
/**
 * Nappi luokka on luokan JButton aliluokka.
 * @author Marko
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
     */
    private void alkuRuutu() {
        setPreferredSize(new Dimension(25,25));
        setMinimumSize(new Dimension(25,25));
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createRaisedBevelBorder());
    }
    /**
     * Määrittelee miltä avattu ruutu näyttää.
     */
    public void naytaAvattu() {
        setBackground(Color.white);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.lightGray, Color.gray));
    }
    
    /**
     * Määrittelee miltä miinoitettu ruutu näyttää.
     */
    public void naytaMiina() {
        
    }
    /**
     * Määrittelee miltä ruutu näyttää kun sillä on vihjenumero.
     * @param vihjenumero 
     */
    public void naytaVihje(int vihjenumero) {
        
    }
    /**
     * Määrittelee miltä ruutu näyttää, kun sille asetetaan tai poistetaan lippu.
     * @param lippu 
     */
    public void naytaLippu(boolean lippu) {
        if(lippu) {
        }   setText("?");
        if(!lippu) {
            setText("");
        }
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
