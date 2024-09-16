import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day08 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day08.txt");
		Scanner scan = new Scanner(file);

		int size = 99;

		int[][] trees = new int[size][size];

		for (int i = 0; i < size; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < size; j++) {
				trees[i][j] = Integer.parseInt("" + line.charAt(j));
			}

		}
		scan.close();

		boolean[][] visible = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			int highestTree = -1;
			for (int j = 0; j < size; j++) {
				if (trees[i][j] > highestTree) {
					visible[i][j] = true;
					highestTree = trees[i][j];
				}
			}
		}
		for (int j = 0; j < size; j++) {
			int highestTree = -1;
			for (int i = 0; i < size; i++) {
				if (trees[i][j] > highestTree) {
					visible[i][j] = true;
					highestTree = trees[i][j];
				}
			}
		}
		for (int i = 0; i < size; i++) {
			int highestTree = -1;
			for (int j = size - 1; j >= 0; j--) {
				if (trees[i][j] > highestTree) {
					visible[i][j] = true;
					highestTree = trees[i][j];
				}
			}
		}
		for (int j = 0; j < size; j++) {
			int highestTree = -1;
			for (int i = size - 1; i >= 0; i--) {
				if (trees[i][j] > highestTree) {
					visible[i][j] = true;
					highestTree = trees[i][j];
				}
			}
		}

		int visiblePart1 = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				visiblePart1 += visible[i][j] ? 1 : 0;
			}
		}
		System.out.println("Lösung Teil 1: " + visiblePart1);

		int[][] scenics = getScenicScores(trees);
		int sceneMax = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sceneMax = Math.max(scenics[i][j], sceneMax);
			}
		}
		System.out.println("Lösung Teil 2: " + sceneMax);

	}

	public static int[][] getScenicScores(int[][] trees) {
		int[][] scene = new int[trees.length][trees.length];
		for (int i = 0; i < trees.length; i++) {
			for (int j = 0; j < trees.length; j++) {
				scene[i][j] = getScenicScore(trees, i, j);
			}
		}
		return scene;
	}

	public static int getScenicScore(int[][] trees, int i, int j) {
		int step = 1;
		int scenicRight = 0;
		while (true) {
			try {
				if (trees[i + step][j] >= trees[i][j]) {
					scenicRight += step;
					break;
				} else {
					step++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				scenicRight += step - 1;
				break;
			}
		}

		step = 1;
		int scenicLeft = 0;
		while (true) {
			try {
				if (trees[i - step][j] >= trees[i][j]) {
					scenicLeft += step;
					break;
				} else {
					step++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				scenicLeft += step - 1;
				break;
			}
		}

		step = 1;
		int scenicTop = 0;
		while (true) {
			try {
				if (trees[i][j + step] >= trees[i][j]) {
					scenicTop += step;
					break;
				} else {
					step++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				scenicTop += step - 1;
				break;
			}
		}

		step = 1;
		int scenicBottom = 0;
		while (true) {
			try {
				if (trees[i][j - step] >= trees[i][j]) {
					scenicBottom += step;
					break;
				} else {
					step++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				scenicBottom += step - 1;
				break;
			}
		}

		return scenicLeft * scenicRight * scenicTop * scenicBottom;
	}

}
