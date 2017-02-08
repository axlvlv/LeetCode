/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Notice

You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
/*

/*
Method
Union find : http://blog.csdn.net/dm_vincent/article/details/7655764
给出两个节点，判断它们是否连通，如果连通，不需要给出具体的路径: Union find
给出两个节点，判断它们是否连通，如果连通，需要给出具体的路径: DFS

随着Pair的输入，我们需要首先判断输入的两个节点是否连通。如何判断呢？
按照上面的假设，我们可以通过判断它们属于的组，然后看看这两个组是否相同，如果相同，那么这两个节点连通，反之不连通。
为简单起见，我们将所有的节点以整数表示，即对N个节点使用0到N-1的整数表示。
而在处理输入的Pair之前，每个节点必然都是孤立的，即他们分属于不同的组，可以使用数组来表示这一层关系，数组的index是节点的整数表示，
而相应的值就是该节点的组号了。该数组可以初始化为：

for(int i = 0; i < size; i++)  
    id[i] = i;    
    
即对于节点i，它的组号也是i。
 
初始化完毕之后，对该动态连通图有几种可能的操作：
查询节点属于的组
数组对应位置的值即为组号
判断两个节点是否属于同一个组
分别得到两个节点的组号，然后判断组号是否相等
连接两个节点，使之属于同一个组
分别得到两个节点的组号，组号相同时操作结束，不同时，将其中的一个节点的组号换成另一个节点的组号
获取组的数目
初始化为节点的数目，然后每次成功连接两个节点之后，递减1



判断输入的边是否能构成一个树，我们需要确定两件事：

这些边是否构成环路，如果有环则不能构成树
这些边是否能将所有节点连通，如果有不能连通的节点则不能构成树
因为不需要知道具体的树长什么样子，只要知道连通的关系，所以并查集相比深度优先搜索是更好的方法。我们定义一个并查集的数据结构，并提供标准的四个接口：

union 将两个节点放入一个集合中
find 找到该节点所属的集合编号
areConnected 判断两个节点是否是一个集合
count 返回该并查集中有多少个独立的集合

就是先构建一个数组，节点0到节点n-1，刚开始都各自独立的属于自己的集合。这时集合的编号是节点号。
然后，每次union操作时，我们把整个并查集中，所有和第一个节点所属集合号相同的节点的集合号，都改成第二个节点的集合号。
这样就将一个集合的节点归属到同一个集合号下了。我们遍历一遍输入，把所有边加入我们的并查集中，加的同时判断是否有环路。
最后如果并查集中只有一个集合，则说明可以构建树。

因为要判断是否会产生环路，union方法要返回一个boolean，如果两个节点本来就在一个集合中，就返回假，说明有环路

/*

/*
Basic Java

/*

    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        UnionFind uf = new UnionFind(n);   
        for(int i = 0; i < edges.length; i++){   //edges 其实是一个矩阵  // 如果两个节点已经在同一集合中，说明新的边将产生环路
            if(!uf.union(edges[i][0], edges[i][1])){  //如果还需要你去链接，说明是false的，如果都不需要你连接了，returfalse;
                return false;
            }
        }
        return uf.count() == 1;
    }
    
    public class UnionFind{
        int[] id;
        int count;
        
        public UnionFind(int size){
            this.id = new int[size];
             //初始化并查集，每个节点对应自己的集合号
            for(int i = 0; i < this.id.length; i++){
                this.id[i] = i;
            }
            this.count = size;
        }
        
        public boolean union(int m, int n){
            int mparent = find(m);
            int nparent = find(n);
            //如果两个节点不在同一集合中，将两个集合合并为一个
            if(mparent != nparent){
                for(int i = 0; i < id.length; i++){
                    if(id[i] == mparent){
                        id[i] = nparent;
                    }
                }
                // 合并完集合后，集合数减一
                count --;
                return true;
            }
            return false;
            
            
        }
        
        public int find(int m){
            return id[m];
        }
        
        public boolean isConnected(int m, int n){
            return find(m) == find(n);
        }
        
        public int count(){
            return count;
        }
    }
}

