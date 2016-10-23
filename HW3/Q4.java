
public class Q4 {

	public static void main(String[] args) {
		int d = 3;
		int[] houses = { 2, 5, 8, 17, 19, 22, 28, 29, 33, 45, 49, 99, 102, 122, 126 };
		System.out.print("List of Houses: ");
		String printLine = "";
		for (int house : houses) {
			printLine = printLine.concat(", ").concat(String.valueOf(house));
		}
		System.out.print(printLine.replaceFirst(", ", ""));
		System.out.println("");
		int[] towers = getTowers(houses, d);
		System.out.print("List of Towers: ");
		printLine = "";
		for (int tower : towers) {
			if (tower != 0) {
				printLine = printLine.concat(", ").concat(String.valueOf(tower));
			}
		}
		System.out.println(printLine.replaceFirst(", ", ""));
	}

	private static int[] getTowers(int[] houses, int d) {
		int[] towers = new int[houses.length];
		int j = 0;
		towers[j] = houses[j] + d;
		System.out.println("Build first tower at location: " + (houses[j] + d));
		for (int i = 1; i < houses.length; i++) {
			if ((towers[j] + d >= houses[i]) && (towers[j] - d <= houses[i])) {
				System.out.println("House at: " + houses[i] + " lies in range of tower at: " + towers[j] + ", with range: [" + (towers[j] - d) + ", " + (towers[j] + d) + "]. No need for new tower.");
				continue;
			} else {
				j++;
				System.out.println("House at: " + houses[i] + " is not covered by any tower. Build a new tower at: " + (houses[i] + d));
				towers[j] = houses[i] + d;
			}
		}
		return towers;
	}

}
