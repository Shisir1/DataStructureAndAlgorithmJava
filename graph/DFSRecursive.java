package org.example.graph;

import java.security.PublicKey;
import java.util.LinkedList;

public class DFSRecursive {
    private int V;  //number of vertices
    private LinkedList<Integer> adj[];  //adjacency list

    //contructor
    public DFSRecursive(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i =0; i < v; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);  //add w to v's list
    }

    //A function used by DFS
    public void DFSUtil(int v, boolean visited[]){
        //Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        //Recur for all the vertices adjacent to this vertex
        for(int n : adj[v]){
            if (!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    //The function to do DFS traversal. It used recursive DFSUtil()
    public void DFS(int v){
        //Mark all the vertices as not visited (set as false by default in Java)
        boolean visited[] = new boolean[V];

        //Call the recursive helper function to print DFS traversal
        DFSUtil(v,visited);
    }

    public static void main(String[] args) {
        DFSRecursive graph = new DFSRecursive(5);
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(1,2);
//        graph.addEdge(2,0);
//        graph.addEdge(2,3);
//        graph.addEdge(3,3);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(2,4);
        System.out.println("Following is Depth First Traversal (Starting from vertex 0)");

        graph.DFS(0);

    }
}
