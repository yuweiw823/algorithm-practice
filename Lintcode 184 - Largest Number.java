Lintcode 184 - Largest Number.java

//@Override
class NewComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
}

public class Solution {
    public String largestNumber(int[] num) {
        String[] numStr = new String[num.length];
        for(int i = 0; i < num.length; i++) {
            numStr[i] = Integer.toString(num[i]);
        }
        
        Arrays.sort(numStr, new NewComparator());
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < numStr.length; i++) {
            sb.append(numStr[i]);
        }
        String result = sb.toString();
        
        //检查0
        int index = 0;
        while(index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if(index == result.length()) {
            return "0";
        } else {
            return result.substring(index, result.length());
        }
    }
}