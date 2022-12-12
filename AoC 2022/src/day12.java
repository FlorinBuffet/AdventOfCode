import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day12 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day12.txt");
		Scanner scan = new Scanner(file);
		
		String possibleChanges = "SabcdefghijklmnopqrstuvwxyzE";

		//int size1 = 5; int size2 = 8;
		int size1 = 41; int size2 = 80;
		
		char[][] field = new char[size1][size2];
		int[][] moves = new int[size1][size2];
		
		for (int i = 0; i<field.length; i++) {
			String line = scan.nextLine();
			for (int j = 0; j<field[i].length; j++) {
				field[i][j] = line.charAt(j);
				moves[i][j] = field[i][j] == 'S' ? 0 : Integer.MAX_VALUE-1;
			}
		}
		scan.close();
		
		boolean changesmade = true;
		while (changesmade) {
			System.out.println("new Loop");
			changesmade = false;
			for (int i = 0; i<field.length; i++) {
				for (int j = 0; j<field[i].length; j++) {
					
					int herePos = possibleChanges.indexOf(field[i][j]);
					
					int minMoves = moves[i][j];
					
					try {
						int neighbourPos = possibleChanges.indexOf(field[i-1][j]);
						if (Math.abs(neighbourPos-herePos) <= 1)
							minMoves = Math.min(minMoves, moves[i-1][j]+1);
					}catch (IndexOutOfBoundsException e) {}
					
					try {
						int neighbourPos = possibleChanges.indexOf(field[i+1][j]);
						if (Math.abs(neighbourPos-herePos) <= 1)
							minMoves = Math.min(minMoves, moves[i+1][j]+1);
					}catch (IndexOutOfBoundsException e) {}
					
					try {
						int neighbourPos = possibleChanges.indexOf(field[i][j-1]);
						if (Math.abs(neighbourPos-herePos) <= 1)
							minMoves = Math.min(minMoves, moves[i][j-1]+1);
					}catch (IndexOutOfBoundsException e) {}
					
					try {
						int neighbourPos = possibleChanges.indexOf(field[i][j+1]);
						if (Math.abs(neighbourPos-herePos) <= 1)
							minMoves = Math.min(minMoves, moves[i][j+1]+1);
					}catch (IndexOutOfBoundsException e) {}
					
					if (moves[i][j]!=minMoves)
						changesmade = true;
					moves[i][j] = minMoves;
				}
			}
		}
		for (int i = 0; i<field.length; i++) {
			for (int j = 0; j<field[i].length; j++) {
				if (field[i][j] == 'E')
					System.out.println("Lösung Teil 1: "+moves[i][j]);
			}
		}
	}

}
