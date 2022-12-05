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


		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			
		}
		scan.close();
	}

}
