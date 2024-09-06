package com.junit2.junit2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.model.PromoCodes;

/*
import com.example.model.PromoCodes;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
*/

/*
public class AppTest 
    extends TestCase
{
	
	PromoCodes promoCodes;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
/*
    public AppTest( String testName )
    {
        super( testName );
    }


    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testPromoCode() {
    	assertEquals(true, true);
    }
}*/

public class AppTest{
	PromoCodes promoCodes = new PromoCodes();
	
	@Test
	public void testPromoCodes() {
		assertEquals(true, promoCodes.checkPromoCode("bingo"));
	}
	
	@Test
	public void testDiscount() {
		String pCode = "JUMBO";
		double expectedDiscount = 0.4;
		assertEquals(expectedDiscount, promoCodes.getDiscount(pCode));
	}
	
	@Test
	public void testAmountDiscount() {
		String pCode = "trynew";
		double amount = 1000;
		double expectedAmount = 950.0;
		
		assertEquals(expectedAmount, promoCodes.getAmountAfterDiscount(pCode, amount));
	}
	
	@Test
	public void testAmountDiscountTaxes() {
		String pCode = "SUNDAY";
		double amount = 1000;
		double expectedAmount = 885.0;
		
		assertEquals(expectedAmount,promoCodes.getAfterDiscountWithTaxes(pCode, amount));
	}
	
	@Test
	public void groupTest() {
		assertAll("Promo Code Discount as 0.40",
				()->assertEquals(0.2, promoCodes.getDiscount("BINGO")),
				()->assertEquals(0.9, promoCodes.getDiscount("TRYNEW90"))
				);
	}
	
	@Test
	public void luckyNumberException() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, 
				()-> promoCodes.luckyPromoCode(7)
				);
		
		System.out.println("message: " + exception.getMessage());
		
		assertEquals("Index 7 out of bounds for length 5", exception.getMessage());
	}
}
