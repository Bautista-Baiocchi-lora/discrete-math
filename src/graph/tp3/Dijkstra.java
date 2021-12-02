package graph.tp3;

import java.util.List;

public class Dijkstra<T> {
    List<DNode<T>> dijkstraVector;
    List<PNode<T>> pathVector;

    public Dijkstra(List<DNode<T>> dijkstraVector, List<PNode<T>> pathVector) {
        this.dijkstraVector = dijkstraVector;
        this.pathVector = pathVector;
    }

    public List<DNode<T>> getDijkstraVector() {
        return dijkstraVector;
    }

    public void setDijkstraVector(List<DNode<T>> dijkstraVector) {
        this.dijkstraVector = dijkstraVector;
    }

    public List<PNode<T>> getPathVector() {
        return pathVector;
    }

    public void setPathVector(List<PNode<T>> pathVector) {
        this.pathVector = pathVector;
    }
}
