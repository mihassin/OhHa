package logiikka;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

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
        assertFalse(r.onkoMiina());
    }
    
    @Test
    public void alussaEiSaaOllaLippua() {
        assertFalse(r.onkoLippu());
    }
    
    @Test
    public void alussaEiSaaOllaAvattu() { 
        assertFalse(r.onkoAvattu());
    }
    
    @Test
    public void miinoita() { 
        r.asetaMiina(true);
        assertTrue(r.onkoMiina());
    }
    
    @Test
    public void poistaMiina() {
        r.asetaMiina(false);
        assertFalse(r.onkoMiina());
    }
    
    @Test
    public void miinoituksenJalkeenPoistaMiina() {
        r.asetaMiina(true);
        r.asetaMiina(false);
        assertFalse(r.onkoMiina());
    }
    
    @Test
    public void liputa() { 
        r.asetaLippu(true);
        assertTrue(r.onkoLippu());
    }
    
    @Test
    public void poistaLippu() {
        r.asetaLippu(false);
        assertFalse(r.onkoLippu());
    }
    
    @Test
    public void liputuksenJalkeenLipunPoisto() {
        r.asetaLippu(true);
        r.asetaLippu(false);
        assertFalse(r.onkoLippu());
    }
    
    @Test
    public void avaaRuutu() { 
        r.asetaAvattu(true);
        assertTrue(r.onkoAvattu());
    }
    
    @Test
    public void suljeRuutu() {
        r.asetaAvattu(false);
        assertFalse(r.onkoAvattu());
    }
    
    @Test
    public void avaaRuutuSittenSulje() {
        r.asetaAvattu(true);
        r.asetaAvattu(false);
        assertFalse(r.onkoAvattu());
    }
}
