import java.util.*;


public class HashMapExample {
public static void main(String[] args) {
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	map.put("남궁훤", 100);
	map.put("남궁일", 95);
	map.put("남궁궁", 90);
	map.put("남궁동", 80);
	map.put("남궁구릉구릉궁", 65);
	map.put("쿄쿄", 34);
	
	System.out.println(map.size());
	System.out.println(map.get("남궁훤"));
	
	Set<String> keySet = map.keySet();
	
	System.out.println(keySet);
	
}
}
