Lintcode 136 - Palindrome Partitioning.java

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        
        if(s == null || s.length() == 0) {
            return result;
        }
        
        dfs(result, list, s, 0);
        return result;
    }
    
    
    //和单序列动态规划一样，插（length+1）个pos
    public void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> list, String s, int pos) {
        if(pos == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if(!isPalindrome(prefix)) {
                continue;
            }
            
            list.add(prefix);
            dfs(result, list, s, i);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPalindrome(String subString) {
        int left = 0;
        int right = subString.length() - 1;
        
        while(left < right) {
            if(subString.charAt(left) != subString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}