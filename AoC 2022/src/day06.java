import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day06 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day06.txt");
		Scanner scan = new Scanner(file);
		String input = scan.nextLine();
		scan.close();

		int position = 0;
		boolean part1found = false;

		while (true) {
			String lastfour = input.substring(position, position + 4);
			char a = lastfour.charAt(0);
			char b = lastfour.charAt(1);
			char c = lastfour.charAt(2);
			char d = lastfour.charAt(3);

			if ((a != b) && (a != c) && (a != d) && (b != c) && (b != d) && (c != d) && !part1found) {
				System.out.println("Lösung Teil 1: " + (position + 4));
				part1found = true;
			}

			String lastfourteen = input.substring(position, position + 14);
			boolean allUnique = true;
			for (int i = 0; i < 14; i++) {
				for (int j = i + 1; j < 14; j++) {
					if (lastfourteen.charAt(i) == lastfourteen.charAt(j))
						allUnique = false;
				}
			}
			if (allUnique) {
				System.out.println("Lösung Teil 2: " + (position + 14));
				break;
			}

			position++;
		}
	}

}
