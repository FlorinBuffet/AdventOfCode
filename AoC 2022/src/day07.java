import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day07 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data/day99.txt");
		Scanner scan = new Scanner(file);
		scan.nextLine();

		int currentLine = 1;
		
		day07Node root = new day07Node("/", null);
		day07Node workNode = root;
		
		boolean statusLS = false; //0 = none, 1 = ls
		
		while (scan.hasNextLine()) {
			currentLine++;
			String line = scan.nextLine();
			if (line.charAt(0)=='$') {
				statusLS = false;
				String command = line.substring(2,4);
				if (command.equals("ls")) {
					statusLS = true;
				}else if (command.equals("cd")) {
					workNode = cdRunner(workNode,root,line.substring(5,line.length()));
				}
			}else if (statusLS) {
				if (line.substring(0,3).equals("dir")) {
					workNode.addChild(line.substring(4,line.length()), workNode);
				}else {
					int number = Integer.parseInt(line.substring(0,line.indexOf(" ")));
					String name = line.substring(line.indexOf(" ")+1,line.length());
					workNode.addFile(name, number, workNode);
				}
			}
			
		}
		scan.close();
		System.out.println("TEST");
	}
	
	public static day07Node cdRunner(day07Node workNode, day07Node root, String todo) {
		if (todo.equals(".")){
			workNode = workNode.parent;
		}else if (todo.equals("/")) {
			workNode = root;
		}else {
			for (day07Node current : workNode.childs) {
				if (current.name.equals(todo)) {
					return current;
				}
			}
		}
		return root;
	}

}