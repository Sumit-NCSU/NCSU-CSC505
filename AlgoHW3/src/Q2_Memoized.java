
public class Q2_Memoized {

	private static int recursiveCalls = 0;
	private static int scalarMultiplications = 0;
	private static final int INFINITY = 999999;

	public static void main(String[] args) {
		int[][] inputs = { { 5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5 },
				{ 2, 5, 6, 8, 8, 4, 6, 9, 3, 9, 5, 12, 21, 45, 23, 67, 18, 108, 98, 67, 54 },
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 },
				{ 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25 },
				{ 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35 } };
		executeAndPrint(inputs);
	}

	private static void executeAndPrint(int[][] inputs) {
		for (int[] d : inputs) {
			long a = System.currentTimeMillis();
			recursiveCalls = 0;
			scalarMultiplications = 0;
			System.out.println("Matrix Dimensions Array: \t" + printArray(d));
			System.out.println("\tMinimum multiplications needed: \t" + memoizedMatrixChain(d));
			System.out.println("\tNumber of Recursive Calls: \t" + recursiveCalls);
			System.out.println("\tNumber of Scalar Multiplications: \t" + scalarMultiplications);
			System.out.println("\tTime taken by Dynamic Programming Approach: \t" + (System.currentTimeMillis() - a)
					+ " miliseconds");
			System.out.println(
					"------------------------------------------------------------------------------------------");
		}
	}

	private static int memoizedMatrixChain(int[] d) {
		int n = d.length;
		int m[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = INFINITY;
			}
		}
		int val = lookupChain(m, d, 1, n - 1);
		return val;
	}

	private static int lookupChain(int[][] m, int[] d, int i, int j) {
		if (m[i][j] < INFINITY) {
			return m[i][j];
		}
		if (i == j) {
			m[i][j] = 0;
		} else {
			for (int k = i; k <= j - 1; k++) {
				int multiplications = lookupChain(m, d, i, k) + lookupChain(m, d, k + 1, j) + d[i - 1] * d[k] * d[j];
				scalarMultiplications += 2;
				recursiveCalls++;
				if (multiplications < m[i][j]) {
					m[i][j] = multiplications;
				}
			}
		}
		return m[i][j];
	}

	private static String print2DArray(int[][] m) {
		String printLine = "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				printLine = printLine.concat(m[i][j] + "\t");
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
