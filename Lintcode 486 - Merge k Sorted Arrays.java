Lintcode 486 - Merge k Sorted Arrays.java

class Element {
    public int row, col, val;
    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    // new 了一个 Comparatpr， 并定义了compare 方法
    private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };
        
    public int[] mergekSortedArrays(int[][] arrays) {
        if(arrays == null || arrays.length == 0) {
            return new int[0];
        }
        
        int total_size = 0;
        Queue<Element> Q = new PriorityQueue<Element>(
            arrays.length, ElementComparator
        );
        
        for(int i = 0; i < arrays.length; i++) {
            if(arrays[i].length > 0) {
                Element elem = new Element(i, 0, arrays[i][0]);
                Q.add(elem);
                total_size += arrays[i].length;
            }
        }
        
        int[] result = new int[total_size];
        int index = 0;
        while(!Q.isEmpty()) {
            Element elem = Q.poll();
            result[index++] = elem.val;
            
            if(elem.col < arrays[elem.row].length - 1) {
                Element nextElem = new Element(elem.row, elem.col+1, arrays[elem.row][elem.col+1]);
                Q.add(nextElem);
            }
        } 
        
        return result;
    }
}