import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day01 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day01.txt");
		Scanner scan = new Scanner(file);

		List<Integer> calories = new ArrayList<Integer>();

		int currentElf = 0;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (line == "") {
				calories.add(currentElf);
				currentElf = 0;
			} else {
				currentElf += Integer.parseInt(line);
			}
		}
		scan.close();

		Collections.sort(calories, Collections.reverseOrder());

		System.out.println("Die wie vielen höchsten möchten Sie?");
		Scanner input = new Scanner(System.in);
		int amount = input.nextInt();
		input.close();

		int sum = 0;
		for (int i = 0; i < amount; i++) {
			System.out.println("Platz " + (i + 1) + ": " + calories.get(i));
			sum += calories.get(i);
		}
		System.out.println("Summe: " + sum);

	}

}
