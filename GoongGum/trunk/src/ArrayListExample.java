import java.util.*;

public class ArrayListExample {
public static void main(String[] args) {
	
	List<String> list = new ArrayList<String>();
	
	list.add("hana");
	list.add("둘");
	list.add("set");
	list.add(0, "영");
	list.add("홍홍");
	
	
	int size = list.size();
	
	String name = list.get(0);
	
	System.out.println(name + size);
	
	for(int i = 0 ; i<list.size(); i ++){
		
		String str = list.get(i);
		System.out.println(str);
	}
	
	
	
	
}
}
