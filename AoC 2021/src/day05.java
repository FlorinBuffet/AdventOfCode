import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day05 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day05.txt");
		Scanner scan = new Scanner(file);

		int[][] field = new int[1000][1000];
		int[][] field2 = new int[1000][1000];
		
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			int x1 = Integer.parseInt(line.substring(0, line.indexOf(",")));
			int y1 = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf(" ")));
			int x2 = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1, line.lastIndexOf(",")));
			int y2 = Integer.parseInt(line.substring(line.lastIndexOf(",") + 1, line.length()));

			//System.out.println(line);
			
			if (x1 == x2) {
				int ymin = Math.min(y1, y2);
				int ymax = Math.max(y1, y2);
				for (int i = ymin; i<=ymax; i++) {
					field[x1][i]++;
					field2[x1][i]++;
				}
			}else if (y1 == y2) {
				int xmin = Math.min(x1, x2);
				int xmax = Math.max(x1, x2);
				for (int i = xmin; i<=xmax; i++) {
					field[i][y1]++;
					field2[i][y1]++;
				}
			} else {
				int xchange = x2-x1>0 ? 1 : -1;
				int ychange = y2-y1>0 ? 1 : -1;
				
				field2[x1][y1]++;
				
				while (x1!=x2) {
					x1+=xchange;
					y1+=ychange;
					field2[x1][y1]++;
				}
			}
			
			for (int i = 0; i<field2.length; i++) {
				for (int j = 0; j<field2[i].length; j++) {
					//System.out.print(field2[j][i]+ " ");
				}
				//System.out.println();
			}
			//System.out.println();
			//System.out.println();
		}
		scan.close();
		
		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i<field.length; i++) {
			for (int j = 0; j<field[i].length; j++) {
				if (field[i][j]>1){
					result1++;
				}
				if (field2[i][j]>1) {
					result2++;
				}
			}
		}
		System.out.println("Lösung Teil 1: "+result1);
		System.out.println("Lösung Teil 2: "+result2);
	}

}
