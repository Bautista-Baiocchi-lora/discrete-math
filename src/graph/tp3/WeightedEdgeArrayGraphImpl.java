package graph.tp3;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class WeightedEdgeArrayGraphImpl<T> implements WeightedGraph<T> {
    private final List<T> vertexes;
    private final List<Edge<T>> edges;
    private int n; // number of vertexes
    private int alpha; // number of edges

    public WeightedEdgeArrayGraphImpl() {
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
    public void removeVertex(T x) {
        vertexes.remove(x);
        n--;
        for (Iterator<Edge<T>> iterator = edges.iterator(); iterator.hasNext();) {
            Edge<T> edge = iterator.next();
            if (edge.getFirst().equals(x) || edge.getSecond().equals(x)) {
                iterator.remove();
                alpha--;
            }
        }
    }

    @Override
    public boolean hasVertex(T v) {
        return vertexes.contains(v);
    }

    @Override
    public List<T> getVertexes() {
        return vertexes;
    }

    @Override
    public void addEdge(T v, T w, int weight) {
        if(hasVertex(v) && hasVertex(w) && !hasEdge(v, w)) {
            edges.add(new Edge<>(v, w, weight));
            alpha++;
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        edges.removeIf(edge ->
                edge.getFirst().equals(v) && edge.getSecond().equals(w) ||
                        edge.getFirst().equals(w) && edge.getSecond().equals(v));
        alpha--;
    }

    @Override
    public boolean hasEdge(T v, T w) {
        for (Edge<T> edge : edges) {
            if (edge.getFirst().equals(v) && edge.getSecond().equals(w) ||
                    edge.getFirst().equals(w) && edge.getSecond().equals(v)) {
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
    public List<T> getAdjacencyList(T v) {
        List<T> adjacencyList = new ArrayList<>();

        for (Edge<T> edge : edges) {
            if (edge.getFirst().equals(v)) {
                adjacencyList.add(edge.getSecond());
            } else if (edge.getSecond().equals(v)) {
                adjacencyList.add(edge.getFirst());
            }
        }

        return adjacencyList;
    }

    @Override
    public int getWeight(T v, T w) {
        if (alpha == 0) return Integer.MAX_VALUE;
        for (int i = 0; i < alpha ; i++) {
            if(hasEdge(v,w)) {
                Optional<Edge<T>> edge = getEdge(v, w);
                if (edge.isPresent()) {
                    return edge.get().getWeight();
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private Optional<Edge<T>> getEdge(T v, T w){
        if(alpha == 0) return Optional.empty();
        Edge<T> edge=new Edge<>(v,w,0);
        for (int i = 0; i < alpha ; i++) {
            if(edge.equalsNonDirected(edges.get(i))) return Optional.ofNullable(edges.get(i));
        }
        return Optional.empty();

    }

}
