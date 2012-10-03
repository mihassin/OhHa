package miinaharava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * MiinapeliKehys on JFrame luokan aliluokka.
 * MiinapeliKehys määrittelee miinaharavan graaffisen käyttöliittymän.
 * @author Marko
 */
public class MiinapeliKehys extends JFrame{
   
    private OmaPaneeli panel;
    private JLabel alaPaneeli;
    private JMenuBar statusbar;
    private JMenu peliValikko;
    private JMenuItem uusiPeli;
    private JMenuItem sulje;
    private JSeparator viivaErottaja;
    /**
     * Konstruktori suorittaa alkumetodeja.
     */
    public MiinapeliKehys() {
            luoKehysMuuttujineen();
            paneelinJaAlapaneelinToiminta();
            valkonToiminta();
            lisaaKehykseenOliot();  
    }
    /**
     * Metodi luo oliot ja asettaa otsikon ikkunalle.
     */
    private void luoKehysMuuttujineen() {
        setTitle("Miinaharava");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // LUO OMA PANEELI HALUTULLA MÄÄRÄLLÄ RUUTUJA
        panel = new OmaPaneeli();
        alaPaneeli = new JLabel("Tervetuloa pelaamaan");
        statusbar = new JMenuBar();
        peliValikko = new JMenu();
        uusiPeli = new JMenuItem();
        sulje = new JMenuItem();
        viivaErottaja = new JSeparator();
    }
    /**
     * Metodi määrittelee käyttöliittymän alapaneelin
     */
    private void paneelinJaAlapaneelinToiminta() {
        panel.setPreferredSize(new Dimension((25*30),(25*16))); // siiretään erilliseen vaikeustaso metodiin
        panel.luoPeli(30,16,99);                              // myös tämä
        alaPaneeli.setBackground(Color.white);
        alaPaneeli.setOpaque(true);
        alaPaneeli.setBorder(BorderFactory.createLineBorder(Color.white));
    }
    /**
     * Metodi määrittelee valikon oliot ja itse valikko olion.
     */
    private void valkonToiminta() {
        peliValikko.setText("Peli");
        
        uusiPeli.setText("Uusi peli");
        uusiPeli.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent evt) {
               uusiPeliActionPerformed(evt);
           } 
        });
        
        sulje.setText("Sulje");
        sulje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                suljeActionPerformed(evt);
            }
        });
    }
    /**
     * Metodi lisää kaikki luodut oliot MiinapeliKehykseen.
     */
    private void lisaaKehykseenOliot() {
        add(panel, BorderLayout.CENTER);
        add(alaPaneeli, BorderLayout.SOUTH);
        add(statusbar, BorderLayout.NORTH);
        statusbar.add(peliValikko);
        peliValikko.add(uusiPeli);
        peliValikko.add(viivaErottaja);
        peliValikko.add(sulje); 
    }
    /**
     * Määrittelee valikon uusipeli kohdan toimintaa.
     * @param evt 
     */
    private void uusiPeliActionPerformed(ActionEvent evt) {
        panel.uusiPeli();
        alaPaneeli.setText("We went f2p");
    }
    /**
     * Määrittelee valikon sulje kohdan toimintaa.
     * @param evt 
     */
    private void suljeActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
    /**
     * Metodi mitä kutsutaan erillisessä luokassa GUI.
     * GUI huolehtii ohjelman toiminnasta.
     */
    public void guiInit() {
       MiinapeliKehys gui = new MiinapeliKehys();
       gui.setVisible(true);
       gui.setLocationRelativeTo(null);
       gui.pack();
    }
}
