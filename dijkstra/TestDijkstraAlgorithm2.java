package dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import dijkstra.DijkstraAlgorithm;
import dijkstra.Edge;
import dijkstra.Graph;
import dijkstra.Vertex;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDijkstraAlgorithm2 {

  private List<Vertex> nodes;
  private List<Edge> edges;

  @Test
  public void testExcute() {
    nodes = new ArrayList<Vertex>();
    edges = new ArrayList<Edge>();
    for (int i = 0; i < 5; i++) {
      Vertex location = new Vertex("Node_" + i, "Node_" + i);
      nodes.add(location);
    }

    addLane("Edge_0", 0, 1, 9);
    //addLane("Edge_1", 0, 3, 5);
    addLane("Edge_2", 1, 2, 1);
    //addLane("Edge_3", 1, 3, 2);
    addLane("Edge_4", 2, 3, 3);
    //addLane("Edge_5", 3, 4, 1);
    //addLane("Edge_0", 0, 1, 50);
    //addLane("Edge_1", 0, 3, 10 );
    //addLane("Edge_2", 0, 2, 60);
    //addLane("Edge_3", 1, 2, 10);
    //addLane("Edge_4", 2, 4, 30);
    //addLane("Edge_5", 3, 0, 20);
    //addLane("Edge_6", 1, 3, 15);
    //addLane("Edge_7", 3, 4, 15);
    //addLane("Edge_8", 4, 1, 20);
    //addLane("Edge_9", 4, 2, 35);
    //addLane("Edge_10", 5, 4, 3);

    // Lets check from location Loc_1 to Loc_10
    Graph graph = new Graph(nodes, edges);
    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
    dijkstra.execute(nodes.get(0));
    LinkedList<Vertex> path = dijkstra.getPath(nodes.get(3));
    
    assertNotNull(path);
    assertTrue(path.size() > 0);
    
    for (Vertex vertex : path) {
      System.out.println(vertex);
    }
    
  }

  private void addLane(String laneId, int sourceLocNo, int destLocNo,
      int duration) {
    Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
    edges.add(lane);
  }
} 
