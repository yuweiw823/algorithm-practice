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
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s:strs){
            String key = sortToKey(s);
            List<String> eachGroup;
            if(map.containsKey(key)){
                eachGroup = map.get(key);
                eachGroup.add(s);
                map.put(key, eachGroup);
            } else {
                eachGroup = new ArrayList<String>();
                eachGroup.add(s);
                map.put(key, eachGroup);
            }
        }
        for(List<String> eachGroup : map.values()){
            if(eachGroup.size()>0){
                Collections.sort(eachGroup);
                res.add(eachGroup);
            }
        }
        return res;
    }
    
    public String sortToKey(String strs){
        char[] c = strs.toCharArray();
        Arrays.sort(c);
        return Arrays.toString(c);  //注意Arrays.toString(_value)
    }
}