package LinkedList;

import java.util.HashMap;


public class LRUCache {
	static class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	static HashMap<Integer, Node> map;
	static int Max, count;
	static Node head, tail;

	 LRUCache(int capacity) {
		Max = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < Max) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Going to test the LRU "
				+ " Cache Implementation");
		LRUCache cache = new LRUCache(2);

		// it will store a key (1) with value
		// 10 in the cache.
		cache.set(1, 10);

		// it will store a key (1) with value 10 in the
		// cache.
		cache.set(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

		// evicts key 2 and store a key (3) with
		// value 30 in the cache.
		cache.set(3, 30);

		System.out.println(
				"Value for the key: 2 is "
						+ cache.get(2)); // returns -1 (not found)

		// evicts key 1 and store a key (4) with
		// value 40 in the cache.
		cache.set(4, 40);
		System.out.println(
				"Value for the key: 1 is "
						+ cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is "
				+ cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is "
				+ cache.get(4)); // return 40
	}
}
