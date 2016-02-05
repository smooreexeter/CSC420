package book;

import java.awt.RenderingHints.Key;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	static Node root;

	public static void addNode(int key, String name) {

		// Create a new Node and initialize it

		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.key) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}
	
	public static void addNode(Node focusNode){
		addNode(focusNode.key, focusNode.name);
		findNode(focusNode.key).leftChild = focusNode.leftChild;
		findNode(focusNode.key).rightChild = focusNode.rightChild;
	}
	
	public static Node findHighest(Node focusNode){
		if(focusNode.rightChild != null){
			return findHighest(focusNode.rightChild);
		}else{
			return focusNode;
		}
	}
	
	public static Node findParent(Node rt, Node focusNode){
		if(rt == focusNode){
			return null;
		}
		if(rt.leftChild == null && rt.rightChild == null){
			return null;
		}
		if(rt.rightChild == focusNode || rt.leftChild == focusNode){
			return rt;
		}
		if(rt.leftChild != null && findParent(rt.leftChild, focusNode) != null){
			return findParent(rt.leftChild, focusNode);
		}else if(rt.rightChild != null && findParent(rt.rightChild, focusNode) != null){
			return findParent(rt.rightChild, focusNode);
		}
		return null;
	}
	
<<<<<<< HEAD
	public static void delete(int key){
		Node temp = findNode(key);
		if(temp.rightChild != null){
			Node temp2 = temp.rightChild;
			Node temp3 =  temp.rightChild.leftChild;
			temp.name = temp2.name;
			temp.key = temp2.key;
			temp.rightChild = temp2.rightChild;
			boolean leftFound = false;
			if(temp2.leftChild != null){
				Node temp4 = temp.rightChild;
				while(!leftFound){
					if(temp4.leftChild == null ){
						temp4.leftChild = temp3;
						leftFound = true;
=======
	public static void delete(Node focusNode){
		Node p = findParent(root, focusNode);
		Queue<Node> qu = new LinkedList<Node>();
		if(p != null){
			if(p.leftChild != null){
				if(p.leftChild.key == focusNode.key){
					if(focusNode.leftChild != null){
						qu.add(focusNode.leftChild);
					}
					if(focusNode.rightChild != null){
						qu.add(focusNode.rightChild);
					}
					p.leftChild = null;
				}
			}
			if(p.rightChild != null){
				if(p.rightChild.key == focusNode.key){
					if(focusNode.leftChild != null){
						qu.add(focusNode.leftChild);
					}
					if(focusNode.rightChild != null){
						qu.add(focusNode.rightChild);
>>>>>>> origin/Winter
					}
					p.rightChild = null;
				}
			}
		}else{
			if(focusNode.rightChild != null){
				if(focusNode.leftChild != null){
					qu.add(focusNode.leftChild);
				}
				root = focusNode.rightChild;
			}else if(focusNode.leftChild != null){
				root = focusNode.leftChild;
				focusNode.leftChild = null;
			}
		}
		Node temp;
		for(int i = 0; i < qu.size(); i++){
			temp = qu.poll();
			addNode(temp);
		}
	}
	
	
	public static void rearrange(BinaryTree tree){
		if(height(tree.root) >= 1){
			Queue<Node> qu = new LinkedList<Node>();
			Node temp;
			while(height(tree.root)  != 1){
				temp = findHighest(tree.root);
				qu.add(temp);
				delete(temp);
			}
			tree.root.leftChild = qu.poll();
			qu.add(tree.root);
			delete(tree.root);
			Node temp2 = qu.poll();
			while(temp2 != null){
				tree.addNode(temp2.key, temp2.name);
				temp2 = qu.poll();
			}
		}
	}
	
	

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth
	
	static LinkedList<int[]> ll = new LinkedList<int[]>();

	public static void inOrderTraverseTree(Node focusNode, int lvl) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild, lvl+1);

			// Visit the currently focused on node

			
			int[] store = new int[2];
			store[0] = focusNode.key;
			store[1] = lvl;
			
			ll.add(store);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild, lvl+1);

		}

	

	

	}

	public static Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			// If we should search to the left

			if (key < focusNode.key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}

public static void main(String[] args) {

		BinaryTree theTree = new BinaryTree();

		theTree.addNode(51, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");

		theTree.addNode(83, "Salesman 1");

		theTree.addNode(86, "Salesman 2");
		
		theTree.addNode(87, "Salesman 3");
		
		theTree.addNode(7, "Person 1");
		
		theTree.addNode(21, "Person 2");
		
		theTree.addNode(3, "Person 3");
		// Different ways to traverse binary trees

		// theTree.inOrderTraverseTree(theTree.root);

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

<<<<<<< HEAD
		/*
		System.out.println("Small Count: " + smallCount(root, root.key));
=======
		
		//System.out.println("Small Count: " + smallCount(root, root.key));
>>>>>>> origin/Winter
		
		//printLevels2(root);
		
		//System.out.println("\n\n");
		
		
		//printLevels3(theTree);

		//System.out.println("\n\n");
		
		//System.out.println("\n\n");
		
		
		printLevels2(root);
		
		rearrange(theTree);		
		
		System.out.println("\n\nRearranged");
		
		printLevels2(root);
		*/
		
		div5(root);

}
	public static int height(Node a){
		int h1 = 0;
		int h2 = 0;
		if(!a.isLeaf()){
			if(a.leftChild!=null){
				h1 = height(a.leftChild);
			}
			if(a.rightChild!=null){
				h2 = height(a.rightChild);
			}
			if(h1 >= h2){
				return h1 + 1;
			}else{
				return h2 + 1;
			}
		}else{
			return 1;
		}
	}
	
	public static int smallCount(Node FocusNode, int K){
		return smallCountT(FocusNode.leftChild, K) + smallCountT(FocusNode.rightChild, K);
	}
	
	public static int smallCountT(Node FocusNode, int K){
		int lc = 0;
		int rc = 0;
		int th = 0;
		if(FocusNode != null){
			if(FocusNode.key <= K){
				th = 1;
			}
			if(FocusNode.leftChild != null){
				lc = smallCountT(FocusNode.leftChild, K);
			}
			if(FocusNode.rightChild != null){
				rc = smallCountT(FocusNode.rightChild, K);
			}
		}
		return lc + rc + th;
	}
	
	public static void printLevels2(Node focusNode){
		ll = new LinkedList<int[]>();
		inOrderTraverseTree(root, 0);
		printLevels2a(focusNode, 0);
	}
	
	public static void printLevels2a(Node focusNode, int lvl){
		for(int i = 0; i < ll.size(); i++){
			if(ll.get(i)[1] == lvl){
				System.out.println("Level " + lvl);
				System.out.println(ll.get(i)[0]);
			}
		}
		if(lvl < height(focusNode)){
			printLevels2a(focusNode, lvl + 1);
		}
	}
	
	

	
	public static void printLevels3(BinaryTree t){
		Node focusNode = t.root;
		Queue<Node> qu = new LinkedList<Node>();
		if(focusNode != null){
			qu.add(focusNode);
		}
		while(qu.size() != 0){
			Node dq = qu.remove();
			System.out.println(dq.key);
			if(dq.leftChild != null){
				qu.add(dq.leftChild);
			}
			if(dq.rightChild != null){
				qu.add(dq.rightChild);
			}
		}
	}
	
	
	public static void div5(Node focusNode){
		if(focusNode.key % 5 == 0 && focusNode.leftChild != null){
			if(focusNode.leftChild.leftChild != null){
				System.out.print(focusNode.leftChild.leftChild.key + ", ");
			}
			if(focusNode.leftChild.rightChild != null){
				System.out.print(focusNode.leftChild.rightChild.key + ", ");
			}
		}
		if(focusNode.key % 5 == 0 && focusNode.rightChild != null){
			if(focusNode.rightChild.leftChild != null){
				System.out.print(focusNode.rightChild.leftChild.key + ", ");
			}
			if(focusNode.rightChild.rightChild != null){
				System.out.print(focusNode.rightChild.rightChild.key + ", ");
			}
		}
		if(focusNode.rightChild != null){
			div5(focusNode.rightChild);
		}
		if(focusNode.leftChild != null){
			div5(focusNode.leftChild);
		}
	}
	
	

}
