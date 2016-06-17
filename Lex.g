// COMS22201: Lexical analyser

lexer grammar Lex;

@members {
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
//---------------------------------------------------------------------------
// KEYWORDS
//---------------------------------------------------------------------------
WRITE      : 'write' ;
WRITELN    : 'writeln' ;
DO 	   : 'do' ;
ELSE	   : 'else' ;
FALSE	   : 'false' ;
IF	   : 'if' ;
READ	   : 'read' ;
SKIP 	   : 'skip' ;
THEN 	   : 'then' ;
TRUE 	   : 'true' ;
WHILE 	   : 'while' ;
//---------------------------------------------------------------------------
// OPERATORS
//---------------------------------------------------------------------------
SEMICOLON    : ';' ;
OPENPAREN    : '(' ;
CLOSEPAREN   : ')' ;

INTNUM       : ('0'..'9')+ ;

FLOAT		 : ('0'..'9')+'.'('0'..'9')+ ;

STRING       : '\'' ('\'' '\'' | ~'\'')* '\'';

COMMENT      : '{' (~'}')* '}' {skip();} ;

WS           : (' ' | '\t' | '\r' | '\n' )+ {skip();} ;

IDENTIFIER : ('a'..'z'|'A'..'Z')(SUBID (SUBID (SUBID (SUBID (SUBID (SUBID SUBID?)?)?)?)?)?)?;  //The length of an IDENTIFIER should not larger than 8
	     
fragment
SUBID 	: ('a'..'z'|'A'..'Z'|'0'..'9'|'_');

ASSIGN : ':=';

EQ : '=' ;

LEQ : '<=' ;

AND : '&' ;

NOT : '!' ;

ADD : '+' ;

SUB : '-' ;

MULTIPLY : '*' ;

// Extra Language Features
GRT : '>' ;

LES : '<' ;

GEQ : '>=' ;

OR : '|' ;

NEQ : '!=' ;

DIVIDE : '/' ;

BITXOR : '^';
