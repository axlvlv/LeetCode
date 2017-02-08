/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
/*

/*
Method
The idea is to do a BFS traversal of the graph and while visiting a node make a clone node of it (a copy of original node). 
If a node is encountered which is already visited then it already has a clone node.

How to keep track of the visited/cloned nodes?
A HashMap/Map is required in order to maintain all the nodes which have already been created.
Key stores: Reference/Address of original Node
Value stores: Reference/Address of cloned Node

How to verify if the cloned graph is a correct?
Do a BFS traversal before and after the cloning of graph. 
In BFS traversal display the value of a node along with its address/reference.
Compare the order in which nodes are displayed, 
if the values are same but the address/reference is different for both the traversals than the cloned graph is correct.

/*

/*
Basic Java
queue.add();
queue.poll();
queue.isEmpty();
hashmap.containskey();
Returns:
true if this map contains a mapping for the specified key.

hashmap.put(key,value);
ssociates the specified value with the specified key in this map. 
If the map previously contained a mapping for the key, the old value is replaced.

map.get(cur).neighbors.add(map.get(neighbor));
/*

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap(); // origin node : copied node
        UndirectedGraphNode myNode = new UndirectedGraphNode(node.label); // copy
        
        map.put(node, myNode);
        
        Queue<UndirectedGraphNode> q = new ArrayDeque(); // origin nodes
        q.add(node);
        
        // bfs traverse graph
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            // all neighbors of current origin node
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                // if the origin node is not visited
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    // to avoid loop, we just add the unvisited node to queue
                    q.offer(neighbor);
                }
                // add neighbors to the copied node
                // copied node: map.get(cur) -> copied node of cur
                // neighbors: map.get(neighbor) -> copied node of neighbor
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return myNode;
    }
}
