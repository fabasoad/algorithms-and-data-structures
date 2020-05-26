package io.github.fabasoad.collections;

import java.util.function.Consumer;

class BinaryTree {

  // Driver method
  public static void main(String[] args) {
    final var tree = new BinaryTree();
    tree.root = new Node<>(1);
    tree.root.left = new Node<>(2);
    tree.root.right = new Node<>(3);
    tree.root.left.left = new Node<>(4);
    tree.root.left.right = new Node<>(5);

    System.out.print("Preorder traversal of binary tree is [ ");
    tree.traversePreorder(BinaryTree::print);
    System.out.println("]");

    System.out.print("Inorder traversal of binary tree is [ ");
    tree.traverseInorder(BinaryTree::print);
    System.out.println("]");

    System.out.print("Postorder traversal of binary tree is [ ");
    tree.traversePostorder(BinaryTree::print);
    System.out.println("]");
  }

  private static void print(final int value) {
    System.out.print(value + " ");
  }

  // Root of Binary Tree
  Node<Integer> root;

  BinaryTree() {
    root = null;
  }

  /* Given a binary tree, print its nodes according to the
  "bottom-up" postorder traversal. */
  void traversePostorder(Node<Integer> node, final Consumer<Integer> callback) {
      if (node == null) {
          return;
      }

    // first recur on left subtree
    traversePostorder(node.left, callback);

    // then recur on right subtree
    traversePostorder(node.right, callback);

    // now deal with the node
    callback.accept(node.key);
  }

  /* Given a binary tree, print its nodes in inorder*/
  void traverseInorder(Node<Integer> node, final Consumer<Integer> callback) {
      if (node == null) {
          return;
      }

    /* first recur on left child */
    traverseInorder(node.left, callback);

    /* then print the data of node */
    callback.accept(node.key);

    /* now recur on right child */
    traverseInorder(node.right, callback);
  }

  /* Given a binary tree, print its nodes in preorder*/
  void traversePreorder(Node<Integer> node, final Consumer<Integer> callback) {
      if (node == null) {
          return;
      }

    /* first print data of node */
    callback.accept(node.key);

    /* then recur on left subtree */
    traversePreorder(node.left, callback);

    /* now recur on right subtree */
    traversePreorder(node.right, callback);
  }

  // Wrappers over above recursive functions
  void traversePostorder(final Consumer<Integer> callback) {
    traversePostorder(root, callback);
  }

  void traverseInorder(final Consumer<Integer> callback) {
    traverseInorder(root, callback);
  }

  void traversePreorder(final Consumer<Integer> callback) {
    traversePreorder(root, callback);
  }

  /* Class containing left and right child of current node and key value*/
  private static class Node<T> {

    T key;
    Node<T> left, right;

    public Node(T item) {
      key = item;
      left = right = null;
    }
  }
}
