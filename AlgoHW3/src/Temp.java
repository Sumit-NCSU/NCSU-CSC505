
public class Temp {

	private static int recursiveCalls = 0;
	private static int scalarMultiplications = 0;
	private static final int INFINITY = 999999;

	public static void main(String[] args) {
		int[][] inputs = { { 5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5 } };
		executeAndPrint(inputs);
	}

	private static void executeAndPrint(int[][] inputs) {
		for (int[] d : inputs) {
			long a = System.currentTimeMillis();
			recursiveCalls = 0;
			scalarMultiplications = 0;
			System.out.println("Matrix Dimensions Array: \t" + printArray(d));
			System.out.println("\tMinimum multiplications needed: \t" + dynamicMatrixChain(d));
			System.out.println("\tNumber of Recursive Calls: \t" + recursiveCalls);
			System.out.println("\tNumber of Scalar Multiplications: \t" + scalarMultiplications);
			System.out.println("\tTime taken by Dynamic Programming Approach: \t" + (System.currentTimeMillis() - a)
					+ " miliseconds");
			System.out.println(
					"------------------------------------------------------------------------------------------");
		}
	}

	private static int dynamicMatrixChain(int[] d) {
		int n = d.length;

		int m[][] = new int[n][n];
		int s[][] = new int[n][n];
		for (int i = 1; i < n; i++) {
			m[i][i] = 0;
		}
		for (int i = n - 1; i > 0; i--) {
			for (int j = i + 1; j < n; j++) {
				m[i][j] = INFINITY;
				for (int k = i; k <= j - 1; k++) {
					int multiplications = m[i][k] + m[k + 1][j] + d[i - 1] * d[k] * d[j];
					scalarMultiplications += 2;
					if (multiplications < m[i][j]) {
						m[i][j] = multiplications;
						s[i][j] = k;
					}
				}
			}
		}
		System.out.println("Dynamic Array: \n" + print2DArray(m));
		System.out.println("Parenthesization array: \n" + print2DArray(s));
		return m[1][n - 1];
	}

	private static String print2DArray(int[][] m) {
		String printLine = "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (i == 0) {
					printLine = printLine.concat("[" + j + "]\t");
				} else if (j == 0) {
					printLine = printLine.concat("[" + i + "]\t");
				} else {
					printLine = printLine.concat(m[i][j] + "\t");
				}
			}
			printLine = printLine.concat("\n");
		}
		return printLine;
	}

	private static String printArray(int[] array) {
		if (array == null)
			return null;
		String printLine = "";
		for (int j = 0; j < array.length; j++) {
			printLine = printLine.concat(", ").concat(String.valueOf(array[j]));
		}
		return printLine.replaceFirst(", ", "");
	}

}
