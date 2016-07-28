Lintcode 431 - Find the Connected Component in the Undirected Graph.java

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nodes == null || nodes.size() == 0) {
            return result;
        }
        
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        for(UndirectedGraphNode node : nodes) {
            visited.put(node, false);
        }
        
        for(UndirectedGraphNode node : nodes) {
            if(!visited.get(node)) {
                //node没访问过
                bfs(visited, node, result);
            } else {
                visited.put(node, true);
            }
        }
        
        return result;
    }
    
    
    // 还是BFS，当Q为空时，说明这个Group钟相连的node已经全部走过，返回Arraylist<Node>(set)
    public void bfs (HashMap visited, UndirectedGraphNode node, List<List<Integer>> result) {
        Queue<UndirectedGraphNode> Q = new LinkedList<UndirectedGraphNode>();
        
        Q.offer(node);
        visited.put(node, true);
        List<Integer> group = new ArrayList<>();
        while(!Q.isEmpty()) {
            UndirectedGraphNode curr = Q.poll();
            group.add(curr.label);
            for(UndirectedGraphNode nb : curr.neighbors) {
                if(visited.get(nb) == false) {
                    Q.offer(nb);
                    visited.put(nb, true);
                }
            }
        }
        
        Collections.sort(group);
        result.add(group);
        
    }
}