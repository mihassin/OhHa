
package miinaharava;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {
    
    public RuutuTest() {
    }
    
    Ruutu r;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        r = new Ruutu();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alussaEiSaaOllaMiinoitettu() {
        boolean eiMiinaa = r.onkoMiina();
        assertFalse(eiMiinaa);
    }
    
    @Test
    public void alussaEiSaaOllaLippua() {
        boolean eiLippua = r.onkoLippu();
        assertFalse(eiLippua);
    }
    
    @Test
    public void alussaEiSaaOllaAvattu() { 
        boolean eiAvattu = r.onkoAvattu();
        assertFalse(eiAvattu);
    }
    
    @Test
    public void miinoita() { 
        r.asetaMiina();
        boolean pitaaOllaMiina = r.onkoMiina();
        assertTrue(pitaaOllaMiina);
    }
    
    @Test
    public void liputa() { 
        r.asetaLippu();
        boolean pitaaOllaLippu = r.onkoLippu();
        assertTrue(pitaaOllaLippu);
    }
    
    @Test
    public void avaaRuutu() { 
        r.asetaAvattu();
        boolean pitaaOllaAvattu = r.onkoAvattu();
        assertTrue(pitaaOllaAvattu);
    }
}
