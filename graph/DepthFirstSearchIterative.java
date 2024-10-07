package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchIterative {

    private LinkedList<Integer>[] adj;
    private int V;  //number of vertices
    private int E;  //number of edges in graph

    public DepthFirstSearchIterative(int nodes){
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

    public void dfs(int source){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : adj[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearchIterative graph = new DepthFirstSearchIterative(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(2,4);

        graph.dfs(0);

    }
}
