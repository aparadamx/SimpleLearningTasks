package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class PromoCodes {
	List<String> promoCodes;
	TreeMap<String, Double> promoCodesWithDiscounts;
	
	public PromoCodes() {
		promoCodes = Arrays.asList("JUMBO","BINGO","HAPPY50","TRYNEW90","SUNDAY");
		promoCodesWithDiscounts = new TreeMap<String, Double>();
		promoCodesWithDiscounts.put(promoCodes.get(0), 0.40);
		promoCodesWithDiscounts.put(promoCodes.get(1), 0.20);
		promoCodesWithDiscounts.put(promoCodes.get(2), 0.50);
		promoCodesWithDiscounts.put(promoCodes.get(3), 0.90);
		promoCodesWithDiscounts.put(promoCodes.get(4), 0.25);
	}
	
	public Double getDiscount(String promoCode) {
		return promoCodesWithDiscounts.containsKey(promoCode) ? promoCodesWithDiscounts.get(promoCode) : 0.05;
	} 
	
	public Double getAmountAfterDiscount(String promoCode, double amount) {
		return promoCodesWithDiscounts.containsKey(promoCode) ? (amount - amount*promoCodesWithDiscounts.get(promoCode)) : (amount -amount*0.05);
	}
	
	public Double getAfterDiscountWithTaxes(String promoCode, double amount) {
		double amountAfterDiscount = getAmountAfterDiscount(promoCode, amount);
		return (amountAfterDiscount + (0.18*amountAfterDiscount));
	}
	
	public boolean checkPromoCode(String promoCode) {
		return promoCodes.contains(promoCode.toUpperCase());
	}
	
	public String luckyPromoCode(int luckyNumber) {
		return promoCodes.get(luckyNumber);
	}
}
