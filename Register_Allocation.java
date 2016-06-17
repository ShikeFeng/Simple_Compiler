import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Shike Feng on 17-Dec-15.
 */
public class Register_Allocation {
    public Interference_graph graph;
    public HashMap<String, Integer> result;
    public ArrayList<Edge> edges;
    public ArrayList<Node> candidates;
    public ArrayList<Node> removed;

    public Register_Allocation(Interference_graph graph){
        this.graph = graph;
        this.result = new HashMap<>();
        this.edges = new ArrayList<>();
        this.candidates = new ArrayList<>();
        this.removed = new ArrayList<>();
    }


    public void construct_graph(){
        // Liveness analysis
        graph.getData().initialize();
        graph.getData().repeat();
        for (Analysis a: graph.getData().analyze_data) {
            if (!a.def.equals("NULL")){
                HashSet<String> buffer = new HashSet<>();
                buffer.addAll(a.out);
                if (buffer.contains(a.def)){
                    buffer.remove(a.def);
                }
                graph.getNodes().add(new Node(a.def, buffer));
            }
        }
        //Every node has a def and a set of out.
        // for all statements, add def-out into edges
        for (Node node: graph.getNodes()){
            String name = node.getName();
            for (String s : node.getOut()){
                    Edge edge = new Edge(name, s);
                    if (!exist_edge(edge)){
                        graph.getEdges().add(edge);
                    }

            }
            candidates.add(node);
        }
        edges.addAll(graph.getEdges());

        //complete neighbour set for every node
        for(Node node : candidates){
            String name = node.getName();
            for (Edge edge: edges){
                if (edge.getR1().equals(name)){
                    node.getNeighbours().add(edge.getR2());
                } else if (edge.getR2().equals(name)){
                    node.getNeighbours().add(edge.getR1());
                }
            }
        }


    }

    public boolean exist_edge(Edge e){
        for (Edge a : graph.getEdges()){
            if (e.getR1().equals(a.getR1()) && e.getR2().equals(a.getR2())){
                return true;
            } else if (e.getR2().equals(a.getR1()) && e.getR1().equals(a.getR2())){
                return true;
            }
        }
        return false;
    }

    public boolean hasColoredNeighbour(Node node){
       for (Node node1 : candidates){
           if (node.getNeighbours().contains(node1.getName())){
               return true;
           }
       }
        return false;
    }

    public void graph_coloring(){
        while(candidates.size() > 0){
            Node temp = candidates.get(0);
            removed.add(temp);
            candidates.remove(0);
        }
        while(removed.size() > 0 ){
            Node temp = removed.get(0);
            if (hasColoredNeighbour(temp)){
                int max_color = Integer.MIN_VALUE;
                int min_color = Integer.MAX_VALUE;
                for (String neighbour: temp.getNeighbours()){
                    if (result.get(neighbour) != null){
                        if (result.get(neighbour) > max_color){
                            max_color = result.get(neighbour);
                        }
                        if(result.get(neighbour) < min_color){
                            min_color = result.get(neighbour);
                        }
                    }
                }
                if (min_color != 0){
                    result.put(temp.getName(), min_color - 1);
                } else {
                    result.put(temp.getName(), max_color + 1);
                }
            } else {
                result.put(temp.getName(), 0);
            }
            candidates.add(temp);
            removed.remove(0);
        }
    }
}
