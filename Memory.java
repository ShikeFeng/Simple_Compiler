// COMS22201: Memory allocation for strings

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Memory {

  static ArrayList<Byte> memory = new ArrayList<Byte>();
  static HashMap<String, Integer> variableTable = new HashMap<String, Integer>();
  static HashMap<String, Integer> realVariableTable = new HashMap<String, Integer>();
  static int a = Memory.allocateString("true");
  static int b = Memory.allocateString("false");
  static public int allocateVar(String text) {
    Integer addr = variableTable.get(text);
    if (addr != null) {
      return addr;
    } else {
      while(memory.size() % 4 != 0) {
        allocateString("");
      }
      addr = memory.size();
      variableTable.put(text,addr);
      for (int i = 4; i> 0; i--) {
         memory.add(new Byte(text, 0));
      }
        return addr;
      }
    }

  static public int allocateRealVar(String text) {
    Integer addr = realVariableTable.get(text);
    if (addr != null) {
      return addr;
    } else {
      while(memory.size() % 4 != 0) {
        allocateString("");
      }
      addr = memory.size();
      realVariableTable.put(text,addr);
      for (int i = 4; i> 0; i--) {
         memory.add(new Byte(text, 0));
      }
        return addr;
      }
  }

  static public int realOrInt(String text) {
    Integer real = realVariableTable.get(text);
    Integer intnum = variableTable.get(text);
    if (real != null && intnum == null){
      return 0;
    } else if (real == null && intnum != null){
      return 1;
    } else {
      return 2;
    }
  }
  static public int allocateString(String text)
  {
    int addr = memory.size();
    int size = text.length();
    for (int i=0; i<size; i++) {
      memory.add(new Byte("", text.charAt(i)));
    }
    memory.add(new Byte("", 0));
    return addr;
  }

  static public void dumpData(PrintStream o)
  {
    Byte b;
    String s;
    int c;
    int size = memory.size();
    for (int i=0; i<size; i++) {
      b = memory.get(i);
      c = b.getContents();
      if (c >= 32) {
        s = String.valueOf((char)c);
      }
      else {
        s = ""; // "\\"+String.valueOf(c);
      }
      o.println("DATA "+c+" ; "+s+" "+b.getName());
    }
  }
}

class Byte {
  String varname;
  int contents;

  Byte(String n, int c)
  {
    varname = n;
    contents = c;
  }

  String getName()
  {
    return varname;
  }

  int getContents()
  {
    return contents;
  }
}
