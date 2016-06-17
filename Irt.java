// COMS22201: IR tree construction

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Irt
{
// The code below is generated automatically from the ".tokens" file of the 
// ANTLR syntax analysis, using the TokenConv program.
//
// CAMLE TOKENS BEGIN
  public static final String[] tokenNames = new String[] {
"NONE", "NONE", "NONE", "NONE", "ADD", "AND", "ASSIGN", "BITXOR", "CLOSEPAREN", "COMMENT", "DIVIDE", "DO", "ELSE", "EQ", "FALSE", "FLOAT", "GEQ", "GRT", "IDENTIFIER", "IF", "INTNUM", "LEQ", "LES", "MULTIPLY", "NEQ", "NOT", "OPENPAREN", "OR", "READ", "SEMICOLON", "SKIP", "STRING", "SUB", "SUBID", "THEN", "TRUE", "WHILE", "WRITE", "WRITELN", "WS"};
  public static final int ADD=4;
  public static final int AND=5;
  public static final int ASSIGN=6;
  public static final int BITXOR=7;
  public static final int CLOSEPAREN=8;
  public static final int COMMENT=9;
  public static final int DIVIDE=10;
  public static final int DO=11;
  public static final int ELSE=12;
  public static final int EQ=13;
  public static final int FALSE=14;
  public static final int FLOAT=15;
  public static final int GEQ=16;
  public static final int GRT=17;
  public static final int IDENTIFIER=18;
  public static final int IF=19;
  public static final int INTNUM=20;
  public static final int LEQ=21;
  public static final int LES=22;
  public static final int MULTIPLY=23;
  public static final int NEQ=24;
  public static final int NOT=25;
  public static final int OPENPAREN=26;
  public static final int OR=27;
  public static final int READ=28;
  public static final int SEMICOLON=29;
  public static final int SKIP=30;
  public static final int STRING=31;
  public static final int SUB=32;
  public static final int SUBID=33;
  public static final int THEN=34;
  public static final int TRUE=35;
  public static final int WHILE=36;
  public static final int WRITE=37;
  public static final int WRITELN=38;
  public static final int WS=39;
// CAMLE TOKENS END
  public static int labelCounter = 1;



  public static IRTree convert(CommonTree ast)
  {
    IRTree irt = new IRTree();
    program(ast, irt);
    return irt;
  }

  public static void program(CommonTree ast, IRTree irt)
  {
    statements(ast, irt);
  }

  public static void statements(CommonTree ast, IRTree irt)
  {
    int i;
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == SEMICOLON) {
      IRTree irt1 = new IRTree();
      IRTree irt2 = new IRTree();
      CommonTree ast1 = (CommonTree)ast.getChild(0);
      CommonTree ast2 = (CommonTree)ast.getChild(1);
      statements(ast1, irt1);
      statements(ast2, irt2);
      irt.setOp("SEQ");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
    else {
      statement(ast, irt);
    }
  }

  public static void statement(CommonTree ast, IRTree irt)
  {
    CommonTree ast1, ast2, ast3;
    IRTree irt1 = new IRTree(), irt2 = new IRTree(), irt3 = new IRTree();
    IRTree irt4 = new IRTree(), irt5 = new IRTree(), irt6 = new IRTree();
    IRTree irt7 = new IRTree(), irt8 = new IRTree(), irt9 = new IRTree();
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == WRITE) {
      ast1 = (CommonTree)ast.getChild(0);
      String type = arg(ast1, irt1);
      if (type.equals("int")) {
        irt.setOp("WR");
        irt.addSub(irt1);
      } 
      else if (type.equals("real")) {
      	irt.setOp("WRR");
      	irt.addSub(irt1);
      }
      else if (type.equals("bool")) {
      	irt.setOp("WRS");
      	irt.addSub(irt1);
      } else if (type.equals("error")){
      	error(tt);
      }
      else {
        irt.setOp("WRS");
        irt.addSub(irt1);
      }
    }
    else if (tt == WRITELN) {
      String a = String.valueOf(Memory.allocateString("\n"));
      irt.setOp("WRS");
      irt.addSub(new IRTree("MEM", new IRTree("CONST", new IRTree(a))));
    }
    else if (tt == ASSIGN) {
      ast1 = (CommonTree) ast.getChild(0);
      ast2 = (CommonTree) ast.getChild(1);
      irt.setOp("MOVE");
      expression(ast2, irt2);
      String type = typeChecking(ast2);
      if (type.equals("int")){
      	variable(ast1, irt1);
      } else {
      	realVariable(ast1, irt1);
      }
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
    else if (tt == READ) {
      ast1 = (CommonTree) ast.getChild(0);
      irt.setOp("READ");
      variable(ast1, irt1);
      irt.addSub(irt1);
    }
    else if (tt == IF) {
    	ast1 = (CommonTree) ast.getChild(0); // The first child is a BoolExp;
    	ast2 = (CommonTree) ast.getChild(1); // The second child is a statement / statements
    	ast3 = (CommonTree) ast.getChild(2); // The third child is also a statement / statements
    	irt.setOp("SEQ");
    	irt.addSub(irt4);
    	boolexp(ast1, irt1);
    	statements(ast2,irt2);
    	statements(ast3,irt3);
    	irt4.setOp("CJUMP");
    	irt4.addSub(irt1);
    	irt4.addSub(new IRTree("NAME", new IRTree("n"+Integer.toString(labelCounter))));
    	int buffer1 = labelCounter;
    	labelCounter++;
    	irt4.addSub(new IRTree("NAME", new IRTree("n"+Integer.toString(labelCounter))));
    	int buffer2 = labelCounter;
    	labelCounter++;
    	irt.addSub(irt5);
   		irt5.setOp("SEQ");
   		irt5.addSub(new IRTree("LABEL", new IRTree("n"+Integer.toString(buffer1))));
   		irt5.addSub(irt6);
   		irt6.setOp("SEQ");
   		irt6.addSub(irt2);
   		irt6.addSub(irt7);
   		irt7.setOp("SEQ");
   		irt7.addSub(new IRTree("JUMP", new IRTree("NAME", new IRTree("n"+Integer.toString(labelCounter)))));
   		int buffer3 = labelCounter;
   		labelCounter++;
   		irt7.addSub(irt8);
   		irt8.setOp("SEQ");
   		irt8.addSub(new IRTree("LABEL", new IRTree("n"+Integer.toString(buffer2))));
   		irt8.addSub(irt9);
   		irt9.setOp("SEQ");
   		irt9.addSub(irt3);
   		irt9.addSub(new IRTree("LABEL", new IRTree("n"+Integer.toString(buffer3))));
	}
    else if (tt == WHILE){
    	ast1 = (CommonTree) ast.getChild(0);
    	ast2 = (CommonTree) ast.getChild(1);
    	boolexp(ast1, irt1);
    	statements(ast2,irt2);
    	irt.setOp("SEQ");
    	irt.addSub(new IRTree("LABEL", new IRTree("n"+Integer.toString(labelCounter))));
    	int buffer1 = labelCounter;
    	labelCounter++;
    	irt.addSub(irt4);
    	irt4.setOp("SEQ");
    	irt4.addSub(irt3);
    	irt4.addSub(irt5);
    	irt3.setOp("CJUMP");
    	irt3.addSub(irt1);
    	irt3.addSub(new IRTree("NAME", new IRTree("n"+Integer.toString(labelCounter))));
    	int buffer2 = labelCounter;
    	labelCounter++;
    	irt3.addSub(new IRTree("NAME", new IRTree("n"+Integer.toString(labelCounter))));
    	int buffer3 = labelCounter;
    	labelCounter++;
    	irt5.setOp("SEQ");
    	irt5.addSub(new IRTree("LABEL", new IRTree("n"+Integer.toString(buffer2))));
    	irt5.addSub(irt6);
    	irt6.setOp("SEQ");
    	irt6.addSub(irt2);
    	irt6.addSub(irt7);
    	irt7.setOp("SEQ");
    	irt7.addSub(new IRTree("JUMP", new IRTree("NAME", new IRTree("n"+ Integer.toString(buffer1)))));
    	irt7.addSub(new IRTree("LABEL", new IRTree("n"+ Integer.toString(buffer3))));
    }     	
    else if (tt == SKIP){
    	irt.setOp("SKIP");
    }
    else {
      error(tt);
    }
  }

  public static String arg(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == TRUE || tt == FALSE || tt == NOT || tt == AND || tt == EQ || tt == LEQ ||tt == LES || tt == GRT || tt == GEQ || tt == NEQ || tt == OR) {
    	boolexp(ast, irt);
    	return "bool";
    }
    else if (tt == STRING) {
      String tx = t.getText();
      int a = Memory.allocateString(tx); 
      String st = String.valueOf(a);
      	irt.setOp("MEM");
      	irt.addSub(new IRTree("CONST", new IRTree(st)));
      return "string";
    }
    else {
    	String type = typeChecking(ast);
      	expression(ast, irt);
      	if (type.equals("real")) {
      		return "real";
      	} else if (type.equals("int")){
      		return "int";
      	} else {
      		error(tt);
      		return "error";
      	}
    }
  }

  public static String typeChecking(CommonTree ast){
  	CommonTree ast1;
  	Token t = ast.getToken();
  	String tx = t.getText();
  	int tt = t.getType();
  	if (tt == IDENTIFIER){
		int type = Memory.realOrInt(tx);
    	if (type == 0){
    		return "real";
    	} else if(type == 1){
    		return "int";
    	} else {
    		return "error";
    	}
  	} else if (tt == FLOAT) {
  		return "real";
  	} else {
  		int childnum = ast.getChildCount();
  			for (int i = 0; i < childnum; i++){
  				ast1 = (CommonTree) ast.getChild(i);
  				String temp = typeChecking(ast1);
  				if (temp.equals("real") || temp.equals("MEMR")){
  					return "real";
  				}
  			}
  		return "int";
  	}
  }
  public static void expression(CommonTree ast, IRTree irt)
  {
    CommonTree ast1, ast2;
    IRTree irt1 = new IRTree();
    IRTree irt2 = new IRTree();
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == ADD) {
      ast1 = (CommonTree) ast.getChild(0);
      ast2 = (CommonTree) ast.getChild(1);
      term(ast1,irt1);
      expression(ast2,irt2);
      if(irt1.getOp().equals("CONST") && irt2.getOp().equals("CONST")){
      	irt.setOp("CONST");
      	int a = Integer.parseInt(irt1.getSub(0).getOp());
      	int b = Integer.parseInt(irt2.getSub(0).getOp());
      	int value = a+b;
      	irt.addSub(new IRTree(Integer.toString(value)));
      } else if (irt1.getOp().equals("CONST") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        int a = Integer.parseInt(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a+b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("CONST")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        int b = Integer.parseInt(irt2.getSub(0).getOp());
        double value = a+b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a+b;
        irt.addSub(new IRTree(Double.toString(value)));
      }
      else {
      		irt.setOp("+");
      		irt.addSub(irt1);
      		irt.addSub(irt2);
      	}
    } else if (tt == SUB) {
      ast1 = (CommonTree) ast.getChild(0);
      ast2 = (CommonTree) ast.getChild(1);
      term(ast1,irt1);
      expression(ast2,irt2);
      if(irt1.getOp().equals("CONST") && irt2.getOp().equals("CONST")){
      	irt.setOp("CONST");
      	int a = Integer.parseInt(irt1.getSub(0).getOp());
      	int b = Integer.parseInt(irt2.getSub(0).getOp());
      	int value = a-b;
      	irt.addSub(new IRTree(Integer.toString(value)));
      }  else if (irt1.getOp().equals("CONST") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        int a = Integer.parseInt(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a-b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("CONST")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        int b = Integer.parseInt(irt2.getSub(0).getOp());
        double value = a-b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a-b;
        irt.addSub(new IRTree(Double.toString(value)));
      }
      else {
      		irt.setOp("-");
      		irt.addSub(irt1);
      		irt.addSub(irt2);
      	}
    } else if (tt == BITXOR){
      ast1 = (CommonTree) ast.getChild(0);
      ast2 = (CommonTree) ast.getChild(1);
      term(ast1,irt1);
      expression(ast2,irt2);
      irt.setOp("^");
	    irt.addSub(irt1);
	    irt.addSub(irt2);
    }
    else {
      term(ast, irt);
    }
  }

  public static void constant(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == INTNUM) {
      String tx = t.getText();
      irt.setOp(tx);
    }
    else {
      error(tt);
    }
  }

  public static void realnumber(CommonTree ast, IRTree irt){
  	Token t = ast.getToken();
    int tt = t.getType();
    if (tt == FLOAT) {
      String tx = t.getText();
      irt.setOp(tx);
    }
    else {
      error(tt);
    }
  }

  public static void variable(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == IDENTIFIER) {
      String tx = t.getText();
      int a = Memory.allocateVar(tx); 
      String st = String.valueOf(a);
      irt.setOp("MEM");
      irt.addSub(new IRTree(st));
    } else {
    	error(tt);
    }
  }

  public static void realVariable(CommonTree ast, IRTree irt) {
  	Token t = ast.getToken();
    int tt = t.getType();
    if (tt == IDENTIFIER) {
      String tx = t.getText();
      int a = Memory.allocateRealVar(tx); 
      String st = String.valueOf(a);
      irt.setOp("MEMR");
      irt.addSub(new IRTree(st));
    } else {
    	error(tt);
    }
  }
  
  public static void term(CommonTree ast, IRTree irt)
  {
    CommonTree ast1, ast2;
    IRTree irt1 = new IRTree();
    IRTree irt2 = new IRTree();
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == MULTIPLY) {
      ast1 = (CommonTree)ast.getChild(0);
      ast2 = (CommonTree)ast.getChild(1);
      factor(ast1, irt1);
      term(ast2, irt2);
       if (irt1.getOp().equals("CONST") && irt2.getOp().equals("CONST")){
      	irt.setOp("CONST");
      	int a = Integer.parseInt(irt1.getSub(0).getOp());
      	int b = Integer.parseInt(irt2.getSub(0).getOp());
      	int value = a*b;
      	irt.addSub(new IRTree(Integer.toString(value)));
      } else if (irt1.getOp().equals("CONST") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        int a = Integer.parseInt(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a*b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("CONST")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        int b = Integer.parseInt(irt2.getSub(0).getOp());
        double value = a*b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a*b;
        irt.addSub(new IRTree(Double.toString(value)));
      }
      else {
	      	irt.setOp("*");
	      	irt.addSub(irt1);
	      	irt.addSub(irt2);
        }
      
    } else if (tt == DIVIDE) {
      ast1 = (CommonTree)ast.getChild(0);
      ast2 = (CommonTree)ast.getChild(1);
      factor(ast1, irt1);
      term(ast2, irt2);
      if (irt1.getOp().equals("CONST") && irt2.getOp().equals("CONST")){
      	irt.setOp("REAL");
      	int a = Integer.parseInt(irt1.getSub(0).getOp());
      	int b = Integer.parseInt(irt2.getSub(0).getOp());
        if (a%b == 0){
          irt.setOp("CONST");
          int value = a/b;
          irt.addSub(new IRTree(Integer.toString(value)));
        } else {
          irt.setOp("REAL");
          double value = (double)a/b;
          irt.addSub(new IRTree(Double.toString(value)));
        }
      	
      } else if (irt1.getOp().equals("CONST") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        int a = Integer.parseInt(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a/b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("CONST")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        int b = Integer.parseInt(irt2.getSub(0).getOp());
        double value = a/b;
        irt.addSub(new IRTree(Double.toString(value)));
      } else if (irt1.getOp().equals("REAL") && irt2.getOp().equals("REAL")){
        irt.setOp("REAL");
        double a = Double.parseDouble(irt1.getSub(0).getOp());
        double b = Double.parseDouble(irt2.getSub(0).getOp());
        double value = a/b;
        irt.addSub(new IRTree(Double.toString(value)));
      } 
      else {
	      irt.setOp("/");
	      irt.addSub(irt1);
	      irt.addSub(irt2);
        }
    }  
    else {
      factor(ast, irt);
    }
  }
  
  public static void factor(CommonTree ast, IRTree irt) 
  {
    IRTree irt1 = new IRTree();
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == INTNUM) {
      constant(ast, irt1);
      irt.setOp("CONST");
      irt.addSub(irt1);
    } else if (tt == FLOAT) {
		realnumber(ast, irt1);
		irt.setOp("REAL");
		irt.addSub(irt1);
    } else if (tt == IDENTIFIER) {
		 String tx = t.getText();    	
		 int type = Memory.realOrInt(tx);
    	if (type == 0){
    		realVariable(ast, irt);
    	} else if (type == 1){
    		variable(ast, irt);
    	} else {
    		error(tt);
    	}
    }
    else {
      expression(ast,irt);
    }
  }

  public static void booleanValue(CommonTree ast, IRTree irt)
  {
  	CommonTree ast1, ast2;
  	IRTree irt1 = new IRTree();
  	IRTree irt2 = new IRTree();
  	Token t = ast.getToken();
  	int tt = t.getType();
  	if (tt == TRUE) {
      	irt.setOp("true");
  	} else if(tt == FALSE) {
      	irt.setOp("false");
  	} else if(tt == EQ) {
  		ast1 = (CommonTree)ast.getChild(0);
  		ast2 = (CommonTree)ast.getChild(1);
  		irt.setOp("EQ");
  		expression(ast1, irt1);
  		expression(ast2, irt2);
  		irt.addSub(irt1);
  		irt.addSub(irt2);
  	} else if(tt == LEQ) {
  		ast1 = (CommonTree)ast.getChild(0);
  		ast2 = (CommonTree)ast.getChild(1);
  		irt.setOp("LEQ");
  		expression(ast1, irt1);
  		expression(ast2, irt2);
  		irt.addSub(irt1);
  		irt.addSub(irt2);
  	} else if (tt == LES) {
  		ast1 = (CommonTree)ast.getChild(0);
  		ast2 = (CommonTree)ast.getChild(1);
  		irt.setOp("LES");
  		expression(ast1, irt1);
  		expression(ast2, irt2);
  		irt.addSub(irt1);
  		irt.addSub(irt2);
  	} else if(tt == GRT) {
  		ast1 = (CommonTree)ast.getChild(0);
  		ast2 = (CommonTree)ast.getChild(1);
  		irt.setOp("GRT");
  		expression(ast1, irt1);
  		expression(ast2, irt2);
  		irt.addSub(irt1);
  		irt.addSub(irt2);
  	} else if (tt == GEQ) {
  		ast1 = (CommonTree)ast.getChild(0);
  		ast2 = (CommonTree)ast.getChild(1);
  		irt.setOp("GEQ");
  		expression(ast1, irt1);
  		expression(ast2, irt2);
  		irt.addSub(irt1);
  		irt.addSub(irt2);
  	} else if (tt == NEQ) {
  		ast1 = (CommonTree)ast.getChild(0);
  		ast2 = (CommonTree)ast.getChild(1);
  		irt.setOp("NEQ");
  		expression(ast1, irt1);
  		expression(ast2, irt2);
  		irt.addSub(irt1);
  		irt.addSub(irt2);
  	} else {
  		boolexp(ast, irt);
  	}
  }

  public static void boolexp(CommonTree ast, IRTree irt)
  {
  	CommonTree ast1, ast2;
  	IRTree irt1 = new IRTree();
  	IRTree irt2 = new IRTree();
  	Token t = ast.getToken();
  	int tt = t.getType();
  	if (tt == AND){
  		ast1 = (CommonTree)ast.getChild(0);
      	ast2 = (CommonTree)ast.getChild(1);
      	boolterm(ast1,irt1);
      	boolterm(ast2,irt2);
      	if (irt1.getOp().equals("true") && irt2.getOp().equals("true"))  {
      	irt.setOp("true");
      } else if(irt1.getOp().equals("true") && irt2.getOp().equals("false")){
      	irt.setOp("false");
      } else if(irt1.getOp().equals("false") && irt2.getOp().equals("true")){
      	irt.setOp("false");
      } else if(irt1.getOp().equals("false") && irt2.getOp().equals("false")){
      	irt.setOp("false");
      } else {
      	irt.setOp("AND");
      	irt.addSub(irt1);
      	irt.addSub(irt2);
      }
  	} else if (tt == OR){
  		ast1 = (CommonTree)ast.getChild(0);
      	ast2 = (CommonTree)ast.getChild(1);	
      	boolterm(ast1,irt1);
      	boolterm(ast2,irt2);
      	if (irt1.getOp().equals("true") || irt2.getOp().equals("true")){
      		irt.setOp("true");
      	} else if (irt1.getOp().equals("false") && irt2.getOp().equals("false")){
      		irt.setOp("false");
      	} else {
      		irt.setOp("OR");
      		irt.addSub(irt1);
      		irt.addSub(irt2);
      	}
  	}
  	else {
  		boolterm(ast, irt);
  	}
  }

  public static void boolterm(CommonTree ast, IRTree irt)
  {
  	CommonTree ast1;
  	IRTree irt1 = new IRTree();
  	Token t = ast.getToken();
  	int tt = t.getType();
  	if (tt == NOT){
  		ast1 = (CommonTree)ast.getChild(0);  		
  		booleanValue(ast1,irt1);
      if (irt1.getOp().equals("true")){
        irt.setOp("false");
      } else if(irt1.getOp().equals("false")){
        irt.setOp("true");
      } else {
        irt.setOp("NOT");
        irt.addSub(irt1);
      }  		
  	} else {
  		booleanValue(ast, irt);
  	}
  }
  private static void error(int tt)
  {
    System.out.println("IRT error: "+tokenNames[tt]);
    System.exit(1);
  }
}
