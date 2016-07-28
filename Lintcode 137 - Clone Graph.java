Lintcode 137 - Clone Graph.java

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    //已经有了所有的点的list。
    //先建立map， old node -> new node
    //从 list 中依次拿出所有点，每拿出一个 old_node0，找到map中对应的 new_node0;
    //每一个old node0的所有neighbor(old_node1, old_node2)，在map中拿出对应的 (new_node1, new_node2)，add 成为 new_node0 的 neightbor
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null) {
            return null;
        }
        
        ArrayList<UndirectedGraphNode> nodeList = getNodes(node);
        
        //old_node -> new_node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for(UndirectedGraphNode old_node : nodeList) {
            UndirectedGraphNode new_node = new UndirectedGraphNode(old_node.label);
            map.put(old_node, new_node);
        }
        
        for(UndirectedGraphNode old_node : nodeList) {
            UndirectedGraphNode new_node = map.get(old_node);
            for(UndirectedGraphNode nb : old_node.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(nb);
                new_node.neighbors.add(newNeighbor);
            }
        }
        
        return map.get(node);
    }

    //首先用BFS的方法取出所有点。BFS常见的使用场景：图的遍历 Graph Traversal
    //当访问一个点时，将它所有的 neighbor 都推入Queue中，
    //访问完毕，再从Queue中取出下一个点
    //用set记录所有访问过的点，以防重复
    public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> Q = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        
        Q.offer(node);
        set.add(node);
        while(!Q.isEmpty()) {
            UndirectedGraphNode curr = Q.poll();
            for(UndirectedGraphNode nb : curr.neighbors) {
                if(!set.contains(nb)) {
                    set.add(nb);
                    Q.offer(nb);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
}