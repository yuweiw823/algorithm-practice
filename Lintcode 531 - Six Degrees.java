Lintcode 531 - Six Degrees.java


/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    

    // BFS 的使用场景之一：简单图求最短路径 Shortest Path in Simple Graph
    // 以题中的 example 为例 ：
    // 把 node_1 推入Queue，放入Set
    // 从 Queue中取到node_1, 在它的邻居 node_2, node_3 上均标注 step = 1
    // 把 node_2, node_3 推入 set，放入 queue
    // 从 Queue取到 node_2, node_1已访问过，在node_4上标注 step = 2
    // 把 node_4 推入Queue，放入Set
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if(s == null || t == null) {
            return -1;
        }
        
        if(s == t) {
            return 0;
        }
         
        HashMap<UndirectedGraphNode, Integer> map = new HashMap<UndirectedGraphNode, Integer>();
        Queue<UndirectedGraphNode> Q = new LinkedList<UndirectedGraphNode>();
        
        int step = 0;
        map.put(s, step);
        Q.offer(s);
        
        
        while(!Q.isEmpty()) {
            UndirectedGraphNode curr = Q.poll();
            step = map.get(curr);
            for(UndirectedGraphNode nb : curr.neighbors) {
                if(!map.containsKey(nb)) {
                    if(nb == t) {
                        return step + 1;
                    } else {
                        map.put(nb, step + 1);
                        Q.offer(nb);
                    }
                }
            }
        }
        
        return -1;
        
    }
    
    
}