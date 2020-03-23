package com.sapient.rest.util;


public class CommonValidator {

	public static void main(String[] args) {
		validateLuhn10("79927398713");
	}
	
	public static boolean validateLuhn10(String ccNumber) {
		if (ccNumber == null || ccNumber.trim().isEmpty()) {
			return false;
		}
		
		int toogle = 0;
		int sum = 0;
		
		for (int i = ccNumber.length() - 1; i >= 0; i--) {
			if (toogle == 0) {
				sum = sum + Integer.parseInt(String.valueOf(ccNumber.charAt(i)));
				toogle = 1;
			} else {
				int temp = Integer.parseInt(String.valueOf(ccNumber.charAt(i))) * 2;
				sum = sum + Integer.parseInt(String.valueOf(Integer.toString(temp).charAt(0)));
				if (Integer.toString(temp).length() > 1) {
					sum = sum + Integer.parseInt(String.valueOf(Integer.toString(temp).charAt(1)));
				}
				toogle = 0;
			}
		}
		
		System.out.println(sum);
		
		return sum % 10 == 0;
	}
}
