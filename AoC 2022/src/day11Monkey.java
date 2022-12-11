import java.util.List;
import java.util.ArrayList;

public class day11Monkey {
	int monkeyNr;
	List<Long> items;
	List<Long> items2;
	int test;
	int ifTrue;
	int ifFalse;
	int itemsinspected;
	int itemsinspected2;
	
	public day11Monkey(int monkeyNr, int test, int ifTrue, int ifFalse) {
		this.test = test;
		this.ifTrue = ifTrue;
		this.ifFalse = ifFalse;
		items = new ArrayList<Long>();
		items2 = new ArrayList<Long>();
		this.monkeyNr = monkeyNr;
		this.itemsinspected = 0;
		this.itemsinspected2 = 0;
	}
	
	public void addItem(long number) {
		this.items.add((long) number);
	}
	
	public void addItem2(long number) {
		this.items2.add((long) number);
	}
	
}
