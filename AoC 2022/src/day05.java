import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day05 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day05.txt");
		Scanner scan = new Scanner(file);

		String[] heaps9000 = new String[10];
		heaps9000[1] = "FDBZTJRN";
		heaps9000[2] = "FSNJH";
		heaps9000[3] = "CRNJGZFQ";
		heaps9000[4] = "FVNGRTQ";
		heaps9000[5] = "LTQF";
		heaps9000[6] = "QCWZBRGN";
		heaps9000[7] = "FCLSNHM";
		heaps9000[8] = "DNQMTJ";
		heaps9000[9] = "PGS";

		String[] heaps9001 = new String[10];
		heaps9001[1] = "FDBZTJRN";
		heaps9001[2] = "FSNJH";
		heaps9001[3] = "CRNJGZFQ";
		heaps9001[4] = "FVNGRTQ";
		heaps9001[5] = "LTQF";
		heaps9001[6] = "QCWZBRGN";
		heaps9001[7] = "FCLSNHM";
		heaps9001[8] = "DNQMTJ";
		heaps9001[9] = "PGS";

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lScanner = new Scanner(line);
			lScanner.next();
			int amount = lScanner.nextInt();
			lScanner.next();
			int origin = lScanner.nextInt();
			lScanner.next();
			int destination = lScanner.nextInt();
			lScanner.close();

			for (int i = 0; i < amount; i++) {
				String moving = heaps9000[origin].substring(heaps9000[origin].length() - 1);
				heaps9000[origin] = heaps9000[origin].substring(0, heaps9000[origin].length() - 1);
				heaps9000[destination] = heaps9000[destination] + moving;
			}

			String moving = heaps9001[origin].substring(heaps9001[origin].length() - amount);
			heaps9001[origin] = heaps9001[origin].substring(0, heaps9001[origin].length() - amount);
			heaps9001[destination] = heaps9001[destination] + moving;

		}
		scan.close();

		String CM9000Result = "";
		String CM9001Result = "";

		for (int i = 1; i < 10; i++) {
			CM9000Result += heaps9000[i].substring(heaps9000[i].length() - 1);
			CM9001Result += heaps9001[i].substring(heaps9001[i].length() - 1);
		}

		System.out.println("Lösung CrateMover9000: " + CM9000Result);
		System.out.println("Lösung CrateMover9001: " + CM9001Result);
	}

}
