import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day14 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day14.txt");
		Scanner scan = new Scanner(file);

		char[][] cave = new char[500][1000];
		int highestY = 0;
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			while (line.contains(">")) {
				int sourcex = Integer.parseInt(line.substring(0,line.indexOf(',')));
				int sourcey = Integer.parseInt(line.substring(line.indexOf(',')+1, line.indexOf(' ')));
				line = line.substring(line.indexOf('>')+2);
				int destinationx = Integer.parseInt(line.substring(0,line.indexOf(',')));
				int destinationy = 0;
				try { destinationy = Integer.parseInt(line.substring(line.indexOf(',')+1, line.indexOf(' '))); } catch(StringIndexOutOfBoundsException e) {destinationy = Integer.parseInt(line.substring(line.indexOf(',')+1));}
				
				highestY = Math.max(highestY, Math.max(sourcey, destinationy));
				draw(sourcex,sourcey,destinationx,destinationy,cave);
			}
		}
		scan.close();
		
		boolean sandDropped;
		do {
			sandDropped = dropSand(cave);
			
		} while (sandDropped);
		
		int countO = 0;
		for (int i = 0; i<cave.length; i++) {
			for (int j = 0; j<cave[i].length; j++) {
				if (cave[i][j] == 'o')
					countO++;
			}
		}
		
		System.out.println("Teillösung 1: " + countO);
		
		for (int j = 0; j<cave[highestY+2].length; j++) {
			cave[highestY+2][j] = '#';
		}
		
		do {
			sandDropped = dropSand(cave);
			
		} while (sandDropped);
		
		countO = 0;
		for (int i = 0; i<cave.length; i++) {
			for (int j = 0; j<cave[i].length; j++) {
				if (cave[i][j] == 'o')
					countO++;
			}
		}
		
		System.out.println("Teillösung 2: " + countO);
	}
	
	public static void draw(int sourceX, int sourceY, int destinationX, int destinationY, char[][] cave) {
		if (sourceX == destinationX) {
			int minY = Math.min(sourceY, destinationY);
			int maxY = Math.max(sourceY, destinationY);
			for (int i = minY; i<=maxY; i++) {
				cave[i][sourceX] = '#';
			}
		}else{
			int minX = Math.min(sourceX, destinationX);
			int maxX = Math.max(sourceX, destinationX);
			for (int i = minX; i<=maxX; i++) {
				cave[sourceY][i] = '#';
			}
		}
	}

	public static boolean dropSand(char[][] cave) {
		int newX = 500;
		int newY = 0;
		
		while (true) {
			if (newY >= 499) {
				return false;
			} else if (cave[newY+1][newX] == '\u0000') {
				newY++;
			}else if(cave[newY+1][newX-1] == '\u0000') {
				newY++;
				newX--;
			}else if(cave[newY+1][newX+1] == '\u0000') {
				newY++;
				newX++;
			}else{
				cave[newY][newX] = 'o';
				if (newY == 0 && newX == 500) {
					return false;
				}
				return true;
			}
		}
	}
}
