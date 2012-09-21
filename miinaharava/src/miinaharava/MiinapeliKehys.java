package miinaharava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiinapeliKehys extends JFrame{
   
    private JPanel panel;
    private JLabel alaPaneeli;
    private JMenuBar statusbar;
    private JMenu peliValikko;
    private JMenuItem uusiPeli;
    private JMenuItem sulje;
    private JSeparator viivaErottaja;
    
    public MiinapeliKehys() {
        luoKehysMuuttujineen();
        paneelinJaAlapaneelinToiminta();
        valkonToiminta();
        lisaaKehykseenOliot();  
    }

    private void luoKehysMuuttujineen() {
        setTitle("Miinaharava");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // LUO OMA PANEELI HALUTULLA MÄÄRÄLLÄ RUUTUJA
        panel = new OmaPaneeli(16,16); 
        alaPaneeli = new JLabel("Mahdollisia tilastoja/pisteitä");
        statusbar = new JMenuBar();
        peliValikko = new JMenu();
        uusiPeli = new JMenuItem();
        sulje = new JMenuItem();
        viivaErottaja = new JSeparator();
    }

    private void paneelinJaAlapaneelinToiminta() {
        //panel.setPreferredSize(new Dimension(400,300));
        alaPaneeli.setBackground(Color.white);
        alaPaneeli.setOpaque(true);
        alaPaneeli.setBorder(BorderFactory.createLineBorder(Color.white));
    }
 
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
    
    private void lisaaKehykseenOliot() {
        add(panel, BorderLayout.CENTER);
        add(alaPaneeli, BorderLayout.SOUTH);
        add(statusbar, BorderLayout.NORTH);
        statusbar.add(peliValikko);
        peliValikko.add(uusiPeli);
        peliValikko.add(viivaErottaja);
        peliValikko.add(sulje); 
    }
    
    private void uusiPeliActionPerformed(ActionEvent evt) {
        alaPaneeli.setText("Vain maksullisessa versiossa!");
    }
    
    private void suljeActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
    
    public static void main(String[] args) {
       MiinapeliKehys gui = new MiinapeliKehys();
       gui.setVisible(true);
       gui.setLocationRelativeTo(null);
       gui.pack();
    }
}
