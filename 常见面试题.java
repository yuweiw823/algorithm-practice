

//0 - BinarySearch template

public class Solution {
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}


//1. 约瑟夫环
// 约瑟夫环（约瑟夫问题）是一个数学的应用问题：已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围，从编号为k的人开始报数，数到m的那个人出列；他的下一个人又从1开始报数，数到m的那个人又出列；依此规律重复下去，直到圆桌周围的人只有一个没有出列。假设n=1000,k=5,m=13,问剩下最后一个人编号。
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.Joseoh(6, 3);
        System.out.println(result);
    }
    
    public int Joseoh (int totalNum, int divisor){ 
        //Build the loop
        ListNode head = new ListNode(1);
        ListNode p = head;
        
        if(totalNum <= 1) {
            return 1;
        }
        
        for(int i = 2; i <= totalNum; i++) {
            ListNode newNode = new ListNode(i);
            p.next = newNode;
            p = p.next;
        }
        p.next = head;
        
        //Go loop
        while(p.next != p) {
            for(int i = 1; i < divisor; i++) {
                p = p.next;
            }
            p.next = p.next.next;
        }
        
        return p.val;
    }
};

//2. replace space with %20 in place
//http://www.cnblogs.com/grandyang/p/4650780.html
//C++由于可以resize string，因此可以做到in-place替换

class Solution {
public:
    void replaceSpaces(string &s) {
        int count = 0, len = s.size(), newLen = 0;
        for (int i = 0; i < len; ++i) {
            if (s[i] == ' ') ++count;
        }
        //计算空格的个数，确定resize的大小
        newLen = len + 2 * count;
        s.resize(newLen);
        for (int i = len - 1; i >= 0; --i) {
            if (s[i] == ' ') {
                s[newLen - 1] = '0';
                s[newLen - 2] = '2';
                s[newLen - 3] = '%';
                newLen -= 3;
            } else {
                s[newLen - 1] = s[i];
                newLen -= 1;
            }   
        }
    }
};

//3. Count and Say 字母版
// 可以开一个hashmap或者int[] 计数
// 如果是sorted可以：
"aaabcddde" -> "a3b1c1d3e1"
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.countChar("aaabcddde");
        
        System.out.println(result);
    }
    
    public String countChar(String str) {
        if(str == null || str.length() == 0) {
            return "";
        }
        
        int len = str.length();
        StringBuffer result = new StringBuffer();
        
        for(int i = 0; i < len; i++) {
            int p = i;
            char c = str.charAt(i);
            while(p < len && c == str.charAt(p)) {
                p++;
            }

            int count = p - i;
            result.append(c).append(count);
            i = p - 1;
        }
        
        return result.toString();
    }
};




