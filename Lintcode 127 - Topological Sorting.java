Lintcode 127 - Topological Sorting.java

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        
        //构建HashMap，记录所有的node及入度(即有几条边指向它)
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        
        //这里注意，不是把所有的点加入HashMap，而是把它所有的neighbor加入
        for(DirectedGraphNode node: graph) {
            for(DirectedGraphNode nb : node.neighbors) {
                if(!map.containsKey(nb)) {
                    map.put(nb, 1);
                } else {
                    map.put(nb, map.get(nb) + 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> Q = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node: graph) {
            //找到入度为0的点，第一个加入result
            if(!map.containsKey(node)) {
                result.add(node);
                Q.offer(node);
            }
        }
        
        while(!Q.isEmpty()) {
            DirectedGraphNode curr = Q.poll(); //这时，Q中所有的点的入度都是 0
            for(DirectedGraphNode nb : curr.neighbors) {
                map.put(nb, map.get(nb) - 1); //注意，所有的点得入度都需要 -1
                if(map.get(nb) == 0) {
                    Q.offer(nb);
                    result.add(nb);
                }
            }
        }
        
        return result;
    }
}