Lintcode 171 - Anagrams.java

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0) {
            return result;
        }
        
        HashMap<Integer, ArrayList<String>> anagramMap = new HashMap<Integer, ArrayList<String>>();
        
        for(String str : strs) {
            int hash = getHash(str);
            if(!anagramMap.containsKey(hash)) {
                anagramMap.put(hash, new ArrayList<String>());
            }
            anagramMap.get(hash).add(str); //ArrayList 只是一个refrence，不直接存储在map中，所以直接get到refernce即可
        }
        
        for(ArrayList<String> eachHash : anagramMap.values()) { //.values()
            if(eachHash.size() > 1) {
                result.addAll(eachHash); //.addAll()
            }
        }
        
        return result;
        
    }
    
    private int getHash(String str) {
        char[] chars = str.toCharArray();
        int count[] = new int[26];
        for(char c : chars) {
            count[c - 'a'] ++;
        }
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for(int num : count) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
        
    }
    
    
}