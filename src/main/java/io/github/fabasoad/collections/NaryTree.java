package io.github.fabasoad.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class NaryTree {

  public static void main(String[] args) {
    final var tree = new NaryTree();

    final var node12 = new Node<>(12);
    node12.add(new Node<>(121));
    node12.add(new Node<>(122));
    node12.add(new Node<>(123));

    final var node11 = new Node<>(11);
    node11.add(new Node<>(111));

    tree.root = new Node<>(1);
    tree.root.add(node11);
    tree.root.add(node12);

    System.out.print("BFS is [ ");
    tree.bfs(NaryTree::print);
    System.out.println("]");

    System.out.print("DFS is [ ");
    tree.dfs(NaryTree::print);
    System.out.println("]");
  }

  private static void print(final int value) {
    System.out.print(value + " ");
  }

  Node<Integer> root;

  NaryTree() {
    root = null;
  }

  public void bfs(final Consumer<Integer> callback) {
    if (root != null && callback != null) {
      final var queue = new ArrayDeque<Node<Integer>>();
      queue.add(root);
      while (!queue.isEmpty()) {
        final Node<Integer> node = queue.poll();
        callback.accept(node.key);
        queue.addAll(node.children);
      }
    }
  }

  public void dfs(Consumer<Integer> callback) {
    dfs(root, callback);
  }

  public void dfs(Node<Integer> node, Consumer<Integer> callback) {
    if (node != null && callback != null) {
      callback.accept(node.key);
      node.children.forEach(n -> dfs(n, callback));
    }
  }

  private static class Node<T> {

    T key;
    Collection<Node<T>> children;

    public Node(T item) {
      key = item;
      children = new ArrayList<>();
    }

    public void add(Node<T> child) {
      children.add(child);
    }
  }
}
