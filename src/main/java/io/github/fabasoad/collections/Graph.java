package io.github.fabasoad.collections;

import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * https://www.geeksforgeeks.org/iterative-depth-first-traversal/
 */
public class Graph {

  public static void main(String[] args) {
    Graph g = new Graph(5);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.addEdge(4, 3);

    System.out.print("BFS from <2>: [ ");
    g.bfs(2, Graph::print);
    System.out.println("]");

    System.out.print("DFS (recursion) from <2>: [ ");
    g.dfsRecursive(2, Graph::print);
    System.out.println("]");

    System.out.print("DFS (stack vertices) from <2>: [ ");
    g.dfsStackVertices(2, Graph::print);
    System.out.println("]");

    System.out.print("DFS (stack all): [ ");
    g.dfsStackAll(Graph::print);
    System.out.println("]");
  }

  private static void print(int value) {
    System.out.print(value + " ");
  }

  private int v;
  private LinkedList<Integer>[] adj;

  @SuppressWarnings("unchecked")
  Graph(int v) {
    this.v = v;
    adj = (LinkedList<Integer>[]) new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public void bfs(int s, final Consumer<Integer> callback) {
    // Mark all the vertices as not visited(By default
    // set as false)
    final boolean[] visited = new boolean[this.v];

    // Create a queue for BFS
    final LinkedList<Integer> queue = new LinkedList<>();

    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      // Dequeue a vertex from queue and print it
      s = queue.poll();
      callback.accept(s);

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      for (int n : adj[s]) {
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  // A function used by DFS
  private void dfsRecursive(int v, boolean[] visited, final Consumer<Integer> callback) {
    // Mark the current node as visited and print it
    visited[v] = true;
    callback.accept(v);

    // Recur for all the vertices adjacent to this vertex
    for (int n : adj[v]) {
      if (!visited[n]) {
        dfsRecursive(n, visited, callback);
      }
    }
  }

  // The function to do DFS traversal. It uses recursive DFSUtil()
  public void dfsRecursive(int v, final Consumer<Integer> callback) {
    // Mark all the vertices as not visited(set as
    // false by default in java)
    boolean[] visited = new boolean[this.v];

    // Call the recursive helper function to print DFS traversal
    dfsRecursive(v, visited, callback);
  }

  // prints all not yet visited vertices reachable from s
  public void dfsStackVertices(int s, final Consumer<Integer> callback) {
    // Initially mark all vertices as not visited
    final var visited = new boolean[this.v];
    dfsStack(s, visited, callback);
  }

  // prints all vertices in DFS manner
  public void dfsStackAll(final Consumer<Integer> callback) {
    final var visited = new boolean[this.v];
    for (int i = 0; i < this.v; i++) {
      if (!visited[i]) {
        dfsStack(i, visited, callback);
      }
    }
  }

  // prints all not yet visited vertices reachable from s
  private void dfsStack(int s, boolean[] visited, final Consumer<Integer> callback) {
    // Create a stack for DFS
    final Stack<Integer> stack = new Stack<>();

    // Push the current source node
    stack.push(s);

    while (!stack.empty()) {
      // Pop a vertex from stack and print it
      s = stack.pop();

      // Stack may contain same vertex twice. So
      // we need to print the popped item only
      // if it is not visited.
      if (!visited[s]) {
        callback.accept(s);
        visited[s] = true;
      }

      // Get all adjacent vertices of the popped vertex s
      // If a adjacent has not been visited, then push it
      // to the stack.
      for (int v : adj[s]) {
        if (!visited[v]) {
          stack.push(v);
        }
      }
    }
  }
}
