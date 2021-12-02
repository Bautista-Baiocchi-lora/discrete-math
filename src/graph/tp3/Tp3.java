package graph.tp3;

public interface Tp3<T> {
    Dijkstra<T> doDijkstra(WeightedEdgeArrayGraphImpl<T> weightedGraph, T startingPoint);
}
