import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day04 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day04.txt");
		Scanner scan = new Scanner(file);

		int part1 = 0;
		int part2 = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			int startOne = Integer.parseInt(line.substring(0, line.indexOf("-")));
			int endOne = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(",")));
			int startTwo = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.lastIndexOf("-")));
			int endTwo = Integer.parseInt(line.substring(line.lastIndexOf("-") + 1, line.length()));

			if ((startOne <= startTwo) && (endTwo <= endOne)) {
				part1++;
			} else if ((startTwo <= startOne) && (endOne <= endTwo)) {
				part1++;
			}

			if ((startOne <= startTwo) && (startTwo <= endOne)) {
				part2++;
			} else if ((startTwo <= startOne) && (startOne <= endTwo)) {
				part2++;
			}
		}
		scan.close();
		System.out.println("Lösung Teil 1: " + part1);
		System.out.println("Lösung Teil 2: " + part2);
	}

}
