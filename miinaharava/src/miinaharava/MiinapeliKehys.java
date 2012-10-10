package miinaharava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * MiinapeliKehys on JFrame luokan aliluokka. MiinapeliKehys määrittelee
 * miinaharavan graaffisen käyttöliittymän.
 *
 * @author Marko Hassinen
 */
public class MiinapeliKehys extends JFrame {

    private OmaPaneeli panel;
    private JLabel alaPaneeli;
    private JMenuBar statusbar;
    private JMenu peliValikko;
    private JMenuItem uusiPeli;
    private JMenuItem sulje;
    private JSeparator viivaErottaja;

    /**
     * Konstruktori suorittaa alkumetodeja.
     *
     * @param x
     * @param y
     * @param miinat
     */
    public MiinapeliKehys(int x, int y, int miinat) {
        luoKehysMuuttujineen();
        paneelinToiminta(x, y, miinat);
        alapaneelinToiminta();
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

        panel = new OmaPaneeli();
        alaPaneeli = new JLabel("Aloita painamalla ruutua.");
        statusbar = new JMenuBar();
        peliValikko = new JMenu();
        uusiPeli = new JMenuItem();
        sulje = new JMenuItem();
        viivaErottaja = new JSeparator();
    }

    /**
     * Metodi määrittelee paneelin koon ja miinojen määrän
     *
     * @param x
     * @param y
     * @param miinat
     */
    private void paneelinToiminta(int x, int y, int miinat) {
        panel.setPreferredSize(new Dimension((25 * x), (25 * y)));
        panel.luoPeli(x, y, miinat);
    }

    /**
     * Metodi määrittelee käyttöliittymän alapaneelin
     */
    private void alapaneelinToiminta() {
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
        uusiPeli.addActionListener(new ActionListener() {

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
     *
     * @param evt
     */
    private void uusiPeliActionPerformed(ActionEvent evt) {
        panel.uusiPeli();
        alaPaneeli.setText("Aloitit uuden pelin!");
    }

    /**
     * Määrittelee valikon sulje kohdan toimintaa.
     *
     * @param evt
     */
    private void suljeActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    /**
     * Metodi mitä kutsutaan erillisessä luokassa GUI. GUI huolehtii ohjelman
     * toiminnasta.
     *
     * @param x
     * @param y
     * @param miinat
     */
    public void guiInit(int x, int y, int miinat) {
        MiinapeliKehys gui = new MiinapeliKehys(x, y, miinat);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        gui.pack();
    }
}
