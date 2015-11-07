Leetcode 267 - Palindrome Permutation 2.java

public class Solution {

    public static void main(String[] args){
        List<String> res = new ArrayList<String>();
        res = generatePalindromes("abberea");
        System.out.println(res);

        res = generatePalindromes("aaa");
        System.out.println(res);
    }


    public static List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        
        //记录每个char出现的长度
        int[] countRecord = new int[128];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            countRecord[c]++;
        }

        //取单边的char，比如input string 是 “abcba”， charSet记录“ab”
        StringBuffer charSet = new StringBuffer();
        //记录“c”
        String singleChar = "";

        for(int i=0; i<countRecord.length; i++){
            int count = countRecord[i];
            if(count % 2 == 1){
                singleChar += (char)(i);
                count--;
                if(singleChar.length() > 1){ //检查奇数次出现的char是不是只有一个
                    return res;
                }
            }
            while(count>0){
                charSet.append((char)(i));
                count-=2;
            }
        }
        
        //047 Permutations 2的解法
        boolean[] used = new boolean[charSet.length()];
        StringBuffer item = new StringBuffer();
        buildPalindrome(charSet, used, item, res, singleChar);
      
        return res;
    }
    
    public static void buildPalindrome(StringBuffer charSet, boolean[] used, StringBuffer item, List<String> res, String singleChar){
        if(item.length() == charSet.length()) {
            StringBuffer item2 = new StringBuffer(item).reverse();
            res.add(item.toString() + singleChar + item2.toString());
            return;
        }
        for(int i=0; i<charSet.length(); i++){
            if(i>0 && !used[i-1] && charSet.charAt(i) == charSet.charAt(i-1)) continue;
            if(!used[i]){
                used[i] = true;
                item.append(charSet.charAt(i));
                buildPalindrome(charSet, used, item, res, singleChar);
                item.setLength(item.length()-1);
                used[i] = false;
            }
        }
    }
}