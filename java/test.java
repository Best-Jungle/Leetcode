import java.util.*;
public class test{
	public static void main(String[] args){
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		map.put(1,2);
		map.put(3,4);
		int i = 0;
		Set allSet = map.keySet();
		Iterator iterator = allSet.iterator();
		while(iterator.hasNext()){
			i++;
			
		 	System.out.println(iterator.next());
		 }

		System.out.println(allSet.iterator());
	}
}

	// Map<String,String> map=new HashMap<String,String>();
 //         map.put("Zhukai","is_a_2HUO!");
 //         map.put("LiJunDong","is_a_2HUO_too!");
 //         map.put("WoZiji","is_not_2HUO!");
 //         Set<Map.Entry<String, String>> allSet=map.entrySet();
         
 //         Iterator<Map.Entry<String, String>> iter=allSet.iterator();
 //         while(iter.hasNext()){
 //             Map.Entry<String, String> me=iter.next();
 //             System.out.println(me.getKey()+ " "+me.getValue());
 //         }