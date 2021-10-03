package lesson7;

/**
 * 0 1 2 3 4 5 6 7 8 9 10
 * 0 1 1 1   1
 * 1                 1
 * 2                 1 1  1
 * 3                 1
 * 4       1   1
 * 5
 * 6
 * 7
 * 8             1 1
 * 9
 * 10
 */

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(11);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(2, 8);
        graph.addEdge(2, 9);
        graph.addEdge(2, 10);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(8, 6);
        graph.addEdge(8, 7);


        System.out.println(graph.getVertexCount());
        System.out.println(graph.getEdgeCount());
        System.out.println(graph.getAdjList(4));

        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
        System.out.println(dfp.hasPathTo(10));
        System.out.println(dfp.pathTo(10));


    }
}
