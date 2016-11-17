
public class Q3a {

	public static void main(String[] args) {
		int[] s = { 3, 45, 23, 9, 3, 99, 108, 76, 12, 77, 16, 18, 4 };
		System.out.println("Original Array: \t\t\t\t\t" + printArray(s));
		System.out.println("Length of the longest non-decreasing subsequence: \t" + findLNDS(s));
	}

	private static int findLNDS(int[] s) {
		int[] longest = new int[s.length];
		int maxLength = 0, maxIndex = 0;
		longest[0] = 1;
		for (int i = 1; i < s.length; i++) {
			longest[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if ((longest[j] + 1 > longest[i]) && (s[j] < s[i])) {
					longest[i] = longest[j] + 1;
				}
			}
			if (longest[i] > maxLength) {
				maxIndex = i;
				maxLength = longest[i];
			}
		}
		System.out.print("The longest non-decreasing Subsequece array: \t\t" + printArray(longest)
				+ "\nThe longest non-decreasing subsequence is: \t\t");
		String line = String.valueOf(", " + s[maxIndex]);
		int temp = maxLength;
		for (int i = maxIndex; i >= 0; i--) {
			if (longest[i] < temp) {
				line = String.valueOf(", " + s[i]).concat(line);
				temp--;
			}
		}
		System.out.println(line.replaceFirst(", ", ""));
		return maxLength;
	}

	private static String printArray(int[] array) {
		String printLine = "";
		for (int j = 0; j < array.length; j++) {
			printLine = printLine.concat(", ").concat(String.valueOf(array[j]));
		}
		return printLine.replaceFirst(", ", "");
	}

}
