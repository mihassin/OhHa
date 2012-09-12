package miinaharava;

import java.awt.*;
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
        
        setTitle("Miinaharava");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,300));
        add(panel, BorderLayout.CENTER);
        
        alaPaneeli = new JLabel("Mahdollisia tilastoja/pisteitä");
        alaPaneeli.setBackground(Color.white);
        alaPaneeli.setOpaque(true);
        alaPaneeli.setBorder(BorderFactory.createLineBorder(Color.white));
        add(alaPaneeli, BorderLayout.SOUTH);
        
        statusbar = new JMenuBar();
        peliValikko = new JMenu();
        uusiPeli = new JMenuItem();
        sulje = new JMenuItem();
        viivaErottaja = new JSeparator();
        
        peliValikko.setText("Peli");
        uusiPeli.setText("Uusi peli");
        sulje.setText("Sulje");
        
        uusiPeli.addActionListener(new java.awt.event.ActionListener(){
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               uusiPeliActionPerformed(evt);
           } 
        });
        
        sulje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suljeActionPerformed(evt);
            }
        });
        
        statusbar.add(peliValikko);
        peliValikko.add(uusiPeli);
        peliValikko.add(viivaErottaja);
        peliValikko.add(sulje);
        
        add(statusbar, BorderLayout.NORTH);
    }
    
    private void uusiPeliActionPerformed(java.awt.event.ActionEvent evt) {
        alaPaneeli.setText("Vain maksullisessa versiossa!");
    }
    
    private void suljeActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    public static void main(String[] args) {
       MiinapeliKehys gui = new MiinapeliKehys();
       gui.setVisible(true);
       gui.setLocationRelativeTo(null);
       gui.pack();
    }
}
