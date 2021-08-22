package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EdgeArrayGraphImpl<T> implements Graph<T> {
    private final List<T> vertexes;
    private final List<T[]> edges;
    private int n; // number of vertexes
    private int alpha; // number of edges

    public EdgeArrayGraphImpl() {
        this.vertexes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.n = 0;
        this.alpha = 0;
    }

    @Override
    public void addVertex(T x) {
        vertexes.add(x);
        n++;
    }

    @Override
    public boolean hasVertex(T v){
        return vertexes.contains(v);
    }

    @Override
    public void removeVertex(T x) {
        vertexes.remove(x);
        n--;
        for (Iterator<T[]> iterator = edges.iterator(); iterator.hasNext();) {
            T[] edge = iterator.next();
            if (edge[0].equals(x) || edge[1].equals(x)) {
                iterator.remove();
                alpha--;
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addEdge(T v, T w) {
        if(hasVertex(v) && hasVertex(w)) {
            T[] edge = (T[]) new Object[2];
            edge[0] = v;
            edge[1] = w;
            edges.add(edge);
            alpha++;
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        edges.removeIf(edge ->
                edge[0].equals(v) && edge[1].equals(w) ||
                edge[0].equals(w) && edge[1].equals(v));
        alpha--;
    }

    @Override
    public boolean hasEdge(T v, T w) {
        for (T[] edge : edges) {
            if (edge[0].equals(v) && edge[1].equals(w) ||
                edge[0].equals(w) && edge[1].equals(v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int alpha() {
        return alpha;
    }

    @Override
    public List<T> getVertexes() {
        return vertexes;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        List<T> adjacencyList = new ArrayList<>();

        for (T[] edge : edges) {
            if (edge[0].equals(v)) {
                adjacencyList.add(edge[1]);
            } else if (edge[1].equals(v)) {
                adjacencyList.add(edge[0]);
            }
        }

        return adjacencyList;
    }
}
