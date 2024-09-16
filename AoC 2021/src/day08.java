import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class day08 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day08.txt");
		Scanner scan = new Scanner(file);

		int part1Result = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] input = new String[10];
			String[] output = new String[4];
			for (int i = 0; i<10; i++) {
				input[i] = line.substring(0,line.indexOf(" "));
				line = line.substring(line.indexOf(" ")+1);
			}
			line = line.substring(line.indexOf(" ")+1);
			for (int i = 0; i<4; i++) {
				try {
					output[i] = line.substring(0,line.indexOf(" "));
					line = line.substring(line.indexOf(" ")+1);
				} catch (IndexOutOfBoundsException e) {
					output[i] = line;
				}
				
				char[] chars = output[i].toCharArray();
				Arrays.sort(chars);
				output[i] = new String(chars);
			}
			
			for (int i = 0;i<4;i++) {
				if ((output[i].length() == 2) || (output[i].length() == 3) || (output[i].length() == 4) || (output[i].length() == 7)) {
					part1Result++;
				}
			}
		}
		scan.close();
		System.out.println("Teill�sung 1: "+part1Result);
	}

}
