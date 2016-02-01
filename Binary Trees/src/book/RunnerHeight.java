package book;

import java.awt.RenderingHints.Key;

public class RunnerHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTNode n0 = new BSTNode(null, 50);
		BSTNode n1 = new BSTNode(null, 25);
		BSTNode n2 = new BSTNode(null, 75);
		BSTNode n3 = new BSTNode(null, 30);
		BSTNode n4 = new BSTNode(null, 15);
		BSTNode n5 = new BSTNode(null, 85);
 		n0.setLeft(n1);
		n0.setRight(n2);
		n1.setRight(n3);
		n1.setLeft(n4);
		n2.setRight(n5);
		
		System.out.println(height(n0));
		System.out.println(numLeaf(n0));
	}
	
	public static int height(BSTNode a){
		System.out.println("run" + a.element());
		int h1 = 0;
		int h2 = 0;
		if(!a.isLeaf()){
			if(a.left()!=null){
				h1 = height(a.left());
			}
			if(a.right()!=null){
				h2 = height(a.right());
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
	
	public static int numLeaf(BSTNode a){
		int h1 = 0;
		int h2 = 0;
		if(a.isLeaf()){
			return 1;
		}else{
			if(a.left()!=null){
				h1 = height(a.left());
			}
			if(a.right()!=null){
				h2 = height(a.right());
			}
			return h1 + h2;
		}
	}

}
