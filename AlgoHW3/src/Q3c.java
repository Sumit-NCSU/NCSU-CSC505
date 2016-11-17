import java.util.Arrays;

public class Q3c {

	private static final int UP = 10;
	private static final int LEFT = 01;
	private static final int DIAGONAL = 11;

	public static void main(String[] args) {
		int[] s = { 3, 45, 23, 9, 3, 99, 108, 76, 12, 77, 16, 18, 4 };
		System.out.println("Original array: " + printArray(s));
		int longest = findLNDSUsingLCS(s);
		System.out.println("Length of LNDS: " + longest);
	}

	private static int findLNDSUsingLCS(int[] s) {
		int[] t = Arrays.copyOf(s, s.length);
		Arrays.sort(t);
		System.out.println("Sorted array: \t" + printArray(t));
		return LCS(s, t);
	}
	private static int LCS(int[] a, int[] b) {
		int m = a.length, n = b.length;
		int x[][] = new int[m + 1][n + 1], helper[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					x[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					x[i][j] = x[i - 1][j - 1] + 1; helper[i][j] = DIAGONAL;
				} else {
					if (x[i - 1][j] > x[i][j - 1]) {
						x[i][j] = x[i - 1][j]; helper[i][j] = UP;
					} else {
						x[i][j] = x[i][j - 1]; helper[i][j] = LEFT;
					}
				}
			}
		}
		int i = x.length - 2, j = x.length - 2;
		String lcs = "";
		while (i > 0 && j > 0) {
			if (helper[i][j] == UP) {
				i -= 1;
			} else if (helper[i][j] == LEFT) {
				j -= 1;
			} else if (helper[i][j] == DIAGONAL) {
				i -= 1; j -= 1;
				lcs = String.valueOf(a[i] + "\t").concat(lcs);
			}
		}
		System.out.println("The LNDS is: \t" + lcs);
		return x[m][n];
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
