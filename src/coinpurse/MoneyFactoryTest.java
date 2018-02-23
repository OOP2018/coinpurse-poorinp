package coinpurse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoneyFactoryTest {
	
	private static final double TOL = 1.0E-6;
	private static MoneyFactory instance;
	
	/**
     * Sets up the test fixture.
     * Called before every test method.
     */
    @Before
    public void setUp() {
    	// nothing to initialize
    }
    
    /**
     * test factory that are singleton
     */
    @Test
    public void testGetInstance()
    {
    	MoneyFactory factory = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
    	assertEquals(factory, factory2);
    }
    
    /**
     * test that two factory is not the same
     */
    @Test
    public void testSetInstance()
    {
    	MoneyFactory factory = MoneyFactory.getInstance();
    	MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory2 = MoneyFactory.getInstance();
    	assertNotEquals(factory, factory2);
    }
    
    /**
     * test that money factory can create money
     */
    @Test(timeout=1000)
    public void testCreateMoneyTrue()
    {   
    	MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney( 5 );
		assertEquals(5, m.getValue(), TOL);
		Valuable m2 = factory.createMoney("1000.0");
		assertEquals(1000, m2.getValue(), TOL);
		assertEquals("Baht", m2.getCurrency());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateMoneyArgument()
    {   
    	MoneyFactory factory = MoneyFactory.getInstance();
    	Valuable m3 = factory.createMoney(3);
		Valuable m4 = factory.createMoney("A");
		Valuable m = factory.createMoney( 5 );
		Valuable m2 = factory.createMoney("1000.0");
    }
}
