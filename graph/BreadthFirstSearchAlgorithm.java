package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchAlgorithm {


    private LinkedList<Integer>[] adj;
    private int V;  //number of vertices
    private int E;  //number of edges in graph

    public BreadthFirstSearchAlgorithm(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];

        for (int v= 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public void bfs(int s){
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + " ");

            for (int v : adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearchAlgorithm graph = new BreadthFirstSearchAlgorithm(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(2,4);

        graph.bfs(0);

    }
}
