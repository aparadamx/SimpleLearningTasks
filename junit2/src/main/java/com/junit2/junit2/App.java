package com.junit2.junit2;

import com.example.model.PromoCodes;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "JUNIT5" );
        PromoCodes pRef = new PromoCodes();
        System.out.println(pRef.getDiscount("jumbo"));
        System.out.println(pRef.getAmountAfterDiscount("trynew", 1000));
        System.out.println(pRef.getAfterDiscountWithTaxes("sunday", 1000));
    }
}
