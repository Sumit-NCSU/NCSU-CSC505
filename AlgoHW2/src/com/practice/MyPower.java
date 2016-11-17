package com.practice;

public class MyPower {

	public static void main(String[] args) {
		MyPower mp = new MyPower();
		System.out.println(mp.power(2, 0));
		System.out.println(mp.power(2, 1));
		System.out.println(mp.power(2, 2));
		System.out.println(mp.power(2, 3));
		System.out.println(mp.power(2, 4));
		System.out.println(mp.power(2, 5));
	}

	private long power(int a, int n) {
		long value = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				value *= a;
				n = n - 1;
			} else {
				a *= a;
				n = n/2;
			}
		}
		return value;
	}

}