package io.github.fabasoad.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import org.apache.commons.collections4.bag.HashBag;

import static java.util.stream.Collectors.joining;

public class LinearDataStructures {

    public static void main(String[] args) {
//        linkedListTest();
//        hashSetTest();
//        linkedHashSetTest();
//        hashMapTest();
//        hashMapTest2();
//        hashtableTest();
//        arrayListTest();
//        vectorTest();
//        treeSetTest();
        treeMapTest();
//        bagTest();
//        queueTest();
//        stackTest();
//        priorityQueue();
    }

    private static void priorityQueue() {
        // internal implementation is array. null is not allowed.
        // Should either define comparator or objects have to implement Comparator.
        final var queue = new PriorityQueue<>(Comparator.comparingInt(HashObject::hashCode));
        queue.add(new HashObject(12));
        queue.add(new HashObject(10));
        queue.add(new HashObject(22));
        queue.add(new HashObject(112));
        System.out.println(queue.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void stackTest() {
        // internal implementation is array. null is allowed.
        final Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.pop();
        stack.peek();
        stack.add(null);
        stack.pop();
        stack.add(5);
        stack.pop();
        stack.add(7);
        stack.pop();
        stack.add(71);
        stack.pop();
        stack.add(41);
        System.out.println(stack.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void queueTest() {
        // nulls are not allowed. Internal implementation is array. It stores elements in cycling manner. Holding
        // head and tail positions.
        final ArrayDeque<Integer> queue = new ArrayDeque<>(4);
        queue.add(1);
        queue.poll();
        queue.add(12);
        queue.poll();
        queue.add(5);
        queue.poll();
        queue.add(7);
        queue.poll();
        queue.add(71);
        queue.poll();
        queue.add(41);

        final var el = queue.peek();
        System.out.println(el);
        final var el2 = queue.poll();
        System.out.println(el2);
        System.out.println(queue.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void bagTest() {
        // Internal implementation is hash map where key is object, value is count. After all the addings below,
        // in fact only 3 keys will be stored with count in values.
        final HashBag<Integer> bag = new HashBag<>();
        bag.add(1);
        bag.add(1);
        bag.add(4);
        bag.add(3);
        bag.add(1);
        bag.add(1);
        bag.add(4);
        bag.add(3);
        bag.add(1);
        bag.add(1);
        bag.add(4);
        bag.add(3);
        bag.add(1);
        bag.add(1);
        bag.add(4);
        bag.add(3);
        bag.add(1);
        bag.add(1);
        bag.add(4);
        bag.add(3);

        System.out.println(bag.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void treeMapTest() {
        // Black-Red tree based.
        // Doesn't allow nulls for keys (allowed for values though). It's sorted map by keys. Not synchronized.
        // Internally uses bidirectional linked list.
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(24, 2);
        map.put(453543, 3);
        map.put(3, 23);
        map.put(67, null);
        map.put(-14, 36);
        map.put(-78, 37);
//        map.put(new NullHash(3), 38);
        var element = map.get(-78);
        System.out.println(element);

        System.out.println(map.entrySet().stream().map(String::valueOf).collect(joining(",")));

        // Ordering of insertions matters! If we insert values in asc/desc order result will be less efficient than in
        // random order. Example: if we insert values in [4, 5, 3, 6, 1, 2] order, we will have the following tree:
        //       4
        //    2     5
        //  1   3     6
        // If we insert values in [1, 2, 3, 4, 5, 6] order, we will have the following tree (depth is greater than in
        // the previous example by 1):
        //        5
        //     3     6
        //   2   4
        // 1
        final var tree2 = new TreeMap<Integer, Integer>();
        tree2.put(4, 232);
        tree2.put(5, 233);
        tree2.put(3, 231);
        tree2.put(6, 234);
        tree2.put(1, 229);
        tree2.put(2, 230);
        var element2 = tree2.get(1);
        System.out.println(element2);

    }

    private static void treeSetTest() {
        // Ordered set based on TreeMap. No duplicates (because values are actually keys internally in TreeMap).
        // Value internally is just a dummy object for TreeMap. Doesn't have getters.
        var set = new TreeSet<Integer>();
        set.add(1);
        set.add(1);
        set.add(43);
        set.add(4);
        set.add(4000);

        System.out.println(set.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void vectorTest() {
        // Same as ArrayList but synchronized. Another difference is that when it's time to increase the size, Vector
        // doubles it but ArrayList increases it by half only.
        final Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(null);
        vector.add(null);

        System.out.println(vector.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void arrayListTest() {
        // just dynamic array
        final ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(null);
        list.add(null);

        System.out.println(list.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void hashtableTest() {
        // The same as HashMap but doesn't allow nulls (neither for keys nor for values).
        // Another difference is that it's synchronized.
        final Hashtable<Object, Integer> map = new Hashtable<>();
        map.put("k1", 2);
        map.put("k1", 3);
        map.put("k2", 23);
        map.put(new NullHash(1), 36);
        map.put(new NullHash(2), 37);
        map.put(new NullHash(3), 38);
        var element = map.get(new NullHash(45));
        System.out.println(map.entrySet().stream().map(String::valueOf).collect(joining(",")));
    }

    private static void hashMapTest2() {
        // Testing Hash Map with the objects that return different hash code but will be stored under the same index
        // in internal array. To summarize: collision might be not only in the situations when hash code are the same
        // but when bitwise AND operation will return the same index (even for different hash code).
        final HashMap<Object, Integer> map = new HashMap<>();
        map.put(new HashObject(3306), 1);
        map.put(new HashObject(3322), 1);
        final var val = map.get(new HashObject(3306));
        System.out.println(val);
    }

    private static void hashMapTest() {
        // HashMap -> array of nodes. key is ((size - 1) & hash).
        // if object returns the same hashcode but instances are different and equals() is false, it stores it under
        // the same hashcode as linked list. Otherwise, it overrides value (actually 1 node). This situation might be
        // happened when you override hashcode but don't override equals OR (very rare) when two absolutely different
        // objects return the same hash code. That's why technically the worst case scenario of retrieving value is O(n)
        // (if all objects will return the same hashcode but are not equal) but in fact it's O(1) as only one node
        // stores under 1 key.
        final HashMap<Object, Integer> map = new HashMap<>();
        map.put("k1", 2);
        map.put("k1", 3);
        map.put("k2", 23);
        map.put("k3", null);
        map.put(null, 34);
        map.put(null, 35);
        map.put(new NullHash(1), 36);
        map.put(new NullHash(2), 37);
        map.put(new NullHash(3), 38);
        var element = map.get(new NullHash(45));

        final HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            map2.put("key#" + i, i);
        }
        var el = map2.get("key#78");
        System.out.println(el);
        System.out.println(map.values());
    }

    private static void linkedHashSetTest() {
        // Almost the same as HashSet but order is predictable (because of Linked*)
        final LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(1); // warning here because of duplicate
        linkedHashSet.add(3);
        linkedHashSet.add(null);
        linkedHashSet.add(null);
        linkedHashSet.add(6);

        System.out.println(linkedHashSet.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void hashSetTest() {
        // Internal implementation is HashMap where elements are keys, value is dummy object
        // That's why there is not getter cause it doesn't make sense: objAbc = .get(objAbc)
        // Doesn't store duplicates just because HashMap cannot use the same object twice as a key.
        final HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add(3); // warning here because of duplicate
        hashSet.add(5);

        System.out.println(hashSet.stream().map(String::valueOf).collect(joining(",")));
    }

    private static void linkedListTest() {
        // A -> B -> C -> null
        // get(index) - iterate through the list either from the beginning or from the end.
        final var list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(5);

        System.out.println(list.stream().map(String::valueOf).collect(joining(",")));
    }

    private static class NullHash implements Comparable<Object> {
        private final int f;
//        @Override
//        public boolean equals(Object obj) {
//            return obj == null;
//        }


        public NullHash(final int f) {
            this.f = f;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return "NullHash#" + f;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof NullHash) {
                return Integer.compare(this.f, ((NullHash) o).f);
            }
            return toString().compareTo(o.toString());
        }
    }

    private static class HashObject {

        private int hash;

        public HashObject(int hash) {
            this.hash = hash;
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public String toString() {
            return "HashObject#" + hashCode();
        }
    }
}
