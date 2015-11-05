//Leetcode 049 - Group Anagrams.java
//纯字符串处理。但有几个细节需要注意
//Arrays.toString(_value);
//Collections.sort(_value);


public class Solution {
    public static void main(String [] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new ArrayList<List<String>>();
        res = groupAnagrams(strs);
        System.out.print(res);
    }
  
  
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0 ) return res;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strs){
            String key = sortToKey(str);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        
        for(List<String> group : map.values()){
            Collections.sort(group);
            res.add(group);
        }
        
        return res;
    }
    
    public String sortToKey(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return Arrays.toString(c);
    }
}