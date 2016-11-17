package com.practice;

public class MakeChangeClass {

	int denominationsUS[] = { 50, 25, 10, 5, 1 };
	int denominationsNonUS[] = { 10, 6, 1 };

	public static void main(String[] args) {
		MakeChangeClass mkc = new MakeChangeClass();
		int amount = 12;
		System.out.println("Number of coins: " + mkc.makeChange(amount));
//		System.out.println("Number of coins: " + mkc.numCoinsReturned(amount));
	}

	public int makeChange(int n) {
		int count = 0;
		for (int i : denominationsNonUS) {
			if (n >= i) {
				System.out.println(i);
				count += makeChange(n - i);
				return ++count;
			}
		}
		return count;
	}

	public int numCoinsReturned(int n) {
		int count = 0;
		count += n/50;
		n = n%50;
		count += n/25;
		n = n%25;
		count += n/10;
		n = n%10;
		count += n/5;
		n = n%5;
		count += n;
		return count;
	}

}
