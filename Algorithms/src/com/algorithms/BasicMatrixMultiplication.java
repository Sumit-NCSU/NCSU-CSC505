package com.algorithms;

/**
 * 1. First Algorithmm: Basic Matrix Multiplication O(n<sup>3</sup>)
 * 
 * @author Sumit
 *
 */
public class BasicMatrixMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicMatrixMultiplication bmm = new BasicMatrixMultiplication();
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// bmm.printMatrix(a);
		int[][] b = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
		// bmm.printMatrix(b);
		System.out.println("Result:");
		bmm.printMatrix(bmm.multiplyMatrix(a, b));
	}

	/**
	 * Method to multiple two matrices a<sub>m x n</sub> and b<sub>n x k</sub>
	 * and return their products. The order of the two matrices must be
	 * compatible.
	 * 
	 * @param a
	 *            the first matrix
	 * @param b
	 *            the second matrix
	 * @return the product of the two matrices
	 */
	private int[][] multiplyMatrix(int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			System.out.println("Given Matrices cannot be multiplied.");
			return null;
		} else {
			int[][] c = new int[a.length][b[0].length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					for (int k = 0; k < a.length; k++) {
						c[i][j] += a[i][k] * b[k][j];
					}
				}
			}
			return c;
		}
	}

	/**
	 * Helper method to print the matrix.
	 * 
	 * @param a
	 *            the matrix to be printed.
	 */
	private void printMatrix(int[][] a) {
		if (null != a) {
			System.out.print("\t");
			for (int i = 0; i < a[0].length; i++) {
				System.out.print("[" + (i + 1) + "]\t");
			}
			System.out.println("");
			for (int i = 0; i < a.length; i++) {
				System.out.print("[" + (i + 1) + "]\t");
				for (int j = 0; j < a[0].length; j++) {
					System.out.print(a[i][j] + "\t");
				}
				System.out.println("");
			}
		}
	}

}
