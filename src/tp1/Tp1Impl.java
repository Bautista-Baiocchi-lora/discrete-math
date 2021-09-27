package tp1;

import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tp1Impl<T> implements Tp1<T> {
    @Override
    public void exercise_a(Graph<T> graph) {
        System.out.println("g=(V,A)");
        System.out.println("V= " + graph.getVertexes().toString());
        for (T vertex: graph.getVertexes()) {
            System.out.println("Adjacency list for " + vertex + " is: " + graph.getAdjacencyList(vertex).toString());
        }
    }

    @Override
    public int exercise_b(Graph<T> graph) {
        int count = 0;
        for(T vertex: graph.getVertexes()){
            if(graph.getAdjacencyList(vertex).contains(vertex)){
                count++;
            }
        }
        return count;
    }

    @Override
    public List<T> exercise_c(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_d(Graph<T> graph, T vertex) {
        List<T> vertexes = graph.getVertexes();
        for (T temp : vertexes) {
            if (graph.hasEdge(vertex, temp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int exercise_e(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_g(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int[][] exercise_h(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int[][] exercise_i(Graph<T> graph) {
        final int[][] matrix = new int[graph.alpha()][graph.order()];

        List<int[]> columns = new ArrayList<>();
        for(int a =0; a<graph.order(); a++) {
            T first = graph.getVertexes().get(a);
            for (int b = 0; b < graph.order(); b++) {
                T second = graph.getVertexes().get(b);
                if (graph.hasEdge(first, second)) {
                    final int[] column = new int[graph.order()];
                    column[a] = 1;
                    column[b] = 1;
                    boolean isUnique = columns.stream().noneMatch(i -> Arrays.equals(i, column));
                    if(isUnique){
                        columns.add(column);
                    }
                }
            }
        }

        for(int i=0;i< graph.alpha();i++){
            matrix[i] = columns.get(i);
        }

        return matrix;
    }
}
