import java.util.ArrayList;

public class day07Node {
	long bottomupsize;
	ArrayList<day07File> files;
	String name;
	day07Node parent;
	ArrayList<day07Node> childs;
	
	public day07Node(String name, day07Node parent) {
		this.name = name;
		this.parent = parent;
		files = new ArrayList<day07File>();
		childs = new ArrayList<day07Node>();
	}
	
	public void addChild(String name, day07Node parent) {
		day07Node child = new day07Node(name, parent);
		parent.childs.add(child);
	}
	
	public void addFile(String name, int size, day07Node dir) {
		day07File file = new day07File(name, size);
		dir.files.add(file);
	}
}
