package graph.factory;

import graph.*;

public class GraphFactoryImpl<T> implements GraphFactory<T> {
    @Override
    public Graph<T> createFromType(GraphType type) {
        switch (type) {
            case ADJACENCY_MATRIX:
                return new AdjacencyMatrixGraphImpl<>();
            case ADJACENCY_LIST:
                return new AdjacencyListGraphImpl<>();
            case EDGE_ARRAY:
            default:
                return new EdgeArrayGraphImpl<>();
        }
    }

    //    Returns a random graph
    @Override
    public Graph<T> getGraph() {
//        return new EdgeArrayGraphImpl<>();
//        return new AdjacencyMatrixGraphImpl<>();
        return new AdjacencyListGraphImpl<>();
    }
}
