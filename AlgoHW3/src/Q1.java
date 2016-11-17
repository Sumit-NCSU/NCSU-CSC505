public class Q1 {

	public static void main(String[] args) {
		int coins[] = { 1, 5, 10, 25 };
		int n = 21;
		System.out.println("The minimum number of coins needed to change: " + minCoins(coins, n));
	}

	private static int minCoins(int[] coins, int n) {
		System.out.print("Amount to change: " + n + ", coins available: [" + printArray(coins) + "]");
		System.out.println("\n");
		int arr[] = new int[n + 1];
		arr[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			arr[i] = 999999;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					int numCoins = arr[i - coins[j]];
					if (arr[i] > numCoins + 1) {
						arr[i] = numCoins + 1;
					}
				}
			}
		}
		printDPArray(arr);
		System.out.println("\n");
		return arr[n];
	}

	private static void printDPArray(int[] arr) {
		System.out.println("Filled Array for Dynamic Programming: ");
		String line1 = "";
		String line2 = "";
		String line3 = "";
		for (int i = 0; i < arr.length; i++) {
			line1 = line1.concat(", " + String.valueOf(i));
			if (i >= 10) {
				line2 = line2.concat("----");
				line3 = line3.concat(",  " + arr[i]);
			} else {
				line2 = line2.concat("---");
				line3 = line3.concat(", " + arr[i]);
			}
		}
		System.out.println(line1.replaceFirst(", ", ""));
		System.out.println(line2);
		System.out.println(line3.replaceFirst(", ", ""));
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