package test;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.Vertex;

public class PruebaPlanEstudio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String, Integer> g = new AdjacencyMapGraph<>(true);

		
		//Primer Cuatrimestre
		Vertex<String> v1 = g.insertVertex("IF001"); 
		Vertex<String> v2 = g.insertVertex("MA045");
		Vertex<String> v3 = g.insertVertex("IF002");
		
		
		//Segundo Cuartrimestre
		Vertex<String> v4 = g.insertVertex("IF003"); 
		Vertex<String> v5 = g.insertVertex("MA046"); 
		Vertex<String> v6 = g.insertVertex("MA008"); 
		
		
		
		Edge<Integer> a1 = g.insertEdge(v3, v4, 1);
		
	
		System.out.println("Numero de vertices: " + g.numVertices());
		System.out.println("Numero de arcos: " + g.numEdges());

		for (Vertex<String> vert : g.vertices())
			System.out.println(vert.getElement());

		for (Edge<Integer> arc : g.edges())
			System.out.println(arc.getElement());
		
	}

}
