Leetcode 187 - Repeated DNA Sequences - Bit.java

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10) return res;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> doubleSet = new HashSet<Integer>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        for(int i=0; i<=s.length()-10; i++){
            int k = map[s.charAt(i) - 'A'];
            for(int j=i+1; j<i+10; j++){
                k <<= 2;
                k |= map[s.charAt(j) - 'A'];
            }
            if(set.contains(k) && !doubleSet.contains(k)){
                doubleSet.add(k);
                res.add(s.substring(i, i+10));
            } else {
                set.add(k);
            }
        }
        return res;
    }
}

// 以 AACTG 为例
// k = 0

// k <<= 2, k == 0000;
// k |= A,  k == 0000;

// k <<= 2, k == 000000;
// k |= C,  k == 000001;

// k <<= 2, k == 00000100;
// k |= T,  k == 00000111;

// k <<= 2, k == 0000011100;
// k |= G,  k == 0000011101;