import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class day13 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day13.txt");
		Scanner scan = new Scanner(file);

		List<day13Packet> packets = new ArrayList<day13Packet>();
		int correctSignals = 0;
		int index = 1;

		while (scan.hasNextLine()) {
			day13Packet packet1 = new day13Packet(scan.nextLine());
			day13Packet packet2 = new day13Packet(scan.nextLine());

			try {
				scan.nextLine();
			} catch (NoSuchElementException e) {
			}

			packets.add(packet1);
			packets.add(packet2);

			correctSignals += packet1.compareTo(packet2) > 0 ? index : 0;
			index++;
		}
		scan.close();
		System.out.println("Teillösung 1: " + correctSignals);

		day13Packet tmp = new day13Packet("[[2]]");
		packets.add(tmp);
		tmp = new day13Packet("[[6]]");
		packets.add(tmp);

		Collections.sort(packets);
		Collections.reverse(packets);

		int product = 1;

		for (int i = 0; i < packets.size(); i++) {
			if ((packets.get(i).str.equals("[[2]]")) || (packets.get(i).str.equals("[[6]]"))) {
				product *= i + 1;
			}
		}

		System.out.println("Teillösung 2: " + product);
	}

}
