// COMS22201: Code generation

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Cg
{
  static int registerCounter = 0;
  static int boolCounter = 0;
  public static void program(IRTree irt, PrintStream o)
  {
    emit(o, "XOR R0,R0,R0");   // Initialize R0 to 0       R0 is always equal to 0
    statement(irt, o);
    emit(o, "HALT");           // Program must end with HALT
    Memory.dumpData(o);        // Dump DATA lines: initial memory contents
  }

  private static void statement(IRTree irt, PrintStream o)
  {
    if (irt.getOp().equals("SEQ")) {
      statement(irt.getSub(0), o);
      statement(irt.getSub(1), o);
    }
    else if(irt.getOp().equals("CJUMP")){
      cjump(irt, o);
    }
    else if(irt.getOp().equals("LABEL")){
      String e1 = irt.getSub(0).getOp();
      emit(o, e1+":");
    }
    else if(irt.getOp().equals("JUMP")){
      String e1 = irt.getSub(0).getSub(0).getOp();
      emit(o, "JMP "+e1);
    }
    else if(irt.getOp().equals("SKIP")){
      emit(o,"NOP");
    }
    else if (irt.getOp().equals("WRS") ){
      int register_before = registerCounter;
      if(irt.getSub(0).getOp().equals("MEM") && irt.getSub(0).getSub(0).getOp().equals("CONST")) {
      String a = irt.getSub(0).getSub(0).getSub(0).getOp();
      emit(o, "WRS "+a);
      } else {
      String a = boolExp(irt.getSub(0), o);
      int type = typeCheck(irt);
      //if the register value is greater than 0, branch to write true
      //if the register value is less than or equal to 0, branch to write false
      String label1 = "L"+Integer.toString(boolCounter+1);
      boolCounter++;
      String label2 = "L"+Integer.toString(boolCounter+1);
      boolCounter++;
      String label3 = "L"+Integer.toString(boolCounter+1);
      boolCounter++; 
      if (type == 1){
        emit(o, "BEQZ "+a+","+label2);
        emit(o, "BLTZ "+a+","+label2);
        emit(o, "BNEZ "+a+","+label1);
      } else {
        emit(o, "BEQZR "+a+","+label2);
        emit(o, "BLTZR "+a+","+label2);
        emit(o, "BNEZR "+a+","+label1);
      }
      emit(o, label1+":");
      emit(o, "WRS "+Integer.toString(Memory.a));
      emit(o, "JMP "+label3);
      emit(o, label2+":");
      emit(o, "WRS "+Integer.toString(Memory.b));
      emit(o, label3+":");
      }
      registerCounter = register_before;
    }
    else if (irt.getOp().equals("WR")) {
      int register_before = registerCounter;
      String e = expression(irt.getSub(0), o);
      emit(o, "WR "+e);
      registerCounter = register_before;
    }
    else if (irt.getOp().equals("WRR")) {
      int register_before = registerCounter;
      String e = expression(irt.getSub(0), o);
      emit(o, "WRR "+e);
      registerCounter = register_before;
    }
    else if (irt.getOp().equals("MOVE")) {
      String e1 = getVariable(irt.getSub(0), o);
      String e2 = expression(irt.getSub(1), o);
      emit(o, "STORE "+ e2 +","+e1+","+0);
    }
    else if (irt.getOp().equals("READ")) {
      String e1 = getVariable(irt.getSub(0), o);
      String readin = "R" + Integer.toString(registerCounter + 1);
      registerCounter ++;
      emit(o, "RD "+ readin);
      emit(o, "STORE "+ readin +","+e1+","+0);
    }
    else {
      error(irt.getOp());
    }
  }

// True: >0
// FAlse: <=0
  private static String boolExp(IRTree irt, PrintStream o){   
    String result = "";
    String sub1 = "";
    String sub2 = "";
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    if (irt.getOp().equals("true")){ 
      emit(o, "ADDI "+result+",R0,"+1);
    } else if (irt.getOp().equals("false")){
      emit(o, "ADDI "+result+",R0,"+0);
    } else if (irt.getOp().equals("AND")) {
      sub1 = boolExp(irt.getSub(0), o);
      sub2 = boolExp(irt.getSub(1), o);
      emit(o, "MUL "+result+","+sub1+","+sub2);
    } else if (irt.getOp().equals("OR")) {
      sub1 = boolExp(irt.getSub(0), o);
      sub2 = boolExp(irt.getSub(1), o);
      emit(o, "ADD "+result+","+sub1+","+sub2);
    } else if (irt.getOp().equals("NOT")){
      sub1 = boolExp(irt.getSub(0), o);
      emit(o, "MULI "+result+","+sub1+","+(-1));
      emit(o, "ADDI "+result+","+result+","+1);
    } else if (irt.getOp().equals("EQ")){
      sub1 = aMinusB(irt, o);
      sub2 = bMinusA(irt, o);
      emit(o, "MUL "+result+","+sub1+","+sub2);
      emit(o, "ADDI "+result+","+result+","+1);
    } else if (irt.getOp().equals("LEQ")){
      sub1 = bMinusA(irt, o);
      emit(o, "ADDI "+result+","+sub1+","+1);
    } else if(irt.getOp().equals("LES")){
      sub1 = bMinusA(irt, o);
      emit(o, "ADD "+result+","+sub1+",R0");
    } else if (irt.getOp().equals("GRT")){
      int type = typeCheck(irt);
      sub1 = aMinusB(irt, o);
      if (type == 0){
        String real_0 = "";
        real_0 = "R"+ Integer.toString(registerCounter + 1);
        registerCounter ++;
        emit(o, "ITOR "+real_0+",R0");
        emit(o, "ADDR "+result+","+sub1+","+real_0);
      } else {
        emit(o, "ADD "+result+","+sub1+",R0");
      }
      
    } else if (irt.getOp().equals("GEQ")){
      sub1 = aMinusB(irt, o);
      int type = typeCheck(irt);
      if (type == 0){
        String buffer = "";
        buffer = "R"+ Integer.toString(registerCounter + 1);
        registerCounter ++;
        emit(o, "ADDI "+buffer+",R0,"+1);
        emit(o, "ITOR "+buffer+","+buffer);
        emit(o, "ADDR "+result+","+sub1+","+buffer);
      } else {
        emit(o, "ADDI "+result+","+sub1+","+1);
      }
    } else if (irt.getOp().equals("NEQ")){
      sub1 = aMinusB(irt, o);
      sub2 = bMinusA(irt, o);
      int type = typeCheck(irt);
      if (type == 1){
        emit(o, "MUL "+result+","+sub1+","+sub2);
        emit(o, "MULI "+result+","+result+","+(-1));
      } else {
        emit(o, "MULR "+result+","+sub1+","+sub2);
        String real_n1 = "R"+ Integer.toString(registerCounter + 1);
        registerCounter ++;
        emit(o, "ADDI "+real_n1+",R0,-1");
        emit(o, "ITOR "+real_n1+","+real_n1);
        emit(o, "MULR "+result+","+result+","+real_n1);
      }
     
    }
    return result;
  }

  private static String aMinusB(IRTree irt, PrintStream o){
    String result = "";
    int type1 = typeCheck(irt.getSub(0));
    int type2 = typeCheck(irt.getSub(1));
    String e1 = expression(irt.getSub(0), o);
    String e2 = expression(irt.getSub(1), o);
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    if (type1 == 0 && type2 == 0){
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else if (type1 == 1 && type2 == 0){
      emit(o, "ITOR "+e1+","+e1);
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else if (type1 == 0 && type2 == 1){
      emit(o, "ITOR "+e2+","+e2);
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else {
      emit(o, "SUB "+result+","+e1+","+e2);
    }
    return result;      
  }

  private static String bMinusA(IRTree irt, PrintStream o) {
   String result = "";
    int type1 = typeCheck(irt.getSub(1));
    int type2 = typeCheck(irt.getSub(0));
    String e1 = expression(irt.getSub(1), o);
    String e2 = expression(irt.getSub(0), o);
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    if (type1 == 0 && type2 == 0){
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else if (type1 == 1 && type2 == 0){
      String temp = "R" + Integer.toString(registerCounter + 1);
      registerCounter ++;
      emit(o, "ITOR "+e1+","+e1);
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else if (type1==0 && type2 == 1){
      String temp = "R" + Integer.toString(registerCounter + 1);
      registerCounter ++;
      emit(o, "ITOR "+e2+","+e2);
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else {
      emit(o, "SUB "+result+","+e1+","+e2);
    }
    return result;
  }

  private static void cjump(IRTree irt, PrintStream o){
    String e3 = irt.getSub(1).getSub(0).getOp();
    String e4 = irt.getSub(2).getSub(0).getOp();
    String result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
      result = boolExp(irt.getSub(0), o);     
      emit(o, "BEQZ "+result+","+e4);
      emit(o, "BLTZ "+result+","+e4);
      emit(o, "BNEZ "+result+","+e3);
  }

  private static String expression(IRTree irt, PrintStream o)
  {
    String result = "";
    if (irt.getOp().equals("CONST")){
      result = constant(irt, o);
    } else if(irt.getOp().equals("REAL")){
      result = realnum(irt, o);
    } else if(irt.getOp().equals("MEM") || irt.getOp().equals("MEMR")){
      result = loadVariable(irt, o);
    } else if(irt.getOp().equals("+")){
      result = addition(irt, o);
    } else if(irt.getOp().equals("-")){
      result = subtraction(irt, o);
    } else if (irt.getOp().equals("*")){
      result = multiplication(irt, o);
    } else if (irt.getOp().equals("/")){
      result = division(irt, o);
    } else if (irt.getOp().equals("^")){
      result = xor(irt, o);
    }
    else {
      error(irt.getOp());
    }
    return result;
  }

  private static int typeCheck(IRTree irt) {
    IRTree irt1 = new IRTree();
    String root = irt.getOp();
    if (root.equals("MEMR")){
      return 0;
    } else if (root.equals("REAL")){
      return 0;
    } else {
      int childnum = irt.getSubSize();
      if (childnum != 0) {
        for (int i = 0; i<childnum; i++){
          irt1 = irt.getSub(i);
          int temp = typeCheck(irt1);
          if (temp == 0){
            return 0;
          }
        }  
      }
      return 1;
    }
  }

  private static String addition(IRTree irt, PrintStream o){
    String result = "";
    int type1 = typeCheck(irt.getSub(0));
    int type2 = typeCheck(irt.getSub(1));
    String e1 = expression(irt.getSub(0), o);
    String e2 = expression(irt.getSub(1), o);
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    if (type1 == 0 && type2 == 0){
      emit(o, "ADDR "+result+","+e1+","+e2);
    } else if (type1 == 1 && type2 == 0){
      emit(o, "ITOR "+e1+","+e1);
      emit(o, "ADDR "+result+","+e1+","+e2);
    } else if (type1 == 0 && type2 == 1){
      emit(o, "ITOR "+e2+","+e2);
      emit(o, "ADDR "+result+","+e1+","+e2);
    }
    else {
      emit(o, "ADD "+result+","+e1+","+e2);
    }
    
    
    return result;
  }

  private static String subtraction(IRTree irt, PrintStream o){
    String result = "";
    int type1 = typeCheck(irt.getSub(0));
    int type2 = typeCheck(irt.getSub(1));
    String e1 = expression(irt.getSub(0), o);
    String e2 = expression(irt.getSub(1), o);
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    if (type1 == 0 && type2 == 0){
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else if (type1 == 1 && type2 == 0){
      emit(o, "ITOR "+e1+","+e1);
      emit(o, "SUBR "+result+","+e1+","+e2);
    } else if (type1 == 0 && type2 == 1){
      emit(o, "ITOR "+e1+","+e2);
      emit(o, "SUBR "+result+","+e1+","+e1);
    } else {
      emit(o, "SUB "+result+","+e1+","+e2);
    }
    return result;
  }
  
  private static String multiplication(IRTree irt, PrintStream o){
    String result = "";
    int type1 = typeCheck(irt.getSub(0));
    int type2 = typeCheck(irt.getSub(1));
    String e1 = expression(irt.getSub(0), o);
    String e2 = expression(irt.getSub(1), o);
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    if (type1 == 0 && type2 == 0){
      emit(o, "MULR "+result+","+e1+","+e2);
    } else if (type1 == 1 && type2 == 0){
      emit(o, "ITOR "+e1+","+e1);
      emit(o, "MULR "+result+","+e1+","+e2);
    } else if (type1 == 0 && type2 == 1){
      emit(o, "ITOR "+e2+","+e2);
      emit(o, "MULR "+result+","+e1+","+e2);
    } else {
      emit(o, "MUL "+result+","+e1+","+e2);
    }
    return result;
  }
  //Extra language feature: division
  private static String division(IRTree irt, PrintStream o){
    String result = "";
    int type1 = typeCheck(irt.getSub(0));
    int type2 = typeCheck(irt.getSub(1));
    String e1 = expression(irt.getSub(0), o);
    String e2 = expression(irt.getSub(1), o);
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    if (type1 == 0 && type2 == 0){
      emit(o, "DIVR "+result+","+e1+','+e2);
    } else if (type1 == 1 && type2 == 0){
      emit(o, "ITOR "+e1+","+e1);
      emit(o, "DIVR "+result+","+e1+","+e2);
    } else if (type1 == 0 && type2 == 1){
      emit(o, "ITOR "+e2+","+e2);
      emit(o, "DIVR "+result+","+e1+","+e2);
    } else {
      emit(o, "ITOR "+e1+","+e1);
      emit(o, "ITOR "+e2+","+e2);
      emit(o, "DIVR "+result+","+e1+","+e2);
    }
    return result;
  }
  //Extra language feature: exclusive or
  private static String xor(IRTree irt, PrintStream o){
    String result = "";
    String e1 = expression(irt.getSub(0), o);
    String e2 = expression(irt.getSub(1), o);
    result = "R" + Integer.toString(registerCounter + 1);
    registerCounter ++;
    emit(o, "XOR "+result+","+e1+","+e2);
    return result;
  }
  private static String constant(IRTree irt, PrintStream o){
      String result = "";
      String t = irt.getSub(0).getOp();
      result = "R"+ Integer.toString(registerCounter+1);
      registerCounter ++;
      emit(o, "ADDI "+result+",R0,"+t);
      return result;
  }
  private static String realnum(IRTree irt, PrintStream o){
    String result = "";
    String t = irt.getSub(0).getOp();
    result = "R"+ Integer.toString(registerCounter+1);
    registerCounter ++;
    emit(o, "MOVIR "+result+","+t);
    return result;
  }
  private static String getVariable(IRTree irt, PrintStream o){
      String result = "";
      String t = irt.getSub(0).getOp();
      result = "R" + Integer.toString(registerCounter + 1);
      registerCounter ++;
      emit(o,"ADDI "+result+",R0,"+t);
      return result;
  }

  private static String loadVariable(IRTree irt, PrintStream o){
     String result = "";
     String var = getVariable(irt, o);
     result = "R" + Integer.toString(registerCounter + 1);
     registerCounter ++;
     emit(o,"LOAD "+result+","+ var+","+0);
     return result;
  }

  private static void emit(PrintStream o, String s)
  {
    o.println(s);
  }

  private static void error(String op)
  {
    System.out.println("CG error: "+op);
    System.exit(1);
  }
}
