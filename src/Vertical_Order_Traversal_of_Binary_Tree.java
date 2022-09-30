import java.util.*;

public class Vertical_Order_Traversal_of_Binary_Tree {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	static class Tuple{
		Node node;
		int distance;
		int level;
		Tuple(Node n , int dist , int lvl){
			node = n;
			distance = dist;
			level = lvl;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println("Vertical Order traversal is");
		ArrayList<ArrayList<Integer>> ans = verticalTraversal(root);
		System.out.println(ans);
	}
	public static ArrayList<ArrayList<Integer>> verticalTraversal(Node A) {
		// in Hashmap first is the distance then level then node value
		TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> hm = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<Tuple>();
		q.offer(new Tuple(A , 0 , 0));

		while(!q.isEmpty()){
			Tuple tuple = q.poll();
			Node new_node = tuple.node;
			int dist = tuple.distance;
			int lvl = tuple.level;

			if(!hm.containsKey(dist)){
				hm.put(dist , new TreeMap<>());
			}
			if(!hm.get(dist).containsKey(lvl)){
				hm.get(dist).put(lvl , new PriorityQueue<>());
			}
			hm.get(dist).get(lvl).offer(new_node.data);

			if(new_node.left != null){
				q.offer(new Tuple(new_node.left , dist-1 , lvl+1));
			}
			if(new_node.right != null)
				q.offer(new Tuple(new_node.right , dist+1 , lvl+1));
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(TreeMap<Integer, PriorityQueue<Integer>> ys : hm.values()){
			list.add(new ArrayList<>());
			for(PriorityQueue<Integer> nodes: ys.values()){
				while(!nodes.isEmpty()){
					//System.out.println(nodes.peek());
					list.get(list.size()-1).add(nodes.poll());
				}
			}
		}
		return list;
	}
}
