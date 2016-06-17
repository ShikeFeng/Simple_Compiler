import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shike Feng on 17-Dec-15.
 */
public class FileReplace {
    ArrayList<String> lines;

    String filename;
    String line;
    HashMap<String, String> match_table;
    public FileReplace(String filename, HashMap<String,String> match_table){
        this.filename = filename;
        this.lines = new ArrayList<>();
        this.line = null;
        this.match_table = match_table;
    }

    public void replaceFile(){
        try{
            File f1 = new File(filename);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line=br.readLine())!= null){
                String newline = "";
                if (!line.equals("HALT")){
                    String[] buffer1 = line.split("\\s+");
                    newline += buffer1[0] + " ";
                    if (buffer1.length > 1){
                        String[] buffer2 = buffer1[1].split(",");
                        if (buffer2.length == 1){
                            if(buffer2[0].startsWith("R")){
                                buffer2[0] = match_table.get(buffer2[0]);
                            }
                            newline += buffer2[0];
                        } else {
                            for (int i = 0; i<buffer2.length; i++){
                                if (buffer2[i].startsWith("R")){
                                    buffer2[i]= match_table.get(buffer2[i]);
                                }
                                if (i == 0){
                                    newline += buffer2[i];
                                } else {
                                    newline += ","+buffer2[i];
                                }
                            }
                        }
                    }
                } else {
                    newline += line;
                }
                lines.add(newline);
                /*for (String pattern : match_table.keySet()){
                    if (line.contains(pattern)){
                        line = line.replace(pattern, match_table.get(pattern));
                    }
                }
                lines.add(line);*/
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for (String s : lines){
                out.write(s);
                out.newLine();
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
