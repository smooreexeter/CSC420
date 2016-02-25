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
			n[i] = new Node(i);
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
		
		System.out.println(Dijkstra.Di2(g, n[1], n[5]).toString());
		
	}

}
