package graph;

import java.util.ArrayList;
import java.util.List;


public class AdjacencyListGraphImpl<T> implements Graph<T> {
    List<T> vertexes;
    List<List<T>> edges;
    int n;
    int alpha;

    public AdjacencyListGraphImpl() {
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
    }

    @Override
    public void addEdge(T v, T w) {
        if (vertexes.contains(v) && vertexes.contains(w)) {
            List<T> edge = new ArrayList<>();
            edge.add(v);
            edge.add(w);

            edges.add(edge);
            alpha++;
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        int removeIndex = 0;
        for (int i = 0; i < edges.size() ; i++) {
            List <T> edge = edges.get(i);

            if (edge.contains(v) && edge.contains(w)) removeIndex = i;
        }

        edges.remove(removeIndex);
        alpha--;
    }

    @Override
    public boolean hasEdge(T v, T w) {
        if(v.equals(w)){
            return false; // no lazos
        }
        for (List<T> edge : edges) {
            if (edge.contains(v) && edge.contains(w)) {
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

        for (List<T> edge: edges){
            if (edge.contains(v)){
                boolean isTwice = false;
                for (T vertex: edge) {
                    if (!vertex.equals(v) || isTwice) adjacencyList.add(vertex);
                    if (vertex.equals(v)) isTwice = true;
                }
            }
        }

        return adjacencyList;
    }

}
