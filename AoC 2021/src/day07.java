import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day07 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day07.txt");
		Scanner scan = new Scanner(file);

		List<Integer> crabs = new ArrayList<Integer>();

		String line = scan.nextLine();
		while (true) {
			try {
				int value = Integer.parseInt(line.substring(0, line.indexOf(',')));
				crabs.add(value);
				line = line.substring(line.indexOf(',')+1);
			}catch(IndexOutOfBoundsException e) {
				crabs.add(Integer.parseInt(line));
				break;
			}
		}
		scan.close();
		
		Collections.sort(crabs);
		int crabMax = crabs.get(crabs.size()-1);
		int[] movements = new int[crabMax+1];
		int[] fuelCost = new int[crabMax+1];
		for (int i = 0; i<movements.length; i++) {
			for (int crab : crabs) {
				movements[i] += Math.abs(crab-i);
				fuelCost[i] += getPart2MovementCost(Math.abs(crab-i));
			}
		}
		
		int sumPart1 = Integer.MAX_VALUE;
		int sumPart2 = Integer.MAX_VALUE;
		for (int i = 0; i<movements.length; i++) {
			sumPart1 = Math.min(movements[i], sumPart1);
			sumPart2 = Math.min(fuelCost[i], sumPart2);
		}
		System.out.println("Teillösung 1: "+ sumPart1);
		System.out.println("Teillösung 1: "+ sumPart2);
	}
	
	public static int getPart2MovementCost(int distance) {
		int cost = 0;
		for (int i = 0; i<=distance; i++) {
			cost += i;
		}
		return cost;
	}

}
