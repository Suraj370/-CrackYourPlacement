// A Java program for Bellman-Ford's single source
// shortest path algorithm.
import java.util.*;

class Main {

	// A structure to represent a weighted
	// edge in graph
	static class Edge {
		int src, dest, weight;
	}

	// A structure to represent a connected,
	// directed and weighted graph
	static class Graph {

		// V-> Number of vertices,
		// E-> Number of edges
		int V, E;

		// Graph is represented as
		// an array of edges.
		Edge edge[];
	}

	// Creates a graph with V vertices and E edges
	static Graph createGraph(int V, int E)
	{
		Graph graph = new Graph();
		graph.V = V;
		graph.E = E;
		graph.edge = new Edge[graph.E];

		for (int i = 0; i < graph.E; i++) {
			graph.edge[i] = new Edge();
		}

		return graph;
	}

	// The main function that finds shortest distances
	// from src to all other vertices using Bellman-
	// Ford algorithm. The function also detects
	// negative weight cycle
	static boolean
	isNegCycleBellmanFord(Graph graph, int src, int dist[])
	{
		int V = graph.V;
		int E = graph.E;

		// Step 1: Initialize distances from src
		// to all other vertices as INFINITE
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times.
		// A simple shortest path from src to any
		// other vertex can have at-most |V| - 1
		// edges
		for (int i = 1; i <= V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;

				if (dist[u] != Integer.MAX_VALUE
					&& dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		// Step 3: check for negative-weight cycles.
		// The above step guarantees shortest distances
		// if graph doesn't contain negative weight cycle.
		// If we get a shorter path, then there
		// is a cycle.
		for (int i = 0; i < E; i++) {
			int u = graph.edge[i].src;
			int v = graph.edge[i].dest;
			int weight = graph.edge[i].weight;

			if (dist[u] != Integer.MAX_VALUE
				&& dist[u] + weight < dist[v])
				return true;
		}

		return false;
	}

	// Returns true if given graph has negative weight
	// cycle.
	static boolean isNegCycleDisconnected(Graph graph)
	{
		int V = graph.V;

		// To keep track of visited vertices
		// to avoid recomputations.
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);

		// This array is filled by Bellman-Ford
		int dist[] = new int[V];

		// Call Bellman-Ford for all those vertices
		// that are not visited
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {

				// If cycle found
				if (isNegCycleBellmanFord(graph, i, dist))
					return true;

				// Mark all vertices that are visited
				// in above call.
				for (int j = 0; j < V; j++)
					if (dist[j] != Integer.MAX_VALUE)
						visited[j] = true;
			}
		}
		return false;
	}


}


