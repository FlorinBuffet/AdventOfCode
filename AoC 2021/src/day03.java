import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day03 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day03.txt");
		Scanner scan = new Scanner(file);

		int lineLength = 12;

		int[] countOnes = new int[lineLength];
		int sampleSize = 0;

		List<String> allDiagnostics = new ArrayList<String>();

		while (scan.hasNextLine()) {
			sampleSize++;
			String line = scan.nextLine();
			allDiagnostics.add(line);
			Long lLine = Long.parseLong(line);
			for (int i = lineLength - 1; i >= 0; i--) {
				countOnes[i] += lLine % 10;
				lLine = lLine / 10;
			}
		}

		scan.close();

		long gamma = 0;
		long epsilon = 0;

		for (int i = 0; i < lineLength; i++) {
			gamma *= 10;
			epsilon *= 10;
			if (countOnes[i] > sampleSize / 2) {
				countOnes[i] = 1;
				gamma++;
			} else {
				countOnes[i] = 0;
				epsilon++;
			}
		}

		long part1 = Long.parseLong("" + gamma, 2) * Long.parseLong("" + epsilon, 2);

		System.out.println("Lösung Berechnungsmethode 1: " + part1);

		List<String> copyDiagnostics = new ArrayList<String>(allDiagnostics);

		int valueRequested = countOnes[0];
		int bit = 0;
		while (copyDiagnostics.size() > 1) {
			int count1 = 0;
			int count0 = 0;
			for (int i = copyDiagnostics.size() - 1; i >= 0; i--) {
				String work = copyDiagnostics.get(i);
				if (Character.getNumericValue(work.charAt(bit)) != valueRequested) {
					copyDiagnostics.remove(i);
				} else if ((bit + 1) < lineLength) {
					if (Character.getNumericValue(work.charAt(bit + 1)) == 1) {
						count1++;
					} else {
						count0++;
					}
				}
			}
			bit++;
			if (count1 >= count0) {
				valueRequested = 1;
			} else {
				valueRequested = 0;
			}
		}

		bit = 0;
		valueRequested = (countOnes[0] + 1) % 2;
		while (allDiagnostics.size() > 1) {
			int count1 = 0;
			int count0 = 0;
			for (int i = allDiagnostics.size() - 1; i >= 0; i--) {
				String work = allDiagnostics.get(i);
				if (Character.getNumericValue(work.charAt(bit)) != valueRequested) {
					allDiagnostics.remove(i);
				} else if ((bit + 1) < lineLength) {
					if (Character.getNumericValue(work.charAt(bit + 1)) == 1) {
						count1++;
					} else {
						count0++;
					}
				}
			}
			bit++;
			if (count1 < count0) {
				valueRequested = 1;
			} else {
				valueRequested = 0;
			}
		}

		long part2 = Long.parseLong("" + copyDiagnostics.get(0), 2) * Long.parseLong("" + allDiagnostics.get(0), 2);

		System.out.println("Lösung Berechnungsmethode 2: " + part2);

	}

}
