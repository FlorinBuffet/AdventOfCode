import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day02 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("AoC 2023/data/day02.txt");
		Scanner scan = new Scanner(file);

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			gameIsPossible(line, 12, 13, 14);
		}
		scan.close();
	}

	public static boolean gameIsPossible(String line, int red, int green, int blue) {
		int gameNumber = Integer
				.parseInt(line.replaceAll("Game ", "").substring(0, line.replaceAll("Game ", "").indexOf(" ")-1));
		line = line.substring(line.indexOf(":")+2);
		System.out.println(line);
		return false;
	}

	public static boolean subgameIsPossible(String line, int red, int green, int blue){
		number = 
		return false;
	}
}
