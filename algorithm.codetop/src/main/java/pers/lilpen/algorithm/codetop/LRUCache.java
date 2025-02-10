package pers.lilpen.algorithm.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : penghuaishun
 * @version : 1.0
 * @date : 2024-09-26 16:19
 **/
public class LRUCache {
    private final Map<Integer, Node> cache;
    private final LinkedList linkedList;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.linkedList = new LinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        linkedList.moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                Node last = linkedList.removeLast();
                cache.remove(last.key);
            }
            node = new Node(key, value);
            linkedList.addAtHead(node);
            cache.put(key, node);
        } else {
            node.value = value;
            linkedList.moveToFirst(node);
        }
    }

    private static class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class LinkedList {
        private Node head;
        private Node tail;

        public LinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void addAtHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToFirst(Node node) {
            remove(node);
            addAtHead(node);
        }

        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
