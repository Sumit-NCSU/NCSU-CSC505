
public class Pooja {

	private static String matrices = "";

	public static void main(String[] args) {
		// 3, 8, 4, 6, 6, 9, 2, 5
		// int[][] inputs = { { 29, 26, 8, 13, 27, 17, 12, 30, 13, 12, 21, 20,
		// 20, 28, 6, 23, 18, 19, 17, 25, 9 } };
		// executeAndPrint(inputs);
		int[] ip = { 3, 8, 4, 6, 6, 9, 2, 5 };
		System.out.println("Initial Array: " + printArray(ip));
		int[][] s = matrixChainOrder(ip);
		System.out.println(print2DArray(s));
		putBrackets(s, 0, ip.length - 2);
		matrices = matrices.substring(1, matrices.length() - 1);
		putNumbers();
		System.out.println(matrices);
	}

	private static void putBrackets(int[][] s, int i, int j) {
		if (i == j) {
			matrices.concat("M");
		} else {
			matrices.concat("(");
			putBrackets(s, i, s[i][j]);
			matrices.concat("*");
			putBrackets(s, s[i][j] + 1, j);
			matrices.concat(")");
		}
	}

	private static void putNumbers() {
		int counter = 0;
		for (char c : matrices.toCharArray()) {
			if (c == 'M') {
				counter += 1;
				System.out.print('M');
				System.out.print(counter);
			} else {
				System.out.print(c);
			}
		}
	}

	private static void pythPara() {
		// b = []
		// def put_brackets(s, i , j):
		//
		// if i == j:
		// b.append('M')
		// else:
		// b.append('(')
		// put_brackets(s,i,s[i][j])
		// b.append('*')
		// put_brackets(s,s[i][j]+1,j)
		// b.append(')')
		//
		// def put_numbers(s):
		// counter = 0
		// for i in b:
		// if i == 'M':
		// counter += 1
		// print 'M',
		// sys.stdout.softspace = False
		// print counter,
		// else:
		// print i,
		//
		// put_brackets(k_matrix,1,size)
		//
		// del b[0]
		// del b[len(b)-1]
		//
		// put_numbers(b)
	}

	private static String doParanthesization(int[][] s, String matrixNames, int i, int j) {
		String retVal = "";
		if (i == j || i < 0 || j < 0) {
			return "";
		}
		System.out.println("Calling on: (" + (i) + "," + (j) + ")");
		int breakPoint = s[i][j];
		for (int count = 0; count < s.length; count++) {
			System.out.println("M".concat(String.valueOf(breakPoint)));
			System.out.println("Call: " + i + "," + (breakPoint - 1));
			breakPoint = s[i][breakPoint - 1];
		}
		// System.out.println("breakpoint = " + breakPoint);
		// System.out.println("now call on (" + i + "," + (breakPoint) + ") and
		// (" + (breakPoint) + "," + j + ")");
		// if (i != (breakPoint - 1)) {
		// System.out.println("now call on (" + i + "," + (breakPoint) + ")");
		// // doParanthesization(s, matrixNames, i, (breakPoint - 1));
		// }
		// if (j != (breakPoint + 1)) {
		// System.out.println("now call on (" + (breakPoint + 1) + "," + j +
		// ")");
		// // doParanthesization(s, matrixNames, (breakPoint + 1), j);
		// }
		return retVal;
	}

	public static int[][] matrixChainOrder(int[] p) {
		int n = p.length - 1;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		for (int counter = 1; counter < n; counter++) {
			for (int i = 0; i < n - counter; i++) {
				int j = i + counter;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k + 1;
					}
				}
			}
		}
		return s;
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
