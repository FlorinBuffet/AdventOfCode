import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day11 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day11.txt");
		Scanner scan = new Scanner(file);
		List<day11Monkey> monkeys = new ArrayList<day11Monkey>();
		List<Integer> testValues = new ArrayList<Integer>();

		while (scan.hasNextLine()) {
			scan.next();
			String monkeyNumberLine = scan.next();
			int monkeyNumber = Integer.parseInt(monkeyNumberLine.substring(0, monkeyNumberLine.indexOf(":")));
			scan.nextLine();
			String items = scan.nextLine();
			items = items.substring(items.indexOf(":") + 2);
			scan.nextLine();
			scan.next();
			scan.next();
			scan.next();
			int test = scan.nextInt();
			testValues.add(test);
			scan.next();
			scan.next();
			scan.next();
			scan.next();
			scan.next();
			int ifTrue = scan.nextInt();
			scan.next();
			scan.next();
			scan.next();
			scan.next();
			scan.next();
			int ifFalse = scan.nextInt();
			day11Monkey tmp = new day11Monkey(monkeyNumber, test, ifTrue, ifFalse);
			monkeys.add(tmp);
			while (true) {
				try {
					int item = Integer.parseInt(items.substring(0, items.indexOf(",")));
					items = items.substring(items.indexOf(",") + 2);
					tmp.addItem(item);
					tmp.addItem2(item);
				} catch (IndexOutOfBoundsException e) {
					int item = Integer.parseInt(items);
					tmp.addItem(item);
					tmp.addItem2(item);
					break;
				}
			}
		}
		scan.close();

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < monkeys.size(); j++) {
				day11Monkey current = monkeys.get(j);
				while (current.items.size() >= 1) {
					long item = current.items.remove(0);
					current.itemsinspected++;
					item = operation(j, item);
					item = item / 3;
					if (item % current.test == 0) {
						monkeys.get(current.ifTrue).addItem(item);
					} else {
						monkeys.get(current.ifFalse).addItem(item);
					}

				}
			}
		}

		long max = 0;
		long max2 = 0;
		for (int i = 0; i < monkeys.size(); i++) {
			int tmp = monkeys.get(i).itemsinspected;
			if (tmp >= max) {
				max2 = max;
				max = tmp;
			} else if (tmp >= max2) {
				max2 = tmp;
			}
		}
		System.out.println("Lösung Teil 1: " + max * max2);

		int product = 1;
		for (int i : testValues) {
			product *= i;
		}

		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < monkeys.size(); j++) {
				day11Monkey current = monkeys.get(j);
				while (current.items2.size() >= 1) {
					long item = current.items2.remove(0);
					current.itemsinspected2++;
					item = operation(j, item);
					// item = item / 3;
					item = item % product;
					if (item % current.test == 0) {
						monkeys.get(current.ifTrue).addItem2(item);
					} else {
						monkeys.get(current.ifFalse).addItem2(item);
					}

				}
			}
		}

		max = 0;
		max2 = 0;
		for (int i = 0; i < monkeys.size(); i++) {
			int tmp = monkeys.get(i).itemsinspected2;
			if (tmp >= max) {
				max2 = max;
				max = tmp;
			} else if (tmp >= max2) {
				max2 = tmp;
			}
		}
		System.out.println("Lösung Teil 2: " + max * max2);

	}

	public static long operation(int monkeyNr, long old) {
		// return operationTest(monkeyNr, old);

		switch (monkeyNr) {
		case 0:
			return old * 11;
		case 1:
			return old + 8;
		case 2:
			return old * 3;
		case 3:
			return old + 4;
		case 4:
			return old * old;
		case 5:
			return old + 2;
		case 6:
			return old + 3;
		case 7:
			return old + 5;
		}
		return old;

	}

	public static long operationTest(int monkeyNr, long old) {
		switch (monkeyNr) {
		case 0:
			return old * 19;
		case 1:
			return old + 6;
		case 2:
			return old * old;
		case 3:
			return old + 3;
		}
		return old;
	}

}
