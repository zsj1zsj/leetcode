package algorithms;

import java.util.HashMap;

public class LeetCode26 {
	static public int removeDuplicates(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
        int[] tmp = new int[nums.length];
        int c = 0;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==null){
                map.put(nums[i],nums[i]);
                tmp[c++]=nums[i];
            }
        }
        
        System.out.print("[");
        
        System.out.print("]");

        return map.size();
    }
	
	
	public static void main(String[] args) {
		int [] nums = {1,1,2};
		
		System.out.println(removeDuplicates(nums));
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		
		System.out.println(map.get(3));
	}
}
