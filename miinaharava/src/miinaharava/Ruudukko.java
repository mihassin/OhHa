package miinaharava;

import java.util.Random;

public class Ruudukko {

    private int x;
    private int y;
    private int miinatLkm;
    private int vihjeNumero;
    private Ruutu[][] r;
    private Random random;

    public Ruudukko(int leveys, int korkeus, int miinat) {
        x = leveys;
        y = korkeus;
        miinatLkm = miinat;

        r = new Ruutu[x][y];
        
        random = new Random();
    }
    
    public void lisaaRuudutTauluun() {
        for(int i = 0; i < (x-1); i++) {
            for(int j = 0; j < (y-1); j++) {
                r[i][j] = new Ruutu();
            }
        }
    }

    public int getLeveys() {
        return x;
    }

    public int getKorkeus() {
        return y;
    }

    public int getMiinojenLukumaara() {
        return miinatLkm;
    }

    public Ruutu getRuutu(int sijaintiX, int sijaintiY) {
        return r[sijaintiX][sijaintiY];
    }

    public boolean onkoAuki(int sijaintiX, int sijaintiY) {
        return r[sijaintiX][sijaintiY].onkoAvattu();
    }

    public boolean onkoLippu(int sijaintiX, int sijaintiY) {
        return r[sijaintiX][sijaintiY].onkoLippu();
    }

    public boolean onkoMiina(int sijaintiX, int sijaintiY) {
        return r[sijaintiX][sijaintiY].onkoMiina();
    }

    public boolean asetaLippu(int sijaintiX, int sijaintiY) {

        if (r[sijaintiX][sijaintiY].onkoLippu() == false) {
            r[sijaintiX][sijaintiY].asetaLippu();
            return true;
        } else {
            return false;
        }
    }
//
//    public int avaa(int x, int y) {
//        if (!r[x][y].onkoAvattu()) {
//            r[x][y].asetaAvattu();
//
//            if (r[x][y].onkoMiina()) {
//                return -1;
//            } else {
//                return getVihjeNumero(x, y);
//            }
//        } else {
//            return getVihjeNumero(x, y);
//        }
//    }

    public void miinoitaRuudukko() {
        int miinojaJaljella = miinatLkm;

        while (miinojaJaljella > 0) {
            int a = random.nextInt(x);
            int b = random.nextInt(y);

            if (r[a][b].onkoMiina() == false) {
                r[a][b].asetaMiina();
                miinojaJaljella--;
            }
        }
    } 
    
//    public int getVihjeNumero(int x, int y) {//KESKEN
//        vihjeNumero = 0;
//        int tila = ruudunTila(x,y); 
//        if (tila == 1){
//            
//        }
//         return vihjeNumero;
//    }
//    
//    public int ruudunTila(int x, int y) {//KESKEN
//        int tila = 0;
//        if(x == 0 && y == 0)
//            tila = 1;
//        return tila;
//    }
//    
    public static void main(String[] args) {
        Ruudukko ruudukko = new Ruudukko(9, 9, 10);

        System.out.print("Ruudukko on kokoa " + ruudukko.getLeveys() + " * " + ruudukko.getKorkeus());
        System.out.println(" ja ruudukossa on " + ruudukko.getMiinojenLukumaara() + " miinaa");
        
        ruudukko.lisaaRuudutTauluun();
        System.out.println(ruudukko.getRuutu(1, 1));
        boolean b = ruudukko.onkoAuki(1, 1);
        System.out.println(b);
    }
}