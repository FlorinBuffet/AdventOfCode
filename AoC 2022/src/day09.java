import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day09 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day09.txt");
		Scanner scan = new Scanner(file);

		int hX = 1000;
		int hY = 1000;
		boolean[][] visitedTail = new boolean[2000][2000];
		boolean[][] visitedTail9 = new boolean[2000][2000];
		visitedTail[1000][1000] = true;
		visitedTail9[1000][1000] = true;
		int[][] tPos = new int[9][2];
		for (int i = 0; i < tPos.length; i++) {
			tPos[i][0] = 1000;
			tPos[i][1] = 1000;
		}

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lScanner = new Scanner(line);
			String direction = lScanner.next();
			int amount = lScanner.nextInt();

			for (int i = 0; i < amount; i++) {
				if (direction.equals("U"))
					hY--;
				else if (direction.equals("R"))
					hX++;
				else if (direction.equals("D"))
					hY++;
				else if (direction.equals("L"))
					hX--;
				for (int k = 0; k < tPos.length; k++) {
					tPos = calculateTail(hX, hY, tPos, k);
				}
				visitedTail[tPos[0][0]][tPos[0][1]] = true;
				visitedTail9[tPos[8][0]][tPos[8][1]] = true;
			}
			lScanner.close();
		}
		scan.close();

		int visited = 0;
		int visitedby9 = 0;
		for (int i = 0; i < visitedTail.length; i++) {
			for (int j = 0; j < visitedTail.length; j++) {
				visited += visitedTail[i][j] ? 1 : 0;
				visitedby9 += visitedTail9[i][j] ? 1 : 0;
			}
		}
		System.out.println("Lösung Teilaufgabe 1: " + visited);
		System.out.println("Lösung Teilaufgabe 2: " + visitedby9);
	}

	public static int[][] calculateTail(int hX, int hY, int[][] tPos, int tNumber) {
		int tX = tPos[tNumber][0];
		int tY = tPos[tNumber][1];

		if (tNumber > 0) {
			hX = tPos[tNumber - 1][0];
			hY = tPos[tNumber - 1][1];
		}

		if ((Math.abs(hX - tX) <= 1) && (Math.abs(hY - tY) <= 1)) {
			return tPos;
		} else if ((Math.abs(hX - tX) > 1) || (Math.abs(hY - tY) > 1)) {
			int movementX = hX - tX == 0 ? 0 : hX - tX > 0 ? 1 : -1;
			int movementY = hY - tY == 0 ? 0 : hY - tY > 0 ? 1 : -1;
			tPos[tNumber][0] += movementX;
			tPos[tNumber][1] += movementY;
			return tPos;
		}
		return tPos;
	}
}
