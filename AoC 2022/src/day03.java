import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day03 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day03.txt");
		Scanner scan = new Scanner(file);

		String alphabet = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] packedPart1 = new int[53];
		int[] packedPart2 = new int[53];
		int part1 = 0;
		int part2 = 0;
		int elfGroup = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			elfGroup++;
			for (int i = 0; i < line.length() / 2; i++) {
				char ch = line.charAt(i);
				packedPart1[alphabet.indexOf(ch)]++;
			}
			for (int i = line.length() / 2; i < line.length(); i++) {
				char ch = line.charAt(i);
				if (packedPart1[alphabet.indexOf(ch)] > 0) {
					part1 += alphabet.indexOf(ch);
					packedPart1[alphabet.indexOf(ch)] = 0;
				}
			}

			for (int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				if (elfGroup == 1) {
					packedPart2[alphabet.indexOf(ch)] = 1;
				} else if ((elfGroup == 2) && (packedPart2[alphabet.indexOf(ch)] == 1)) {
					packedPart2[alphabet.indexOf(ch)] = 2;
				} else if (elfGroup == 3) {
					if (packedPart2[alphabet.indexOf(ch)] > 1) {
						part2 += alphabet.indexOf(ch);
						packedPart2[alphabet.indexOf(ch)] = 0;
					}
				}
			}

			for (int i = 0; i < 53; i++) {
				packedPart1[i] = 0;
				if (elfGroup == 3) {
					packedPart2[i] = 0;
				}
			}
			elfGroup = elfGroup % 3;
		}
		scan.close();
		System.out.println("Teil 1: " + part1);
		System.out.println("Teil 2: " + part2);
	}

}
