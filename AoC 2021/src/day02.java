import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day02 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day02.txt");
		Scanner scan = new Scanner(file);

		int hPos = 0;
		int dPosPart1 = 0;
		int dPosPart2 = 0;
		int aim = 0;

		while (scan.hasNextLine()) {
			String direction = scan.next();
			int amount = scan.nextInt();

			switch (direction) {
			case ("forward"):
				hPos += amount;
				dPosPart2 += aim * amount;
				break;
			case ("down"):
				dPosPart1 += amount;
				aim += amount;
				break;
			case ("up"):
				dPosPart1 -= amount;
				aim -= amount;
				break;
			}
		}
		scan.close();

		System.out.println("Lösung Teil 1: " + hPos * dPosPart1);
		System.out.println("Lösung Teil 2: " + hPos * dPosPart2);
	}

}
