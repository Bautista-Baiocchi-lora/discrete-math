package tp2;

import graph.Graph;

import java.util.*;

public class Tp2Impl<T> implements Tp2<T> {
    @Override
    public List<T> depth_first_search(Graph<T> graph) {
        List<T> result = new ArrayList<>();
        Stack<T> stack = new Stack<>();
        List<T> vertexes = graph.getVertexes();

        Map<T, Boolean> visited = new HashMap<>();
        for (T vertex : vertexes) {
            visited.put(vertex, false);
        }
        stack.add(vertexes.get(0));

        while (!stack.isEmpty()) {
            T v = stack.pop();
            if(visited.get(v)) continue;

            visited.put(v, true);
            result.add(v);

            List<T> adjacencyList = graph.getAdjacencyList(v);

            if(!adjacencyList.isEmpty()) {
                stack.addAll(adjacencyList);
            }

        }
        return result;
    }

    @Override
    public List<T> breadth_first_search(Graph<T> graph) {
        List<T> result = new ArrayList<>();
        Queue<T> c = new LinkedList<>();
        List<T> vertexes = graph.getVertexes();

        Map<T, Boolean> visited = new HashMap<>();
        for (T vertex : vertexes) {
            visited.put(vertex, false);
        }
        c.add(vertexes.get(0));

        while (!c.isEmpty()) {
            T v = c.remove();
            if(visited.get(v)) continue;

            visited.put(v, true);
            result.add(v);

            List<T> adjacencyList = graph.getAdjacencyList(v);

            if(!adjacencyList.isEmpty()) {
                c.addAll(adjacencyList);
            }

        }
        return result;
    }

    @Override
    public boolean exercise_a(Graph<T> graph, T v, T w) {
        if (v.equals(w) || graph.hasEdge(v, w)) return true;
        final HashMap<T,Boolean>  visitedVertex = new HashMap<>();
        for (int i = 0 ; i < graph.getVertexes().size(); i++){
            visitedVertex.put(graph.getVertexes().get(i),false);
        }
        return exersise_a_helper(visitedVertex, graph, v, w);
    }

    private boolean exersise_a_helper(HashMap<T,Boolean> visitedVertex, Graph<T> graph, T v, T w){
        if (v.equals(w) || graph.hasEdge(v, w)) {
            return true;
        } else {
            visitedVertex.replace(v, true);
        }
        List<T> adjacenyList = graph.getAdjacencyList(v);

        if (adjacenyList.isEmpty()) {
            return false;
        } else {
            for (T t : adjacenyList) {
                if (t.equals(w) && !visitedVertex.get(t)) {
                    return true;
                } else {
                    for (Map.Entry<T, Boolean> me : visitedVertex.entrySet()) {
                        if (t.equals(me.getKey()) && !visitedVertex.get(t)) {
                            me.setValue(true);
                            if (exersise_a_helper(visitedVertex, graph, t, w)) {
                                return true;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean exercise_b(Graph<T> graph, T v) {
        if(graph.order() <= 1) return false;
        List<T> adjacencyList = graph.getAdjacencyList(v);
        for (T t : adjacencyList) {
            List<T> adjacencyListOfAVertexAdjacentToV = graph.getAdjacencyList(t);
            for (T value : adjacencyListOfAVertexAdjacentToV) {
                if (!value.equals(v) && graph.hasEdge(v, value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean exercise_c(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_d(Graph<T> graph) {
        if (graph.order() == 0) return false;

        int counter = 1;
        List<T> vertexes = graph.getVertexes();
        HashMap<T,Boolean> visitedVertex = new HashMap<>();
        for (int i = 0 ; i< graph.getVertexes().size(); i++) {
            visitedVertex.put(graph.getVertexes().get(i),false);
        }

        for (int i = 0; i < vertexes.size(); i++) {
            List<T> adjacencyList = graph.getAdjacencyList(vertexes.get(i));
            if (i == 0) {
                visitedVertex.replace(vertexes.get(i), true);
            }
            for (int j = 0; j < adjacencyList.size(); j++) {
                if (!visitedVertex.get(adjacencyList.get(j))) {
                    if (adjacencyList.size() == 1 && visitedVertex.get(vertexes.get(i))) {
                        visitedVertex.replace(adjacencyList.get(j), true);
                    } else {
                        visitedVertex.replace(adjacencyList.get(j), true);
                        counter++;
                    }
                }
            }
        }
        return counter == vertexes.size();
    }

    @Override
    public int exercise_e(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph,T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_g(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_h(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_i(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_j(Graph<T> g1, Graph<T> g2) {
        if(g1.order()!=g2.order()) {
            return false;
        }

        List<T> g1Vs = g1.getVertexes();
        List<T> g2Vs = g2.getVertexes();

        if(!g1Vs.containsAll(g2Vs)) {
            return false;
        }

        for (int k = 0; k < g2Vs.size() ; k++) {
            List<T> adys = g2.getAdjacencyList(g2Vs.get(k));
            for (int n = 0; n < adys.size(); n++) {
                if (!g1.hasEdge(g2Vs.get(k),adys.get(n))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean exercise_k(Graph<T> g1) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_l(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_m(Graph<T> graph, T v) {
        List<T> adjacencyList = graph.getAdjacencyList(v);
        if(adjacencyList.contains(v)) return adjacencyList.size()+1;
        else return adjacencyList.size();
    }

    @Override
    public Map<T, Integer> exercise_n(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

}
