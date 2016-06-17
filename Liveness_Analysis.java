import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Shike Feng on 13-Dec-15.
 */
public class Liveness_Analysis {

    ArrayList<Analysis> analyze_data;
    int identical;
    String filename;
    HashMap<String, Integer> lable_lookup;
    HashMap<Integer, String> succesors;
    public Liveness_Analysis(String filename){
        this.filename = filename;
        this.analyze_data = new ArrayList<>();
        this.lable_lookup = new HashMap<>();
        this.succesors = new HashMap<>();
    }

    public void initialize(){
        try {
            File name = new File(filename);
            Scanner in = new Scanner(name);
            int linecounter = 0;
            String[] buffer1;
            String[] buffer2;
            while (true) {
                buffer1 = in.nextLine().split("\\s+");
                ArrayList<String> use = new ArrayList<>();
                if (buffer1[0].equals("HALT")) {
                    analyze_data.add(new Analysis(linecounter, use, "NULL","HALT"));
                    linecounter++;
                    break;
                } else {
                    if (buffer1[0].startsWith("n") || buffer1[0].startsWith("L")&&!buffer1[0].equals("LOAD")) {
                        analyze_data.add(new Analysis(linecounter, use, "NULL",buffer1[0]));
                        analyze_data.get(linecounter).successor.add(linecounter+1);
                        lable_lookup.put(buffer1[0], linecounter);
                        linecounter++;
                    } else {
                        switch (buffer1[0]) {
                            case "ADD":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "SUB":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "MUL":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "DIV":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "XOR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "ADDR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "SUBR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "MULR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "DIVR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                use.add(buffer2[2]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "ADDI":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "SUBI":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "MULI":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "DIVI":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "MOVIR":
                                buffer2 = buffer1[1].split(",");
                                analyze_data.add((new Analysis(linecounter, use, buffer2[0], buffer1[0])));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "ITOR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "RTOI":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                            case "RD":
                                analyze_data.add(new Analysis(linecounter, use, buffer1[1], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "WR":
                                use.add(buffer1[1]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "WRS":
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "WRR":
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "LOAD":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "STORE":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                use.add(buffer2[1]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                            case "JMP":
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                succesors.put(linecounter, buffer1[1]+":");
                                linecounter++;
                                break;
                            case "IADDR":
                                buffer2 = buffer1[1].split(",");
                                analyze_data.add(new Analysis(linecounter, use, buffer2[0], buffer1[0]));
                                linecounter++;
                                break;
                            case "BGEZ":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "BGEZR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "BLTZ":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "BLTZR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "BEQZ":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "BEQZR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "BNEZ":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "BNEZR":
                                buffer2 = buffer1[1].split(",");
                                use.add(buffer2[0]);
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter+1);
                                succesors.put(linecounter, buffer2[1]+":");
                                linecounter++;
                                break;
                            case "NOP":
                                analyze_data.add(new Analysis(linecounter, use, "NULL", buffer1[0]));
                                analyze_data.get(linecounter).successor.add(linecounter + 1);
                                linecounter++;
                                break;
                        }
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        for (int i : succesors.keySet()){
            String label = succesors.get(i);
            int succ = lable_lookup.get(label);
            analyze_data.get(i).successor.add(succ);

        }
    }

    public void backup(int number){
        analyze_data.get(number).backUp();
    }

    public void update_out(int number){
        if (analyze_data.get(number).successor.size()!=0){
            for (int i: analyze_data.get(number).successor){
                analyze_data.get(number).out.addAll(analyze_data.get(i).in);
            }
        }
    }

    public void update_in(int number){
        analyze_data.get(number).update_in();
    }

    public void process(){
        int temp = analyze_data.size()-1;
        for (int i = temp-1; i>=0; i--){
            backup(i);
            update_out(i);
            update_in(i);
        }
    }

    public void repeat(){
        do{
            identical = 0;
            process();
            int temp = analyze_data.size();
            for (int i = 0; i< temp; i++){
                if (analyze_data.get(i).identical()){
                    identical++;
                }
            }
        }while (identical != analyze_data.size());
    }
}
