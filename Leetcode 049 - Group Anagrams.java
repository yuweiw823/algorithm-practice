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
  
  
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
      
        String key;
        List<String> eachGroup;
      
        for(String s:strs){
            key = sortToKey(s);
            if(!map.containsKey(key)){
                eachGroup = new ArrayList<String>();
                eachGroup.add(s);
                map.put(key, eachGroup);
            } else {
                eachGroup = map.get(key);
                eachGroup.add(s);
                map.put(key, eachGroup);
            }
        }
        for(List<String> addEachGroup : map.values()){
            if(addEachGroup.size()>0){
                Collections.sort(eachGroup);
                res.add(addEachGroup);
                
            }
        }
        return res;
    }
    
    public static String sortToKey(String strs){
        char[] c = strs.toCharArray();
        Arrays.sort(c);
        return Arrays.toString(c);
    }
}