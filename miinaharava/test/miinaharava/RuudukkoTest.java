package miinaharava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuudukkoTest {
    
    public RuudukkoTest() {
    }
    
    Ruudukko r;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        r = new Ruudukko(10,15,5);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void leveysOikein() {
        int leveys = r.getLeveys();
        assertEquals(leveys, 10);
    }
    
    @Test
    public void korkeusOikein(){
        int korkeus = r.getKorkeus();
        assertEquals(korkeus, 15);
    }
}
