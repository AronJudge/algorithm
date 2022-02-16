package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    // undirected graph
    private int v; // number of vertices
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * bfs() 函数就是基于之前定义的，图的广度优先搜索的代码实现。
     * 其中 s 表示起始顶点，t 表示终止顶点。我们搜索一条从 s 到 t 的路径。
     * 实际上，这样求得的路径就是从 s 到 t 的最短路径。O(V+E)，
     * 其中，V 表示顶点的个数，E 表示边的个数。当然，对于一个连通图来说，
     * 也就是说一个图中的所有顶点都是连通的，E 肯定要大于等于 V-1，所以，
     * 广度优先搜索的时间复杂度也可以简写为 O(E)。
     * 广度优先搜索的空间消耗主要在几个辅助变量 visited 数组、queue 队列、prev 数组上。
     * 这三个存储空间的大小都不会超过顶点的个数，所以空间复杂度是 O(V)
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        // visited 是用来记录已经被访问的顶点，用来避免顶点被重复访问。
        // 如果顶点 q 被访问，那相应的 visited[q]会被设置为 true。
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // queue 是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        // 因为广度优先搜索是逐层访问的
        // 我们只有把第 k 层的顶点都访问完成之后，才能访问第 k+1 层的顶点。
        // 当我们访问到第 k 层的顶点的时候，我们需要把第 k 层的顶点记录下来，
        // 稍后才能通过第 k 层的顶点来找第 k+1 层的顶点。所以，我们用这个队列来实现记录的功能。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev 用来记录搜索路径，我们从顶点 s 开始，广度优先搜索到顶点 t 后，prev 数组中存储的就是搜索的路径。
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev,s,t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
    * 深度优先搜索用的是一种比较著名的算法思想，
    * 回溯思想
     * 假设你站在迷宫中的某个岔路口，然后想找到出口。你随意选择一个岔路口来走，走着走着发现走不通的时候，
     * 你就回退到上一个岔路口，重新选择一条路继续走，直到最终找到出口。这种走法就是一种深度优先搜索策略。
    */

    boolean found = false; // 全局变量或者类成员变量
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


}
