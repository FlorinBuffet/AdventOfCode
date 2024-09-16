import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day01 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("AoC 2023/data/day01.txt");
		Scanner scan = new Scanner(file);

		int resultA = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			
			int firstNumber = -1;
			int lastNumber = 0;

			for (Character c : line.toCharArray()){
				if (Character.isDigit(c)){
					if (firstNumber == -1){
						firstNumber = c - '0';
					}
					lastNumber = c - '0';
				}
			}
			resultA += 10*firstNumber + lastNumber;
		}
		scan.close();
		System.out.println("Resultat Teil A: "+resultA);
	}
}
