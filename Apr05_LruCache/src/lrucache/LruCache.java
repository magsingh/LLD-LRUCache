package lrucache;

import java.util.HashMap;

public class LruCache <K, V> {
	
	public class Node {
		private K key;
		private V val;
		private Node next;
		private Node prev;

		public Node(K k, V v, Node nxt, Node prv) {
			this.key = k;
			this.val = v;
			this.next = nxt;
			this.prev = prv;
		}
	}
	
	private int maxSize;
	private HashMap<K, Node> map;
	private Node head;
	private Node tail;

	public LruCache(int maxSize) {
		this.maxSize = maxSize;
		map = new HashMap<>();
		head = new Node(null, null, null, null);
		tail = new Node(null, null, null, null);
		head.next = tail;
		tail.prev = head;
	}
	
	
	//-->
	public V get(K key) {
		if (map.containsKey(key)) {
			System.out.println("Cache hit: " + key);
			Node tmp = map.get(key);
			moveToHead(tmp);
			return tmp.val;
		}
		System.out.println(key + " is not present in the cache");
		return null;
	}
	
	public void moveToHead(Node n) {
		removeNode(n);
		addNode(n);
	}
	
	public void removeNode(Node n) {
		System.out.println("Removing " + n.val);
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}
	
	public void addNode(Node n) {
		System.out.println("Adding to head " + n.val);
		n.next = head.next;
		n.next.prev = n;
		n.prev = head;
		head.next = n;
	}
	//<--
	
	//-->
	public void put(K k, V v) {
		if (map.containsKey(k)) {
			System.out.println(v + " is already present, update that");
			Node n = map.get(k);
			n.val = v;
			moveToHead(n);
		} else {
			System.out.println("! in Cache- adding to it " + k);
			Node n = new Node(k, v, null, null);
			map.put(k, n);
			addNode(n);
			if (map.size() > maxSize) {
				Node lastNode = popTail();
				System.out.println("Cache full- removing last");
				map.remove(lastNode.key);
			}
		}
	}
	
	public Node popTail() {
		Node n = tail.prev;
		removeNode(n);
		return n;
	}
	//<--
	
	void printList() {
		System.out.print(">>>> List is:");
		Node tmp = head.next;
		while (tmp != null) {
			System.out.print(" ##" + tmp.key + " : " + tmp.val);
			tmp = tmp.next;
		}
		System.out.println();
		System.out.println();
	}
}
