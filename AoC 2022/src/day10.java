import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day10 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day10.txt");
		Scanner scan = new Scanner(file);

		int xReg = 1;
		int cycle = 1;
		int signal = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lScan = new Scanner(line);
			String command = lScan.next();
			if (command.equals("addx")) {
				int value = lScan.nextInt();
				draw(cycle, xReg);
				cycle++;
				if ((cycle == 20) || (cycle == 60) || (cycle == 100) || (cycle == 140) || (cycle == 180)
						|| (cycle == 220)) {
					signal += xReg * cycle;
				}
				draw(cycle, xReg);
				cycle++;
				xReg += value;
			} else {
				draw(cycle, xReg);
				cycle++;
			}
			if ((cycle == 20) || (cycle == 60) || (cycle == 100) || (cycle == 140) || (cycle == 180)
					|| (cycle == 220)) {
				signal += xReg * cycle;
			}
		}
		scan.close();
		System.out.println();
		System.out.println("Solution Part 1: " + signal);
	}

	public static void draw(int cycle, int xReg) {
		xReg++;
		if ((cycle == 41) || (cycle == 81) || (cycle == 121) || (cycle == 161) || (cycle == 201) || (cycle == 241)) {
			System.out.println();
		}
		cycle = cycle % 40;
		if (Math.abs(cycle - xReg) <= 1) {
			System.out.print("#");
		} else {
			System.out.print(".");
		}
	}
}
