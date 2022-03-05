package ShortestPath;

import java.util.LinkedList;

public class Graph {
    private LinkedList<Edge> adj[];
    private int v;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<Edge>();
        }
    }

    public void addEdge(int s, int t, int w) {
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    private class Vertes {
        public int id;
        public int dist;
        public Vertes(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}
