import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day04 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day04.txt");
		Scanner scan = new Scanner(file);
		
		int numberOfBingos = 100;
		
		int[][][] bingos = new int[numberOfBingos][5][5];
		int[] finished = new int[numberOfBingos];
		int[] finishedNumber = new int[numberOfBingos];
		int ranking = 1;

		String workflow = scan.nextLine();

		for (int i = 0; i<numberOfBingos; i++) {
			for (int j = 0; j<5; j++) {
				for (int k = 0; k<5; k++) {
					bingos[i][j][k] = scan.nextInt();
				}
			}
		}			
		scan.close();
		
		while (true) {
			int number = Integer.parseInt(workflow.substring(0, workflow.indexOf(",")));
			workflow = workflow.substring(workflow.indexOf(",")+1,workflow.length());
			
			for (int i = 0; i<numberOfBingos; i++) {
				if (finished[i] == 0) {
					for (int j = 0; j<5; j++) {
						for (int k = 0; k<5; k++) {
							if (bingos[i][j][k] == number) {
								bingos[i][j][k] = -1;
							}
						}						
					}
					boolean full = false;
					for (int j = 0; j<5; j++) {
						int found = 0;
						for (int k = 0; k<5; k++) {
							if (bingos[i][j][k] == -1) {
								found++;
							}
						}
						if (found==5) {
							full = true;
						}
					}
					for (int j = 0; j<5; j++) {
						int found = 0;
						for (int k = 0; k<5; k++) {
							if (bingos[i][k][j] == -1) {
								found++;
							}
						}
						if (found==5) {
							full = true;
						}
					}
					if (full) {
						finished[i] = ranking;
						finishedNumber[i] = number;
						ranking++;
					}
				}
			}
			
			if (ranking == numberOfBingos+1) {
				break;
			}
		}
		
		int firstBoard = -1;
		int lastBoard = -1;
		
		for (int i = 0; i<numberOfBingos; i++) {
			if (finished[i]==1)
				firstBoard = i;
			else if (finished[i]==numberOfBingos)
				lastBoard = i;
		}
		
		int firstSum = 0;
		int lastSum = 0;
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				if (bingos[firstBoard][i][j] != -1) {
					firstSum += bingos[firstBoard][i][j];
				}
				if (bingos[lastBoard][i][j] != -1) {
					lastSum += bingos[lastBoard][i][j];
				}
			}
		}
		System.out.println("First Board Sum: "+firstSum*finishedNumber[firstBoard]);
		System.out.println("Last Board Sum: "+lastSum*finishedNumber[lastBoard]);
	}

}
