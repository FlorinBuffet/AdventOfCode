import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day_template {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/dayxx.txt");
		Scanner scan = new Scanner(file);


		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			
		}
		scan.close();
	}

}
