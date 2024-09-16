import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day02 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day02.txt");
		Scanner scan = new Scanner(file);

		int part1 = 0;
		int part2 = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			switch (line) {
			case ("A X"):
				part1 += 4;
				part2 += 3;
				break;
			case ("A Y"):
				part1 += 8;
				part2 += 4;
				break;
			case ("A Z"):
				part1 += 3;
				part2 += 8;
				break;
			case ("B X"):
				part1 += 1;
				part2 += 1;
				break;
			case ("B Y"):
				part1 += 5;
				part2 += 5;
				break;
			case ("B Z"):
				part1 += 9;
				part2 += 9;
				break;
			case ("C X"):
				part1 += 7;
				part2 += 2;
				break;
			case ("C Y"):
				part1 += 2;
				part2 += 6;
				break;
			case ("C Z"):
				part1 += 6;
				part2 += 7;
				break;
			}
		}
		scan.close();
		System.out.println("Lösung Teil 1: " + part1);
		System.out.println("Lösung Teil 2: " + part2);
	}

}
