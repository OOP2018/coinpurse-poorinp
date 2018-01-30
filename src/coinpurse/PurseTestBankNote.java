package coinpurse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PurseTestBankNote {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "BTC";
	
    /**
     * Sets up the test fixture.
     * Called before every test method.
     */
    @Before
    public void setUp() {
    	// nothing to initialize
    }
    
    /** Make a BankNote with the default currency. To save typing "new BankNote(...)" */
    private Valuable makeBankNote(double value) {
		return new BankNote(value,CURRENCY);
	}

    /** Easy test that the Purse constructor is working. */
    @Test
    public void testConstructor()
    {
        Purse purse = new Purse(3);
        assertEquals(3, purse.getCapacity());
        assertEquals(false, purse.isFull());
        assertEquals(0, purse.count());
    }

    

    /** Insert some coins. Easy test. */
    @Test
    public void testInsert()
    {
        Purse purse = new Purse(3);
        Valuable bank1 = makeBankNote(5);
        Valuable bank2 = makeBankNote(10);
        Valuable bank3 = makeBankNote(1);
        assertTrue( purse.insert(bank1));
        assertTrue( purse.insert(bank3));
        assertTrue( purse.insert(bank2));
        assertEquals( 3, purse.count() );
        // purse is full so insert should fail
        assertFalse( purse.insert(makeBankNote(1)) );
    }


	/** Insert should reject coin with no value. */
    @Test
    public void testInsertNoValue()
    {
        Purse purse = new Purse(3);
        Valuable fakeBank = new BankNote(0, CURRENCY);
        assertFalse( purse.insert(fakeBank) );
    }


    @Test(timeout=1000)
    public void testIsFull()
    {   // borderline case (capacity 1)
        Purse purse = new Purse(1);
        assertFalse( purse.isFull() );
        purse.insert( makeBankNote(1) );
        assertTrue( purse.isFull() );
        // real test
        int capacity = 4;
        purse = new Purse(capacity);
        for(int k=1; k<=capacity; k++) {
            assertFalse(purse.isFull());
            purse.insert( makeBankNote(k) );
        }
        // should be full now
        assertTrue( purse.isFull() );
        assertFalse( purse.insert( makeBankNote(5) ) );
    }

	/** Should be able to insert same coin many times,
	 *  since spec doesn't say anything about this.
	 */
	@Test(timeout=1000)
	public void testInsertSameCoin()
	{
		int capacity = 5;
		double value = 10.0;
		Purse purse = new Purse(capacity);
		Valuable bank = new BankNote(value, "THB");
		assertTrue( purse.insert(bank) );
		assertTrue( purse.insert(bank) ); // should be allowed
		assertTrue( purse.insert(bank) ); // should be allowed
		assertTrue( purse.insert(bank) ); // should be allowed
		assertTrue( purse.insert(bank) ); // should be allowed
		assertEquals( purse.getBalance(), 5*value, TOL);
	}

	/** Add one coin and remove it. */
	@Test(timeout=1000)
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		double [] values = {1, 20, 0.5, 10}; // values of coins we will insert
		
		for(double value : values) {
			Valuable bank = makeBankNote(value);
			assertTrue(purse.insert(bank));
			assertEquals(value,  purse.getBalance(), TOL);
			Valuable[] result = purse.withdraw(value);
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  bank, result[0] ); // should be same object
			assertEquals( 0, purse.getBalance(), TOL );
		}
	}
	

	/** Add 4 coins and then withdraw in pairs, but not in same order. */
	@Test(timeout=1000)
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		Valuable[] money = { makeBankNote(5.0), makeBankNote(10.0), makeBankNote(1.0), makeBankNote(5.0) };
		// insert them all
		for(Valuable bank: money) assertTrue( purse.insert(bank) );
		
		double amount1 = money[1].getValue() + money[3].getValue();
		double amount2 = money[0].getValue() + money[2].getValue();
		assertEquals(amount1+amount2, purse.getBalance(), TOL );
		
		Valuable [] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sum(wd1), TOL );
		
		assertEquals(amount2, purse.getBalance(), TOL );
		Valuable [] wd2 = purse.withdraw(amount2);
		
		// should be empty now
		assertEquals(0, purse.getBalance(), TOL );
	}
	

	/** Withdraw full amount in purse, using varying numbers of objects. */
	@Test(timeout=1000)
	public void testWithdrawEverything() {
		Purse purse = new Purse(10);
		// Coins we want to insert and then withdraw.
		// Use values such that greedy will succeed, but not monotonic
		List<Valuable> bank = Arrays.asList(
				makeBankNote(1.0), makeBankNote(0.5), makeBankNote(10.0), makeBankNote(0.25), makeBankNote(5.0)
				);
		// num = number of coins to insert and then withdraw
		for(int num=1; num <= bank.size(); num++) {
			double amount = 0.0;
			List<Valuable> subList = bank.subList(0, num);
			for(Valuable c: subList) {
				purse.insert(c);
				amount += c.getValue();
			}
			// balance should be exactly what we just inserted
			assertEquals( amount, purse.getBalance(), TOL);
			// can we withdraw it all?
			Valuable[] result = purse.withdraw(amount);
			String errmsg = String.format("couldn't withdraw %.2f but purse has %s",
					amount, Arrays.toString(subList.toArray()) );
			assertNotNull( errmsg, result );
			// is the amount correct?
			assertEquals("Withdraw wrong amount", amount, sum(result), TOL);
			// should not be anything left in the purse
			assertEquals( 0.0, purse.getBalance(), TOL);
		}
	}


	@Test(timeout=1000)
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull( purse.withdraw(1) );
		purse.insert( makeBankNote(20) );
		assertNull( purse.withdraw(1) );
		assertNull( purse.withdraw(19) );
		assertNull( purse.withdraw(21) );
		purse.insert( makeBankNote(20) ); // now it has 20 + 20
		assertNull( purse.withdraw(30) );
	}
	
	/**
	 * Sum the value of some coins.
	 * @param coins array of coins
	 * @return sum of values of the coins
	 */
	private double sum(Valuable[] bank)  {
		if (bank == null) return 0.0;
		double sum = 0;
		for(Valuable c: bank) if (c != null) sum += c.getValue();
		return sum;
	}
}
