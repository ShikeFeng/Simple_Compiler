import java.util.HashSet;

/**
 * Created by Shike Feng on 17-Dec-15.
 */
public class Node {
    private String name;
    private HashSet<String> out;
    private HashSet<String> neighbours;


    public Node(String name, HashSet<String> out){
        this.name = name;
        this.out = new HashSet<>();
        this.neighbours = new HashSet<>();
        this.out.addAll(out);
        if (out.contains(name)){
            out.remove(name);
        }
    }

    public String getName(){
        return name;
    }
    public HashSet<String> getOut(){
        return out;
    }
    public HashSet<String> getNeighbours() {
        return neighbours;
    }
}
