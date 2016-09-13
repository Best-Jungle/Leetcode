import java.util.*;
public class TwoSum{
	public static void main(String[] args){
		int[] a = {0,4,3,0};
		TwoSum num = new TwoSum();
		int[] b = num.Add(a,0);
		for (int i = 0;i<b.length;i++ ) {
			System.out.println(b[i]);
		}
		Map map = new HashMap();
		map.put("疯狂 Java",109);
		map.put("延大106",106);
		for(Object key : map.keySet()){
			System.out.println(key+"-->"+map.get(key));
		}
		System.out.println(map);
	}
	public int[] Add(int[] nums,int target){	
		Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
	}
}