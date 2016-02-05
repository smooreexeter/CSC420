package book;

import java.awt.RenderingHints.Key;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePopQuiz {

	static Node root;

	public void addNode(int key, String name) {

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
	
	
	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth
	
	static LinkedList<int[]> ll = new LinkedList<int[]>();

	public static void inOrderTraverseTree(Node focusNode, int lvl) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild, lvl+1);

			// Visit the currently focused on node

			//System.out.println(focusNode);
			
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

		BinaryTreePopQuiz theTree = new BinaryTreePopQuiz();

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
		
		
		System.out.print("Items whose grandparents are divisible by 5: ");
		div5(root);

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
