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

		int lastNum = Integer.MAX_VALUE;
		int part1 = 0;
		int part2 = -3; // as the first three always have the increment
		int[] lastvalues = new int[3];

		while (scan.hasNextLine()) {
			int number = scan.nextInt();
			if (number > lastvalues[2])
				part1++;

			int sumOfLastTwo = lastvalues[1] + lastvalues[2];
			if (sumOfLastTwo + number > sumOfLastTwo + lastvalues[0])
				part2++;

			lastvalues[0] = lastvalues[1];
			lastvalues[1] = lastvalues[2];
			lastvalues[2] = number;
		}
		scan.close();

		System.out.println("Teillösung 1: " + part1);
		System.out.println("Teillösung 2: " + part2);
	}

}
