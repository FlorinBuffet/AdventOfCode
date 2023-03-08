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
		String line = scan.nextLine();

		long[] ages = new long[9];
		
		while (true) {
			int value = Integer.parseInt(line.substring(0,1));
			ages[value]++;
			try {
				line = line.substring(2);
			}catch(IndexOutOfBoundsException e){
				break;
			}
		}
		
		for (int i = 0; i<=256; i++) {
			if (i==80)
				countFish(ages, i);
			else if (i==256)
				countFish(ages, i);
			long reproduce = ages[0];
			for (int j = 1; j<ages.length; j++) {
				ages[j-1] = ages[j];
			}
			ages[8] = reproduce;
			ages[6] += reproduce;
		}
	}
	
	public static void countFish(long[] ages, int days) {
		long sumOfFish = 0;
		for (int i = 0; i<ages.length; i++) {
			sumOfFish += ages[i];
		}
		System.out.println("Nach "+days+" Tagen gibt es so viele Fische: "+sumOfFish);
	}

}
