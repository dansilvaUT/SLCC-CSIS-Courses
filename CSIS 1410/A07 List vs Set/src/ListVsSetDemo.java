import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListVsSetDemo {
	
	private List<ColoredSquare> list;
	private Set<ColoredSquare> set;
	
	public ListVsSetDemo(ColoredSquare... elements) {
		this.list = new ArrayList<ColoredSquare>();
		this.set = new HashSet<ColoredSquare>();
		
	}
	
	public String getListElements() {
		StringBuilder sb = new StringBuilder();
		for(ColoredSquare cs : list) {
			sb.append(cs);
		}
		return sb.toString();
	}
	
	public String getSetElements() {
		StringBuilder sb = new StringBuilder();
		for(ColoredSquare st : set) {
			sb.append(st);
		}
		return sb.toString();
	}
	
	public void addElement(ColoredSquare el) {
		list.add(el);
		set.add(el);
	}

}
