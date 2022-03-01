package Topological;

import java.util.Arrays;
import java.util.LinkedList;

public class test {


    private int v; // // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public test(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    //     public boolean add(E var1) {
    //        this.linkLast(var1);
    //        return true;
    //    }
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }


    public static void main(String[] args) {
        test test = new test(10);
        test.addEdge(1,3);
        Arrays.stream(test.adj).toArray().toString();
    }
}
