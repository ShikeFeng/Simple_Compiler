import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Shike Feng on 17-Dec-15.
 */
public class Interference_graph {
    private Liveness_Analysis data;
    private HashSet<Edge> edges;
    private ArrayList<Node> nodes;


    public Interference_graph(Liveness_Analysis data){
        this.data = data;
        this.edges = new HashSet<>();
        this.nodes = new ArrayList<>();
        }

    public Liveness_Analysis getData(){
        return data;
    }
    public HashSet<Edge> getEdges(){
        return edges;
    }
    public ArrayList<Node> getNodes(){
        return nodes;
    }



}
