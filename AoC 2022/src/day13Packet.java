import java.util.ArrayList;
import java.util.List;

public class day13Packet implements Comparable<day13Packet>{
	List<day13Packet> childs;
	int value;
	boolean isInteger = true;
	String str;
	
	public day13Packet(String input) {
		str = input;
		childs = new ArrayList<>();
		if (input.equals("[]"))
			value = -1;
		if (!input.startsWith("["))
			value = Integer.parseInt(input);
		else {
			input = input.substring(1,input.length()-1);
			int level = 0;
			String tmp = "";
			
			for (char c : input.toCharArray()) {
				if (c == ',' && level == 0) {
					childs.add(new day13Packet(tmp));
					tmp = "";
				} else {
					level += (c == '[') ? 1 : (c == ']') ? -1 : 0;
					tmp += c;
				}
			}
			if (!tmp.equals(""))
				childs.add(new day13Packet(tmp));
			isInteger = false;
		}
	}
	
	public int compareTo(day13Packet other) {
		if (isInteger && other.isInteger) {
			return other.value - value;
		}
		if (!isInteger && !other.isInteger) {
			for (int i = 0; i < Math.min(childs.size(), other.childs.size()); i++) {
				int val = childs.get(i).compareTo(other.childs.get(i));
				if (val != 0) {
					return val;
				}
			}
			return other.childs.size() - childs.size();
		}
		day13Packet lst1 = isInteger ? new day13Packet("[" + value + "]") : this;
		day13Packet lst2 = other.isInteger ? new day13Packet("[" + other.value + "]") : other;
		return lst1.compareTo(lst2);
	}
}
