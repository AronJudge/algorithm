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
        int a = 1;
        int b = 2;
        if (a == 0) {
            b = adj[2].get(2);
        }
    }


    public static void main(String[] args) {
        test test = new test(10);
        test.addEdge(1,3);
        test.addEdge(1,4);
        test.addEdge(2,3);
        test.addEdge(3,3);
        test.addEdge(4,3);
        test.addEdge(5,3);
        test.addEdge(6,3);
        System.out.println(test.adj[1].get(1));
    }
}
