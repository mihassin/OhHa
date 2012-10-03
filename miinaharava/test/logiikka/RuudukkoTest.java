package logiikka;

import static org.junit.Assert.*;
import org.junit.*;

public class RuudukkoTest {
    
    public RuudukkoTest() {
    }
    
    Ruudukko r;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        r = new Ruudukko(10, 15, 5);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void leveysOikein() {
        assertEquals(r.getLeveys(), 10);
    }
    
    @Test
    public void korkeusOikein(){
        assertEquals(r.getKorkeus(), 15);
    }

    @Test
    public void alussaEiOleAuki() {
        assertFalse(r.onkoAuki(1, 2));
    }
    
    @Test
    public void alussaEiOleLippua() {
        assertFalse(r.onkoLippu(1, 2));
    }

    @Test
    public void lipunAsettaminen() {
        r.asetaLippu(1, 2, true);
        assertTrue(r.onkoLippu(1, 2));
    }
    
    @Test
    public void lipunPoistaminen() {
        r.asetaLippu(1, 2, false);
        assertFalse(r.onkoLippu(1, 2));
    }
    
    @Test
    public void lipunAsetuksenJalkeenPoisto() {
        r.asetaLippu(1, 2, true);
        assertTrue(r.onkoLippu(1, 2));
        //POISTO
        r.asetaLippu(1, 2, false);
        assertFalse(r.onkoLippu(1, 2));
    }
    
    @Test
    public void miinoittaminen() {
        Ruudukko e = new Ruudukko(3,3,9); //UUSI RUUDUKKO,
        assertTrue(e.onkoMiina(1, 1));    //JOSSA JOKA RUUDUSSA ON MIINA
    }
    
    @Test
    public void avaaRuutu() {
        r.avaa(1, 2);
        assertTrue(r.onkoAuki(1, 2));
    }
    
    @Test
    public void uusiPeliEiLippuja() {
        r.uusiPeli();
        assertFalse(r.onkoLippu(1, 1));
    }
    
    @Test
    public void uusiPeliEiAvattu() {
        r.uusiPeli();
        assertFalse(r.onkoAuki(1, 1));
    }
}
