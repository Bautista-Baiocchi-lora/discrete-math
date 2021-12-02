package graph.tp3;

public class Edge<T> {
    T first;
    T second;
    int weight;

    Edge(T first, T second, int weight){
        this.first=first;
        this.second=second;
        this.weight=weight;
    }

    public boolean equalsNonDirected(Edge<T> o) {
        return (this.first.equals(o.first) && this.second.equals(o.second)) || (this.first.equals(o.second) && this.second.equals(o.first));
    }

    public boolean equalsDirected(Edge<T> o) {
        return (this.first.equals(o.first) && this.second.equals(o.second));
    }

    public String toString(){
        return ("{"+first.toString()+", "+second.toString()+"}");
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public int getWeight() {
        return weight;
    }

}
