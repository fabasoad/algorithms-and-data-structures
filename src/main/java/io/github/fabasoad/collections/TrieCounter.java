package io.github.fabasoad.collections;

import java.util.HashMap;

public class TrieCounter {

    private TrieNode root;

    public TrieCounter() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.increase();
    }

    public boolean isEmpty() {
        return root.getChildren().isEmpty();
    }

    public int find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return 0;
            }
            current = node;
        }
        return current.getCount();
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (current.getCount() == 0) {
                return false;
            }
            current.decrease();
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && node.getCount() > 0;

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    private static class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private int count;

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public int getCount() {
            return count;
        }

        public void increase() {
            this.count++;
        }

        public void decrease() {
            if (this.count > 0) {
                this.count--;
            }
        }
    }
}
