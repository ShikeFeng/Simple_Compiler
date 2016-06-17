// COMS22201: Syntax analyser

parser grammar Syn;


options {
  tokenVocab = Lex;
  output = AST;
}

@members
{
	private String cleanString(String s){
		String tmp;
		tmp = s.replaceAll("^'", "");
		s = tmp.replaceAll("'$", "");
		tmp = s.replaceAll("''", "'");
		return tmp;
	}
	
	// TODO
	//Search RecognitionException and displayREcognitionError in ANTLR3
	//Key part of error handling

	public void displayRecognitionError(String[] tokenNames, RecognitionException e){
		String hdr = getErrorHeader(e);
		String msg = getErrorMessage(e, tokenNames);
		String errorType = e.toString();
		int syntaxErrorNumber = getNumberOfSyntaxErrors();	
		System.err.println("Error "+syntaxErrorNumber+":");
		System.err.println("Error type: "+errorType);
		System.err.println("Error occured at : "+hdr);
		System.err.println("The error message is : "+msg);

	}

}

program :
    statements
  ;

statements :
    statement ( SEMICOLON ^ statement )* 
  ;

statement :
	writestatement
	|writelnstatement
	|skipstatement
	|ifstatement
	|whilestatement
	|readstatement
	|assignstatement
	;

assignstatement :
	variable ASSIGN^ exp	
	;
	
writestatement :
	WRITE^ OPENPAREN! ( (boolexp) => boolexp | exp | string ) CLOSEPAREN!
	;

writelnstatement :	
	WRITELN
	; 
	
skipstatement  :	
	SKIP	
	;
	
ifstatement :	
	IF^ boolexp THEN! ( statement | compoundstatement ) ELSE! ( statement | compoundstatement)
	;
	
compoundstatement :
	OPENPAREN! statements CLOSEPAREN!
	;
	
whilestatement :
	WHILE^ boolexp DO! (statement | compoundstatement)
	;
		
readstatement  :
	READ^ OPENPAREN! variable CLOSEPAREN!
	;
		
string
    scope { String tmp; }
    :
    s=STRING { $string::tmp = cleanString($s.text); }-> STRING[$string::tmp]
;

variable :
	IDENTIFIER
	;	

constant :
	INTNUM
	;	

realnum :
	FLOAT
	;

factor 	:	
	variable
	|(constant) => constant
	|(realnum) => realnum
	| OPENPAREN! exp CLOSEPAREN!
	;

exp 	:	
	term ((ADD|SUB|BITXOR)^ term)*
	;

term 	:	
	factor ( (MULTIPLY|DIVIDE)^ factor)*	// DIV is extra language feature 
	;
	
boolterm :
	 NOT^ booleanValue
	 |booleanValue
	 ;
	 
boolexp :	
	boolterm ( (AND|OR)^ boolterm )*   // OR is extra language feature
	; 
	
booleanValue :
	TRUE
	|FALSE
	|(exp EQ exp) => exp EQ^ exp
	|(exp LEQ exp) => exp LEQ^ exp
	| OPENPAREN! boolexp CLOSEPAREN!
	|(exp LES exp) => exp LES^ exp		 // LES is extra language feature
	|(exp GRT exp) => exp GRT^ exp       // GRT is extra language feature
	|(exp GEQ exp) => exp GEQ^ exp	     // GEQ is extra language feature
	|(exp NEQ exp) => exp NEQ^ exp       // NEQ is extra language feature
	;
