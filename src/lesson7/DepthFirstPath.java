package lesson7;

import java.util.LinkedList;

public class DepthFirstPath extends Path {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPath(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        search(g, source);
    }

    @Override
    void search(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                search(g, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

}
