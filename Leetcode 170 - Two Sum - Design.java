//LeetCode 170


//Solution 1 - BinarySearch - TODO
class Solution {
    public static void main(String[] args) {
        int[] input = {2, 4, 6, 8, 10};
        int addon = 3;
        int target = 6;
      
        int addon_pos = addonPosition(input, 0, input.length-1, addon);
        boolean if_exist = find(input, 0, input.length-1, target);
        
        System.out.println(addon_pos + " ");
        System.out.println(target + " exists is " + if_exist);
    }
    
    public static boolean find (int[] A, int start, int end, int key) {
        int L = start;
        int R = end;
        
        while (L < R){
            int M = (L + R) / 2;
            if (A[M] < key) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L==R && A[L] == key) ? true : false;
    }

    //TODO: 仅仅实现了找到插入位置的功能，还未实现插入
    public static int addonPosition (int[] A, int start, int end, int key){
        int L = start;
        int R = end;
        
        while(L < R-1){
            int M = L + (R-L)/2;
            if(A[M] < key) {
                L = M;
            } else {
                R = M;
            }
        }
        return L;
    }
}

//Solution 2 - Hashmap
//注意：这里的HashMap 方法，仅返回 boolean， 因此 <K, V> 中的 V 记录 K 出现的总的次数，而不是 index ；

class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = {2, 4, 6, 8, 10};
        int addon = 5;
        int target = 18;
      
        for(int i=0; i<nums.length; i++){
            // 如果已有，则 V + 1；
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            map.put(nums[i], 1);
        };
      
        add(addon, map);
        System.out.println(addon + " is added");
      
        boolean if_two_sum = find(target, map);
        System.out.println("2 nums added to " + target + " is " + if_two_sum);
    }
  
    public static void add(int addon, Map<Integer, Integer> map) {
        int count = map.containsKey(addon) ? map.get(addon) : 0;
        map.put(addon, count + 1);
    }
    
    public static boolean find (int target, Map<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            //针对有重复的情况
            if(target - entry.getKey() == entry.getKey()){
                if(entry.getValue() >= 2) return true;
            } else if(map.containsKey(target - entry.getKey())){
                return true;
            }
        }
        return false;
    }
}
