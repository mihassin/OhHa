package miinaharava;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JButton;

public class OmaPaneeli extends JPanel implements MouseListener {
    private GridBagLayout g;
    private GridBagConstraints c;
    private JButton nappi;
    private int x;
    private int y;
    private JButton[][] ruudukko;

    public OmaPaneeli(int leveys, int korkeus) {
        g = new GridBagLayout();
        c = new GridBagConstraints();
        setLayout(g);
        
        x = leveys;
        y = korkeus;
        
        ruudukko = new JButton[x][y];

        ruudukonLuonti();
    }

    private void ruudukonLuonti() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                nappi = new JButton();
                nappi.setPreferredSize(new Dimension(25, 25));
                
                ruudukko[i][j] = nappi;
                nappi.addMouseListener(this);

                c.fill = GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = j;
                add(nappi, c);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            nappi = ruudukko[0][0];
            nappi.setBackground(Color.BLUE);
        }
        
        if (e.getButton() == 3) {
            nappi = ruudukko[0][0];
            nappi.setBackground(Color.GREEN);
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
