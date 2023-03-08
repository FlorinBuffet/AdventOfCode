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
		scan.nextLine();

		day07Node root = new day07Node("/", null);
		day07Node workNode = root;

		boolean statusLS = false; // 0 = none, 1 = ls

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (line.charAt(0) == '$') {
				statusLS = false;
				String command = line.substring(2, 4);
				if (command.equals("ls")) {
					statusLS = true;
				} else if (command.equals("cd")) {
					workNode = cdRunner(workNode, root, line.substring(5, line.length()));
				}
			} else if (statusLS) {
				if (line.substring(0, 3).equals("dir")) {
					workNode.addChild(line.substring(4, line.length()), workNode);
				} else {
					int number = Integer.parseInt(line.substring(0, line.indexOf(" ")));
					String name = line.substring(line.indexOf(" ") + 1, line.length());
					workNode.addFile(name, number, workNode);
				}
			}

		}
		scan.close();
<<<<<<< HEAD
		
		System.out.println("Resultat Teil 1: "+ getResults(root));
		System.out.println("TEST");
=======

		System.out.println("Resultat Teil 1: " + getResultsPart1(root));

		int totalSpace = 70000000;
		int spaceNeeded = 30000000;
		int minSpaceToDelete = spaceNeeded - (totalSpace - root.bottomupsize);

		System.out.println("Resultat Teil 2: " + getResultsPart2(root, minSpaceToDelete));

>>>>>>> branch 'main' of https://github.com/FlorinBuffet/AdventOfCode
	}

	public static day07Node cdRunner(day07Node workNode, day07Node root, String todo) {
		if (todo.equals("..")) {
			return workNode = workNode.parent;
		} else if (todo.equals("/")) {
			return root;
		} else {
			for (day07Node current : workNode.childs) {
				if (current.name.equals(todo)) {
					return current;
				}
			}
		}
		return root;
	}

<<<<<<< HEAD
	public static long getResults(day07Node root) {		
		long result = 0;
		long resultPart1 = 0;
=======
	public static long getResultsPart1(day07Node root) {
		int result = 0;
		int resultPart1 = 0;
>>>>>>> branch 'main' of https://github.com/FlorinBuffet/AdventOfCode
		for (day07Node current : root.childs) {
			resultPart1 += getResultsPart1(current);
			result += current.bottomupsize;
		}
		for (day07File current : root.files) {
			result += current.size;
		}
		root.bottomupsize = result;

		if (result <= 100000)
			resultPart1 += result;
		return resultPart1;
	}

	public static int getResultsPart2(day07Node root, int minSpaceToDelete) {
		int spaceToDelete = root.bottomupsize;
		for (day07Node current : root.childs) {
			int tmp = getResultsPart2(current, minSpaceToDelete);
			if ((tmp >= minSpaceToDelete) && (tmp < spaceToDelete))
				spaceToDelete = tmp;
		}
		return spaceToDelete;
	}
}