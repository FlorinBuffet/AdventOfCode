import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day15 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day15.txt");
		Scanner scan = new Scanner(file);

		char[] fieldPart1 = new char[10000000];
		int[][] inputs = new int[50][5];
		int part2MaxValues = 4000000; //20 for Test and 4000000 for Live

		int runner = 0;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			int sensorX = Integer.parseInt(line.substring(line.indexOf('=')+1,line.indexOf(',')));
			int sensorY = Integer.parseInt(line.substring(line.indexOf(',')+4,line.indexOf(':')));
			line = line.substring(line.indexOf(':')+2);
			int beaconX = Integer.parseInt(line.substring(line.indexOf('=')+1,line.indexOf(',')));
			int beaconY = Integer.parseInt(line.substring(line.indexOf(',')+4));
			inputs[runner][0] = sensorX;
			inputs[runner][1] = sensorY;
			inputs[runner][2] = beaconX;
			inputs[runner][3] = beaconY;
			inputs[runner][4] = Math.abs(sensorX - beaconX) + Math.abs(sensorY - beaconY);
			runner++;
			
			processLine(fieldPart1,sensorX+5000000,sensorY,beaconX+5000000,beaconY);
		}
		scan.close();
		
		int notEmpty = 0;
		for (int i = 0; i<fieldPart1.length; i++) {
			if (fieldPart1[i] == 'S' || fieldPart1[i] == '#')
				notEmpty++;
		}
		System.out.println("Teillösung 1: " + notEmpty);
		
		for (long i = part2MaxValues; i>=0; i--) {
			if (i%100==0) {
				System.out.println("Y:"+i);
			}
			int result = processArray(inputs, part2MaxValues, (int)i);
			if (result >= 0) {
					System.out.println("Teillösung 2: Y: " + i + "  X: "+result+"  RESULT: "+((result*4000000)+i));
					break;
			}
		}
		
	}
	
	public static void processLine(char[] fieldPart1, int sensorX, int sensorY, int beaconX, int beaconY) {
		int distX = Math.abs(sensorX - beaconX);
		int distY = Math.abs(sensorY - beaconY);
		int dist = distX + distY;
		
		int resultY = 2000000; //10 for Test and 2000000 for Live
		
		for (int i = 0; i<fieldPart1.length; i++) {
			int tmpDist = Math.abs(sensorX - i) + Math.abs(sensorY - resultY);
			if (tmpDist <= dist) {
				fieldPart1[i] = '#';
			}
			if (sensorY == resultY && i == sensorX) {
				fieldPart1[i] = 'S';
			}else if (beaconY == resultY && i == beaconX) {
				fieldPart1[i] = 'B';
			}
		}
		
	}

	public static int processArray(int[][] inputs, int maxValues, int yValue) {		
		for (int j = 0; j<maxValues; j++) {
			for (int i = 0; i<inputs.length; i++) {				
				if (Math.abs(inputs[i][0] - j) + Math.abs(inputs[i][1] - yValue) <= inputs[i][4]) {
					break;
				}else if (i < inputs.length-1) {
					continue;
				}
				return j;
			}
		}
		return -1;
	}
}
