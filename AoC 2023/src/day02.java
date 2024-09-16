import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day02 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("AoC 2023/data/day02.txt");
		Scanner scan = new Scanner(file);

		int resultA = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			resultA += gameIsPossible(line, 12, 13, 14);
		}
		scan.close();
		System.out.println("Resultat Teil A: " + resultA);
	}

	public static int gameIsPossible(String line, int red, int green, int blue) {
		int gameNumber = Integer
				.parseInt(line.replaceAll("Game ", "").substring(0, line.replaceAll("Game ", "").indexOf(" ") - 1));
		line = line.substring(line.indexOf(":") + 2);
		while (line.indexOf(";") > 0) {
			String game = line.substring(0, line.indexOf(";"));
			line = line.substring(line.indexOf(";") + 2);
			if (!subgameIsPossible(game, red, green, blue))
				return 0;
		}
		if (subgameIsPossible(line, red, green, blue))
			return gameNumber;
		else
			return 0;
	}

	public static boolean subgameIsPossible(String line, int red, int green, int blue) {
		line = line + ", ";
		while (line.indexOf(",") > 0) {
			int number = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
			String color = line.substring(0, line.indexOf(","));
			line = line.substring(line.indexOf(",") + 2);
			switch (color) {
				case ("red"):
					if (number > red)
						return false;
					break;
				case ("green"):
					if (number > green)
						return false;
					break;
				case ("blue"):
					if (number > blue)
						return false;
					break;
			}
		}
		return true;
	}
}
