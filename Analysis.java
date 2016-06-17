import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Shike Feng on 13-Dec-15.
 */
public class Analysis {

    public int statement_number;
    public String operation;
    public HashSet<String> in_pre;
    public HashSet<String> out_pre;
    public HashSet<String> in;
    public HashSet<String> out;
    public HashSet<String> use;
    public String def;
    public HashSet<Integer> successor;

    public Analysis(int statement_number, ArrayList<String> use, String def, String operation) {
        this.in_pre = new HashSet<>();
        this.out_pre = new HashSet<>();
        this.in = new HashSet<>();
        this.out = new HashSet<>();
        this.use = new HashSet<>();
        this.successor = new HashSet<>();
        this.statement_number = statement_number;
        this.def = def;
        this.use.addAll(use);
        this.operation = operation;
    }

    public void backUp(){
        in_pre.clear();
        out_pre.clear();
        in_pre.addAll(in);
        out_pre.addAll(out);
    }

    public boolean identical(){
        return in_pre.equals(in)&&out_pre.equals(out);
    }

    public void update_in(){
        in.clear();
        in.addAll(use);
        HashSet<String> buffer = new HashSet<>();
        buffer.addAll(out);
        if(buffer.contains(def)){
            buffer.remove(def);
        }
        in.addAll(buffer);
    }




}
