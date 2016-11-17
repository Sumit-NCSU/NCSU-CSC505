package com.hw;

public class Q1 {

	public static void main(String[] args) {
		System.out.println(bar(8, 33));
	}

	private static int bar(int x, int n) {
		int sum = 0;
		if (x > 10) {
			for (int i = 1; i <= (n * n); i++) {
				System.out.println("I ran " + i + " times.");
				sum = sum * i;
			}
		} else {
			for (int i = 1; i <= n; i++) {
				System.out.println("I ran " + i + " times.");
				sum = sum + i;
			}
		}
		return x + sum;
	}
}
