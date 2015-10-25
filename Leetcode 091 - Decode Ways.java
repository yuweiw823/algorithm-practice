这种方法提供了一个思路，但从前往后扫不是一个很好的方法=L=

public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.equals("0")) return 0;
        int num_2 = 0;
        int num_1 = 1;
        int num_0 = 1;
        for(int i=1; i<s.length(); i++){
            int pre = s.charAt(i-1) - '0';
            int cur = s.charAt(i) - '0';
            if(cur==0){
                if(pre==1 || pre==2) num_0 = num_2;
                else return 0;
            } else {
                if(pre==0 || pre>=3) num_0 = num_1;
                else {
                    if(pre == 2 && cur >= 7 && cur <= 9) num_0 = num_1;
                    else num_0 = num_1 + num_2;
                }
            }
            num_2 = num_1;
            num_1 = num_0;
            
        }
        return num_1;
    }
}

所有的数字能够分成4类
(i-1) i
00,30,40,...90 不能decode
01~09,27~99()        只能从i-1出发decode，res[i] = res[i-1] [i-2]和[i-1]组成一个两位数，[i]作为个位数出现
10,20                只能从i-2出发decode，res[i] = res[i-2]
11~19, 21~26         i-1, i-2出发都能decode, res[i] = res[i-1] + res[i-2]
