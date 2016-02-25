package classwork;

import java.util.LinkedList;

import cs420designproject.Dijkstra;
import graph.*;

public class ClassworkSam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		Node[] n = new Node[7];
		for(int i = 1; i < 7; i++){
			n[i] = new Node((char) (i + 64));
			g.addNode(n[i]);
		}
		Edge[] e = new Edge[9];
		e[1] = new Edge(n[1], n[2], 10);
		e[2] = new Edge(n[1], n[4], 20);
		e[3] = new Edge(n[1], n[6], 3);
		e[4] = new Edge(n[2], n[4], 5);
		e[5] = new Edge(n[2], n[3], 3);
		e[6] = new Edge(n[3], n[5], 15);
		e[7] = new Edge(n[4], n[6], 10);
		e[8] = new Edge(n[4], n[5], 11);
		e[0] = new Edge(n[5], n[6], 3);
		for(int i = 0; i < 9; i++){
			g.addEdge(e[i]);
		}
		
		
		Graph h = new Graph();
		Node a1 = new Node("0");
		Node a2 = new Node("1");
		Node a3 = new Node("2");
		h.addNode(a1);
		h.addNode(a2);
		h.addNode(a3);
		
		h.addEdge(new Edge(a1, a2, 1));
		h.addEdge(new Edge(a2, a3, 1));
		
		
		//System.out.println(Dijkstra.Di2(g, n[6], n[2]).toString());
		System.out.println(isThereATriangle(h));
		
		
	}
	
	public static boolean isThereATriangle(Graph g){
		for(int i = 0; i < g.getNodeCount(); i++){
			System.out.println("i " + i);
			LinkedList<Node> n1 = g.getNeighbors(g.getNodeAt(i));
			for(int j = 0; j < n1.size(); j++){
				System.out.println("j " + j);
				LinkedList<Node> n2 = g.getNeighbors(g.getNodeAt(j));
				for(int k = 0; k < n2.size(); k++){
					if(!n2.get(k).equals(g.getNodeAt(i))){
						System.out.println("k " + k);
						LinkedList<Node> n3 = g.getNeighbors(g.getNodeAt(k));
						for(int l = 0; l < n3.size(); l++){
							System.out.println(k + " " + i);
							if(g.getEdgeBetween(n3.get(l), n1.get(j)) != null && !n3.get(l).equals(n1.get(j)) && !n3.get(l).equals(n2.get(k))){
								return true;
							}
						}
						
					}
				}
				
			}
		}
		return false;
	}
	

}
