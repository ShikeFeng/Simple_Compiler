// $ANTLR 3.5.2 Syn.g 2015-12-18 15:48:34

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class Syn extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "AND", "ASSIGN", "BITXOR", 
		"CLOSEPAREN", "COMMENT", "DIVIDE", "DO", "ELSE", "EQ", "FALSE", "FLOAT", 
		"GEQ", "GRT", "IDENTIFIER", "IF", "INTNUM", "LEQ", "LES", "MULTIPLY", 
		"NEQ", "NOT", "OPENPAREN", "OR", "READ", "SEMICOLON", "SKIP", "STRING", 
		"SUB", "SUBID", "THEN", "TRUE", "WHILE", "WRITE", "WRITELN", "WS"
	};
	public static final int EOF=-1;
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public Syn(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public Syn(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return Syn.tokenNames; }
	@Override public String getGrammarFileName() { return "Syn.g"; }


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



	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// Syn.g:39:1: program : statements ;
	public final Syn.program_return program() throws RecognitionException {
		Syn.program_return retval = new Syn.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope statements1 =null;


		try {
			// Syn.g:39:9: ( statements )
			// Syn.g:40:5: statements
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_statements_in_program48);
			statements1=statements();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, statements1.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class statements_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statements"
	// Syn.g:43:1: statements : statement ( SEMICOLON ^ statement )* ;
	public final Syn.statements_return statements() throws RecognitionException {
		Syn.statements_return retval = new Syn.statements_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON3=null;
		ParserRuleReturnScope statement2 =null;
		ParserRuleReturnScope statement4 =null;

		Object SEMICOLON3_tree=null;

		try {
			// Syn.g:43:12: ( statement ( SEMICOLON ^ statement )* )
			// Syn.g:44:5: statement ( SEMICOLON ^ statement )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_statement_in_statements63);
			statement2=statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

			// Syn.g:44:15: ( SEMICOLON ^ statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==SEMICOLON) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Syn.g:44:17: SEMICOLON ^ statement
					{
					SEMICOLON3=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statements67); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON3_tree = (Object)adaptor.create(SEMICOLON3);
					root_0 = (Object)adaptor.becomeRoot(SEMICOLON3_tree, root_0);
					}

					pushFollow(FOLLOW_statement_in_statements71);
					statement4=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement4.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statements"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// Syn.g:47:1: statement : ( writestatement | writelnstatement | skipstatement | ifstatement | whilestatement | readstatement | assignstatement );
	public final Syn.statement_return statement() throws RecognitionException {
		Syn.statement_return retval = new Syn.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope writestatement5 =null;
		ParserRuleReturnScope writelnstatement6 =null;
		ParserRuleReturnScope skipstatement7 =null;
		ParserRuleReturnScope ifstatement8 =null;
		ParserRuleReturnScope whilestatement9 =null;
		ParserRuleReturnScope readstatement10 =null;
		ParserRuleReturnScope assignstatement11 =null;


		try {
			// Syn.g:47:11: ( writestatement | writelnstatement | skipstatement | ifstatement | whilestatement | readstatement | assignstatement )
			int alt2=7;
			switch ( input.LA(1) ) {
			case WRITE:
				{
				alt2=1;
				}
				break;
			case WRITELN:
				{
				alt2=2;
				}
				break;
			case SKIP:
				{
				alt2=3;
				}
				break;
			case IF:
				{
				alt2=4;
				}
				break;
			case WHILE:
				{
				alt2=5;
				}
				break;
			case READ:
				{
				alt2=6;
				}
				break;
			case IDENTIFIER:
				{
				alt2=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// Syn.g:48:2: writestatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_writestatement_in_statement87);
					writestatement5=writestatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, writestatement5.getTree());

					}
					break;
				case 2 :
					// Syn.g:49:3: writelnstatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_writelnstatement_in_statement91);
					writelnstatement6=writelnstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, writelnstatement6.getTree());

					}
					break;
				case 3 :
					// Syn.g:50:3: skipstatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_skipstatement_in_statement95);
					skipstatement7=skipstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, skipstatement7.getTree());

					}
					break;
				case 4 :
					// Syn.g:51:3: ifstatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ifstatement_in_statement99);
					ifstatement8=ifstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifstatement8.getTree());

					}
					break;
				case 5 :
					// Syn.g:52:3: whilestatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_whilestatement_in_statement103);
					whilestatement9=whilestatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, whilestatement9.getTree());

					}
					break;
				case 6 :
					// Syn.g:53:3: readstatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_readstatement_in_statement107);
					readstatement10=readstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, readstatement10.getTree());

					}
					break;
				case 7 :
					// Syn.g:54:3: assignstatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignstatement_in_statement111);
					assignstatement11=assignstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignstatement11.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class assignstatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignstatement"
	// Syn.g:57:1: assignstatement : variable ASSIGN ^ exp ;
	public final Syn.assignstatement_return assignstatement() throws RecognitionException {
		Syn.assignstatement_return retval = new Syn.assignstatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN13=null;
		ParserRuleReturnScope variable12 =null;
		ParserRuleReturnScope exp14 =null;

		Object ASSIGN13_tree=null;

		try {
			// Syn.g:57:17: ( variable ASSIGN ^ exp )
			// Syn.g:58:2: variable ASSIGN ^ exp
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_variable_in_assignstatement122);
			variable12=variable();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, variable12.getTree());

			ASSIGN13=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignstatement124); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN13_tree = (Object)adaptor.create(ASSIGN13);
			root_0 = (Object)adaptor.becomeRoot(ASSIGN13_tree, root_0);
			}

			pushFollow(FOLLOW_exp_in_assignstatement127);
			exp14=exp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, exp14.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignstatement"


	public static class writestatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "writestatement"
	// Syn.g:61:1: writestatement : WRITE ^ OPENPAREN ! ( ( boolexp )=> boolexp | exp | string ) CLOSEPAREN !;
	public final Syn.writestatement_return writestatement() throws RecognitionException {
		Syn.writestatement_return retval = new Syn.writestatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WRITE15=null;
		Token OPENPAREN16=null;
		Token CLOSEPAREN20=null;
		ParserRuleReturnScope boolexp17 =null;
		ParserRuleReturnScope exp18 =null;
		ParserRuleReturnScope string19 =null;

		Object WRITE15_tree=null;
		Object OPENPAREN16_tree=null;
		Object CLOSEPAREN20_tree=null;

		try {
			// Syn.g:61:16: ( WRITE ^ OPENPAREN ! ( ( boolexp )=> boolexp | exp | string ) CLOSEPAREN !)
			// Syn.g:62:2: WRITE ^ OPENPAREN ! ( ( boolexp )=> boolexp | exp | string ) CLOSEPAREN !
			{
			root_0 = (Object)adaptor.nil();


			WRITE15=(Token)match(input,WRITE,FOLLOW_WRITE_in_writestatement140); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WRITE15_tree = (Object)adaptor.create(WRITE15);
			root_0 = (Object)adaptor.becomeRoot(WRITE15_tree, root_0);
			}

			OPENPAREN16=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_writestatement143); if (state.failed) return retval;
			// Syn.g:62:20: ( ( boolexp )=> boolexp | exp | string )
			int alt3=3;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==NOT) && (synpred1_Syn())) {
				alt3=1;
			}
			else if ( (LA3_0==TRUE) && (synpred1_Syn())) {
				alt3=1;
			}
			else if ( (LA3_0==FALSE) && (synpred1_Syn())) {
				alt3=1;
			}
			else if ( (LA3_0==IDENTIFIER) ) {
				int LA3_4 = input.LA(2);
				if ( (synpred1_Syn()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

			}
			else if ( (LA3_0==INTNUM) ) {
				int LA3_5 = input.LA(2);
				if ( (synpred1_Syn()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

			}
			else if ( (LA3_0==FLOAT) ) {
				int LA3_6 = input.LA(2);
				if ( (synpred1_Syn()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

			}
			else if ( (LA3_0==OPENPAREN) ) {
				int LA3_7 = input.LA(2);
				if ( (synpred1_Syn()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

			}
			else if ( (LA3_0==STRING) ) {
				alt3=3;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Syn.g:62:22: ( boolexp )=> boolexp
					{
					pushFollow(FOLLOW_boolexp_in_writestatement154);
					boolexp17=boolexp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp17.getTree());

					}
					break;
				case 2 :
					// Syn.g:62:45: exp
					{
					pushFollow(FOLLOW_exp_in_writestatement158);
					exp18=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp18.getTree());

					}
					break;
				case 3 :
					// Syn.g:62:51: string
					{
					pushFollow(FOLLOW_string_in_writestatement162);
					string19=string();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, string19.getTree());

					}
					break;

			}

			CLOSEPAREN20=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_writestatement166); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "writestatement"


	public static class writelnstatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "writelnstatement"
	// Syn.g:65:1: writelnstatement : WRITELN ;
	public final Syn.writelnstatement_return writelnstatement() throws RecognitionException {
		Syn.writelnstatement_return retval = new Syn.writelnstatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WRITELN21=null;

		Object WRITELN21_tree=null;

		try {
			// Syn.g:65:18: ( WRITELN )
			// Syn.g:66:2: WRITELN
			{
			root_0 = (Object)adaptor.nil();


			WRITELN21=(Token)match(input,WRITELN,FOLLOW_WRITELN_in_writelnstatement179); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WRITELN21_tree = (Object)adaptor.create(WRITELN21);
			adaptor.addChild(root_0, WRITELN21_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "writelnstatement"


	public static class skipstatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "skipstatement"
	// Syn.g:69:1: skipstatement : SKIP ;
	public final Syn.skipstatement_return skipstatement() throws RecognitionException {
		Syn.skipstatement_return retval = new Syn.skipstatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SKIP22=null;

		Object SKIP22_tree=null;

		try {
			// Syn.g:69:16: ( SKIP )
			// Syn.g:70:2: SKIP
			{
			root_0 = (Object)adaptor.nil();


			SKIP22=(Token)match(input,SKIP,FOLLOW_SKIP_in_skipstatement194); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SKIP22_tree = (Object)adaptor.create(SKIP22);
			adaptor.addChild(root_0, SKIP22_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "skipstatement"


	public static class ifstatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifstatement"
	// Syn.g:73:1: ifstatement : IF ^ boolexp THEN ! ( statement | compoundstatement ) ELSE ! ( statement | compoundstatement ) ;
	public final Syn.ifstatement_return ifstatement() throws RecognitionException {
		Syn.ifstatement_return retval = new Syn.ifstatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF23=null;
		Token THEN25=null;
		Token ELSE28=null;
		ParserRuleReturnScope boolexp24 =null;
		ParserRuleReturnScope statement26 =null;
		ParserRuleReturnScope compoundstatement27 =null;
		ParserRuleReturnScope statement29 =null;
		ParserRuleReturnScope compoundstatement30 =null;

		Object IF23_tree=null;
		Object THEN25_tree=null;
		Object ELSE28_tree=null;

		try {
			// Syn.g:73:13: ( IF ^ boolexp THEN ! ( statement | compoundstatement ) ELSE ! ( statement | compoundstatement ) )
			// Syn.g:74:2: IF ^ boolexp THEN ! ( statement | compoundstatement ) ELSE ! ( statement | compoundstatement )
			{
			root_0 = (Object)adaptor.nil();


			IF23=(Token)match(input,IF,FOLLOW_IF_in_ifstatement208); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IF23_tree = (Object)adaptor.create(IF23);
			root_0 = (Object)adaptor.becomeRoot(IF23_tree, root_0);
			}

			pushFollow(FOLLOW_boolexp_in_ifstatement211);
			boolexp24=boolexp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp24.getTree());

			THEN25=(Token)match(input,THEN,FOLLOW_THEN_in_ifstatement213); if (state.failed) return retval;
			// Syn.g:74:20: ( statement | compoundstatement )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= IDENTIFIER && LA4_0 <= IF)||LA4_0==READ||LA4_0==SKIP||(LA4_0 >= WHILE && LA4_0 <= WRITELN)) ) {
				alt4=1;
			}
			else if ( (LA4_0==OPENPAREN) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// Syn.g:74:22: statement
					{
					pushFollow(FOLLOW_statement_in_ifstatement218);
					statement26=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement26.getTree());

					}
					break;
				case 2 :
					// Syn.g:74:34: compoundstatement
					{
					pushFollow(FOLLOW_compoundstatement_in_ifstatement222);
					compoundstatement27=compoundstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compoundstatement27.getTree());

					}
					break;

			}

			ELSE28=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifstatement226); if (state.failed) return retval;
			// Syn.g:74:60: ( statement | compoundstatement )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= IDENTIFIER && LA5_0 <= IF)||LA5_0==READ||LA5_0==SKIP||(LA5_0 >= WHILE && LA5_0 <= WRITELN)) ) {
				alt5=1;
			}
			else if ( (LA5_0==OPENPAREN) ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// Syn.g:74:62: statement
					{
					pushFollow(FOLLOW_statement_in_ifstatement231);
					statement29=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement29.getTree());

					}
					break;
				case 2 :
					// Syn.g:74:74: compoundstatement
					{
					pushFollow(FOLLOW_compoundstatement_in_ifstatement235);
					compoundstatement30=compoundstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compoundstatement30.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ifstatement"


	public static class compoundstatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "compoundstatement"
	// Syn.g:77:1: compoundstatement : OPENPAREN ! statements CLOSEPAREN !;
	public final Syn.compoundstatement_return compoundstatement() throws RecognitionException {
		Syn.compoundstatement_return retval = new Syn.compoundstatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OPENPAREN31=null;
		Token CLOSEPAREN33=null;
		ParserRuleReturnScope statements32 =null;

		Object OPENPAREN31_tree=null;
		Object CLOSEPAREN33_tree=null;

		try {
			// Syn.g:77:19: ( OPENPAREN ! statements CLOSEPAREN !)
			// Syn.g:78:2: OPENPAREN ! statements CLOSEPAREN !
			{
			root_0 = (Object)adaptor.nil();


			OPENPAREN31=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_compoundstatement248); if (state.failed) return retval;
			pushFollow(FOLLOW_statements_in_compoundstatement251);
			statements32=statements();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, statements32.getTree());

			CLOSEPAREN33=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_compoundstatement253); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "compoundstatement"


	public static class whilestatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "whilestatement"
	// Syn.g:81:1: whilestatement : WHILE ^ boolexp DO ! ( statement | compoundstatement ) ;
	public final Syn.whilestatement_return whilestatement() throws RecognitionException {
		Syn.whilestatement_return retval = new Syn.whilestatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WHILE34=null;
		Token DO36=null;
		ParserRuleReturnScope boolexp35 =null;
		ParserRuleReturnScope statement37 =null;
		ParserRuleReturnScope compoundstatement38 =null;

		Object WHILE34_tree=null;
		Object DO36_tree=null;

		try {
			// Syn.g:81:16: ( WHILE ^ boolexp DO ! ( statement | compoundstatement ) )
			// Syn.g:82:2: WHILE ^ boolexp DO ! ( statement | compoundstatement )
			{
			root_0 = (Object)adaptor.nil();


			WHILE34=(Token)match(input,WHILE,FOLLOW_WHILE_in_whilestatement266); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WHILE34_tree = (Object)adaptor.create(WHILE34);
			root_0 = (Object)adaptor.becomeRoot(WHILE34_tree, root_0);
			}

			pushFollow(FOLLOW_boolexp_in_whilestatement269);
			boolexp35=boolexp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp35.getTree());

			DO36=(Token)match(input,DO,FOLLOW_DO_in_whilestatement271); if (state.failed) return retval;
			// Syn.g:82:21: ( statement | compoundstatement )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= IDENTIFIER && LA6_0 <= IF)||LA6_0==READ||LA6_0==SKIP||(LA6_0 >= WHILE && LA6_0 <= WRITELN)) ) {
				alt6=1;
			}
			else if ( (LA6_0==OPENPAREN) ) {
				alt6=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Syn.g:82:22: statement
					{
					pushFollow(FOLLOW_statement_in_whilestatement275);
					statement37=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement37.getTree());

					}
					break;
				case 2 :
					// Syn.g:82:34: compoundstatement
					{
					pushFollow(FOLLOW_compoundstatement_in_whilestatement279);
					compoundstatement38=compoundstatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compoundstatement38.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whilestatement"


	public static class readstatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "readstatement"
	// Syn.g:85:1: readstatement : READ ^ OPENPAREN ! variable CLOSEPAREN !;
	public final Syn.readstatement_return readstatement() throws RecognitionException {
		Syn.readstatement_return retval = new Syn.readstatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token READ39=null;
		Token OPENPAREN40=null;
		Token CLOSEPAREN42=null;
		ParserRuleReturnScope variable41 =null;

		Object READ39_tree=null;
		Object OPENPAREN40_tree=null;
		Object CLOSEPAREN42_tree=null;

		try {
			// Syn.g:85:16: ( READ ^ OPENPAREN ! variable CLOSEPAREN !)
			// Syn.g:86:2: READ ^ OPENPAREN ! variable CLOSEPAREN !
			{
			root_0 = (Object)adaptor.nil();


			READ39=(Token)match(input,READ,FOLLOW_READ_in_readstatement294); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			READ39_tree = (Object)adaptor.create(READ39);
			root_0 = (Object)adaptor.becomeRoot(READ39_tree, root_0);
			}

			OPENPAREN40=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_readstatement297); if (state.failed) return retval;
			pushFollow(FOLLOW_variable_in_readstatement300);
			variable41=variable();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, variable41.getTree());

			CLOSEPAREN42=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_readstatement302); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "readstatement"


	protected static class string_scope {
		String tmp;
	}
	protected Stack<string_scope> string_stack = new Stack<string_scope>();

	public static class string_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "string"
	// Syn.g:89:1: string : s= STRING -> STRING[$string::tmp] ;
	public final Syn.string_return string() throws RecognitionException {
		string_stack.push(new string_scope());
		Syn.string_return retval = new Syn.string_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token s=null;

		Object s_tree=null;
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

		try {
			// Syn.g:91:5: (s= STRING -> STRING[$string::tmp] )
			// Syn.g:92:5: s= STRING
			{
			s=(Token)match(input,STRING,FOLLOW_STRING_in_string333); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(s);

			if ( state.backtracking==0 ) { string_stack.peek().tmp = cleanString((s!=null?s.getText():null)); }
			// AST REWRITE
			// elements: STRING
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 92:54: -> STRING[$string::tmp]
			{
				adaptor.addChild(root_0, (Object)adaptor.create(STRING, string_stack.peek().tmp));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			string_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "string"


	public static class variable_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "variable"
	// Syn.g:95:1: variable : IDENTIFIER ;
	public final Syn.variable_return variable() throws RecognitionException {
		Syn.variable_return retval = new Syn.variable_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER43=null;

		Object IDENTIFIER43_tree=null;

		try {
			// Syn.g:95:10: ( IDENTIFIER )
			// Syn.g:96:2: IDENTIFIER
			{
			root_0 = (Object)adaptor.nil();


			IDENTIFIER43=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variable349); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER43_tree = (Object)adaptor.create(IDENTIFIER43);
			adaptor.addChild(root_0, IDENTIFIER43_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "variable"


	public static class constant_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constant"
	// Syn.g:99:1: constant : INTNUM ;
	public final Syn.constant_return constant() throws RecognitionException {
		Syn.constant_return retval = new Syn.constant_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INTNUM44=null;

		Object INTNUM44_tree=null;

		try {
			// Syn.g:99:10: ( INTNUM )
			// Syn.g:100:2: INTNUM
			{
			root_0 = (Object)adaptor.nil();


			INTNUM44=(Token)match(input,INTNUM,FOLLOW_INTNUM_in_constant361); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INTNUM44_tree = (Object)adaptor.create(INTNUM44);
			adaptor.addChild(root_0, INTNUM44_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "constant"


	public static class realnum_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "realnum"
	// Syn.g:103:1: realnum : FLOAT ;
	public final Syn.realnum_return realnum() throws RecognitionException {
		Syn.realnum_return retval = new Syn.realnum_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FLOAT45=null;

		Object FLOAT45_tree=null;

		try {
			// Syn.g:103:9: ( FLOAT )
			// Syn.g:104:2: FLOAT
			{
			root_0 = (Object)adaptor.nil();


			FLOAT45=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_realnum373); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FLOAT45_tree = (Object)adaptor.create(FLOAT45);
			adaptor.addChild(root_0, FLOAT45_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "realnum"


	public static class factor_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// Syn.g:107:1: factor : ( variable | ( constant )=> constant | ( realnum )=> realnum | OPENPAREN ! exp CLOSEPAREN !);
	public final Syn.factor_return factor() throws RecognitionException {
		Syn.factor_return retval = new Syn.factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OPENPAREN49=null;
		Token CLOSEPAREN51=null;
		ParserRuleReturnScope variable46 =null;
		ParserRuleReturnScope constant47 =null;
		ParserRuleReturnScope realnum48 =null;
		ParserRuleReturnScope exp50 =null;

		Object OPENPAREN49_tree=null;
		Object CLOSEPAREN51_tree=null;

		try {
			// Syn.g:107:9: ( variable | ( constant )=> constant | ( realnum )=> realnum | OPENPAREN ! exp CLOSEPAREN !)
			int alt7=4;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==IDENTIFIER) ) {
				alt7=1;
			}
			else if ( (LA7_0==INTNUM) && (synpred2_Syn())) {
				alt7=2;
			}
			else if ( (LA7_0==FLOAT) && (synpred3_Syn())) {
				alt7=3;
			}
			else if ( (LA7_0==OPENPAREN) ) {
				alt7=4;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// Syn.g:108:2: variable
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_variable_in_factor386);
					variable46=variable();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, variable46.getTree());

					}
					break;
				case 2 :
					// Syn.g:109:3: ( constant )=> constant
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_constant_in_factor396);
					constant47=constant();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant47.getTree());

					}
					break;
				case 3 :
					// Syn.g:110:3: ( realnum )=> realnum
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_realnum_in_factor406);
					realnum48=realnum();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, realnum48.getTree());

					}
					break;
				case 4 :
					// Syn.g:111:4: OPENPAREN ! exp CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					OPENPAREN49=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_factor411); if (state.failed) return retval;
					pushFollow(FOLLOW_exp_in_factor414);
					exp50=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp50.getTree());

					CLOSEPAREN51=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_factor416); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "factor"


	public static class exp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exp"
	// Syn.g:114:1: exp : term ( ( ADD | SUB | BITXOR ) ^ term )* ;
	public final Syn.exp_return exp() throws RecognitionException {
		Syn.exp_return retval = new Syn.exp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set53=null;
		ParserRuleReturnScope term52 =null;
		ParserRuleReturnScope term54 =null;

		Object set53_tree=null;

		try {
			// Syn.g:114:6: ( term ( ( ADD | SUB | BITXOR ) ^ term )* )
			// Syn.g:115:2: term ( ( ADD | SUB | BITXOR ) ^ term )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term_in_exp430);
			term52=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term52.getTree());

			// Syn.g:115:7: ( ( ADD | SUB | BITXOR ) ^ term )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ADD||LA8_0==BITXOR||LA8_0==SUB) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Syn.g:115:8: ( ADD | SUB | BITXOR ) ^ term
					{
					set53=input.LT(1);
					set53=input.LT(1);
					if ( input.LA(1)==ADD||input.LA(1)==BITXOR||input.LA(1)==SUB ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set53), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_term_in_exp442);
					term54=term();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, term54.getTree());

					}
					break;

				default :
					break loop8;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exp"


	public static class term_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term"
	// Syn.g:118:1: term : factor ( ( MULTIPLY | DIVIDE ) ^ factor )* ;
	public final Syn.term_return term() throws RecognitionException {
		Syn.term_return retval = new Syn.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set56=null;
		ParserRuleReturnScope factor55 =null;
		ParserRuleReturnScope factor57 =null;

		Object set56_tree=null;

		try {
			// Syn.g:118:7: ( factor ( ( MULTIPLY | DIVIDE ) ^ factor )* )
			// Syn.g:119:2: factor ( ( MULTIPLY | DIVIDE ) ^ factor )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term457);
			factor55=factor();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, factor55.getTree());

			// Syn.g:119:9: ( ( MULTIPLY | DIVIDE ) ^ factor )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==DIVIDE||LA9_0==MULTIPLY) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Syn.g:119:11: ( MULTIPLY | DIVIDE ) ^ factor
					{
					set56=input.LT(1);
					set56=input.LT(1);
					if ( input.LA(1)==DIVIDE||input.LA(1)==MULTIPLY ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set56), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_factor_in_term468);
					factor57=factor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, factor57.getTree());

					}
					break;

				default :
					break loop9;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term"


	public static class boolterm_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "boolterm"
	// Syn.g:122:1: boolterm : ( NOT ^ booleanValue | booleanValue );
	public final Syn.boolterm_return boolterm() throws RecognitionException {
		Syn.boolterm_return retval = new Syn.boolterm_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT58=null;
		ParserRuleReturnScope booleanValue59 =null;
		ParserRuleReturnScope booleanValue60 =null;

		Object NOT58_tree=null;

		try {
			// Syn.g:122:10: ( NOT ^ booleanValue | booleanValue )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==NOT) ) {
				alt10=1;
			}
			else if ( ((LA10_0 >= FALSE && LA10_0 <= FLOAT)||LA10_0==IDENTIFIER||LA10_0==INTNUM||LA10_0==OPENPAREN||LA10_0==TRUE) ) {
				alt10=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// Syn.g:123:3: NOT ^ booleanValue
					{
					root_0 = (Object)adaptor.nil();


					NOT58=(Token)match(input,NOT,FOLLOW_NOT_in_boolterm484); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT58_tree = (Object)adaptor.create(NOT58);
					root_0 = (Object)adaptor.becomeRoot(NOT58_tree, root_0);
					}

					pushFollow(FOLLOW_booleanValue_in_boolterm487);
					booleanValue59=booleanValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, booleanValue59.getTree());

					}
					break;
				case 2 :
					// Syn.g:124:4: booleanValue
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_booleanValue_in_boolterm492);
					booleanValue60=booleanValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, booleanValue60.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "boolterm"


	public static class boolexp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "boolexp"
	// Syn.g:127:1: boolexp : boolterm ( ( AND | OR ) ^ boolterm )* ;
	public final Syn.boolexp_return boolexp() throws RecognitionException {
		Syn.boolexp_return retval = new Syn.boolexp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set62=null;
		ParserRuleReturnScope boolterm61 =null;
		ParserRuleReturnScope boolterm63 =null;

		Object set62_tree=null;

		try {
			// Syn.g:127:9: ( boolterm ( ( AND | OR ) ^ boolterm )* )
			// Syn.g:128:2: boolterm ( ( AND | OR ) ^ boolterm )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_boolterm_in_boolexp507);
			boolterm61=boolterm();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, boolterm61.getTree());

			// Syn.g:128:11: ( ( AND | OR ) ^ boolterm )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==AND||LA11_0==OR) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// Syn.g:128:13: ( AND | OR ) ^ boolterm
					{
					set62=input.LT(1);
					set62=input.LT(1);
					if ( input.LA(1)==AND||input.LA(1)==OR ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set62), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_boolterm_in_boolexp518);
					boolterm63=boolterm();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolterm63.getTree());

					}
					break;

				default :
					break loop11;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "boolexp"


	public static class booleanValue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "booleanValue"
	// Syn.g:131:1: booleanValue : ( TRUE | FALSE | ( exp EQ exp )=> exp EQ ^ exp | ( exp LEQ exp )=> exp LEQ ^ exp | OPENPAREN ! boolexp CLOSEPAREN !| ( exp LES exp )=> exp LES ^ exp | ( exp GRT exp )=> exp GRT ^ exp | ( exp GEQ exp )=> exp GEQ ^ exp | ( exp NEQ exp )=> exp NEQ ^ exp );
	public final Syn.booleanValue_return booleanValue() throws RecognitionException {
		Syn.booleanValue_return retval = new Syn.booleanValue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TRUE64=null;
		Token FALSE65=null;
		Token EQ67=null;
		Token LEQ70=null;
		Token OPENPAREN72=null;
		Token CLOSEPAREN74=null;
		Token LES76=null;
		Token GRT79=null;
		Token GEQ82=null;
		Token NEQ85=null;
		ParserRuleReturnScope exp66 =null;
		ParserRuleReturnScope exp68 =null;
		ParserRuleReturnScope exp69 =null;
		ParserRuleReturnScope exp71 =null;
		ParserRuleReturnScope boolexp73 =null;
		ParserRuleReturnScope exp75 =null;
		ParserRuleReturnScope exp77 =null;
		ParserRuleReturnScope exp78 =null;
		ParserRuleReturnScope exp80 =null;
		ParserRuleReturnScope exp81 =null;
		ParserRuleReturnScope exp83 =null;
		ParserRuleReturnScope exp84 =null;
		ParserRuleReturnScope exp86 =null;

		Object TRUE64_tree=null;
		Object FALSE65_tree=null;
		Object EQ67_tree=null;
		Object LEQ70_tree=null;
		Object OPENPAREN72_tree=null;
		Object CLOSEPAREN74_tree=null;
		Object LES76_tree=null;
		Object GRT79_tree=null;
		Object GEQ82_tree=null;
		Object NEQ85_tree=null;

		try {
			// Syn.g:131:14: ( TRUE | FALSE | ( exp EQ exp )=> exp EQ ^ exp | ( exp LEQ exp )=> exp LEQ ^ exp | OPENPAREN ! boolexp CLOSEPAREN !| ( exp LES exp )=> exp LES ^ exp | ( exp GRT exp )=> exp GRT ^ exp | ( exp GEQ exp )=> exp GEQ ^ exp | ( exp NEQ exp )=> exp NEQ ^ exp )
			int alt12=9;
			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt12=1;
				}
				break;
			case FALSE:
				{
				alt12=2;
				}
				break;
			case IDENTIFIER:
				{
				int LA12_3 = input.LA(2);
				if ( (synpred4_Syn()) ) {
					alt12=3;
				}
				else if ( (synpred5_Syn()) ) {
					alt12=4;
				}
				else if ( (synpred6_Syn()) ) {
					alt12=6;
				}
				else if ( (synpred7_Syn()) ) {
					alt12=7;
				}
				else if ( (synpred8_Syn()) ) {
					alt12=8;
				}
				else if ( (synpred9_Syn()) ) {
					alt12=9;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case INTNUM:
				{
				int LA12_4 = input.LA(2);
				if ( (synpred4_Syn()) ) {
					alt12=3;
				}
				else if ( (synpred5_Syn()) ) {
					alt12=4;
				}
				else if ( (synpred6_Syn()) ) {
					alt12=6;
				}
				else if ( (synpred7_Syn()) ) {
					alt12=7;
				}
				else if ( (synpred8_Syn()) ) {
					alt12=8;
				}
				else if ( (synpred9_Syn()) ) {
					alt12=9;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOAT:
				{
				int LA12_5 = input.LA(2);
				if ( (synpred4_Syn()) ) {
					alt12=3;
				}
				else if ( (synpred5_Syn()) ) {
					alt12=4;
				}
				else if ( (synpred6_Syn()) ) {
					alt12=6;
				}
				else if ( (synpred7_Syn()) ) {
					alt12=7;
				}
				else if ( (synpred8_Syn()) ) {
					alt12=8;
				}
				else if ( (synpred9_Syn()) ) {
					alt12=9;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case OPENPAREN:
				{
				int LA12_6 = input.LA(2);
				if ( (synpred4_Syn()) ) {
					alt12=3;
				}
				else if ( (synpred5_Syn()) ) {
					alt12=4;
				}
				else if ( (true) ) {
					alt12=5;
				}
				else if ( (synpred6_Syn()) ) {
					alt12=6;
				}
				else if ( (synpred7_Syn()) ) {
					alt12=7;
				}
				else if ( (synpred8_Syn()) ) {
					alt12=8;
				}
				else if ( (synpred9_Syn()) ) {
					alt12=9;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// Syn.g:132:2: TRUE
					{
					root_0 = (Object)adaptor.nil();


					TRUE64=(Token)match(input,TRUE,FOLLOW_TRUE_in_booleanValue537); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE64_tree = (Object)adaptor.create(TRUE64);
					adaptor.addChild(root_0, TRUE64_tree);
					}

					}
					break;
				case 2 :
					// Syn.g:133:3: FALSE
					{
					root_0 = (Object)adaptor.nil();


					FALSE65=(Token)match(input,FALSE,FOLLOW_FALSE_in_booleanValue541); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE65_tree = (Object)adaptor.create(FALSE65);
					adaptor.addChild(root_0, FALSE65_tree);
					}

					}
					break;
				case 3 :
					// Syn.g:134:3: ( exp EQ exp )=> exp EQ ^ exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_booleanValue555);
					exp66=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp66.getTree());

					EQ67=(Token)match(input,EQ,FOLLOW_EQ_in_booleanValue557); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQ67_tree = (Object)adaptor.create(EQ67);
					root_0 = (Object)adaptor.becomeRoot(EQ67_tree, root_0);
					}

					pushFollow(FOLLOW_exp_in_booleanValue560);
					exp68=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp68.getTree());

					}
					break;
				case 4 :
					// Syn.g:135:3: ( exp LEQ exp )=> exp LEQ ^ exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_booleanValue574);
					exp69=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp69.getTree());

					LEQ70=(Token)match(input,LEQ,FOLLOW_LEQ_in_booleanValue576); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEQ70_tree = (Object)adaptor.create(LEQ70);
					root_0 = (Object)adaptor.becomeRoot(LEQ70_tree, root_0);
					}

					pushFollow(FOLLOW_exp_in_booleanValue579);
					exp71=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp71.getTree());

					}
					break;
				case 5 :
					// Syn.g:136:4: OPENPAREN ! boolexp CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					OPENPAREN72=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_booleanValue584); if (state.failed) return retval;
					pushFollow(FOLLOW_boolexp_in_booleanValue587);
					boolexp73=boolexp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp73.getTree());

					CLOSEPAREN74=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_booleanValue589); if (state.failed) return retval;
					}
					break;
				case 6 :
					// Syn.g:137:3: ( exp LES exp )=> exp LES ^ exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_booleanValue604);
					exp75=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp75.getTree());

					LES76=(Token)match(input,LES,FOLLOW_LES_in_booleanValue606); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LES76_tree = (Object)adaptor.create(LES76);
					root_0 = (Object)adaptor.becomeRoot(LES76_tree, root_0);
					}

					pushFollow(FOLLOW_exp_in_booleanValue609);
					exp77=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp77.getTree());

					}
					break;
				case 7 :
					// Syn.g:138:3: ( exp GRT exp )=> exp GRT ^ exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_booleanValue626);
					exp78=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp78.getTree());

					GRT79=(Token)match(input,GRT,FOLLOW_GRT_in_booleanValue628); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GRT79_tree = (Object)adaptor.create(GRT79);
					root_0 = (Object)adaptor.becomeRoot(GRT79_tree, root_0);
					}

					pushFollow(FOLLOW_exp_in_booleanValue631);
					exp80=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp80.getTree());

					}
					break;
				case 8 :
					// Syn.g:139:3: ( exp GEQ exp )=> exp GEQ ^ exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_booleanValue652);
					exp81=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp81.getTree());

					GEQ82=(Token)match(input,GEQ,FOLLOW_GEQ_in_booleanValue654); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GEQ82_tree = (Object)adaptor.create(GEQ82);
					root_0 = (Object)adaptor.becomeRoot(GEQ82_tree, root_0);
					}

					pushFollow(FOLLOW_exp_in_booleanValue657);
					exp83=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp83.getTree());

					}
					break;
				case 9 :
					// Syn.g:140:3: ( exp NEQ exp )=> exp NEQ ^ exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_booleanValue677);
					exp84=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp84.getTree());

					NEQ85=(Token)match(input,NEQ,FOLLOW_NEQ_in_booleanValue679); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEQ85_tree = (Object)adaptor.create(NEQ85);
					root_0 = (Object)adaptor.becomeRoot(NEQ85_tree, root_0);
					}

					pushFollow(FOLLOW_exp_in_booleanValue682);
					exp86=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp86.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "booleanValue"

	// $ANTLR start synpred1_Syn
	public final void synpred1_Syn_fragment() throws RecognitionException {
		// Syn.g:62:22: ( boolexp )
		// Syn.g:62:23: boolexp
		{
		pushFollow(FOLLOW_boolexp_in_synpred1_Syn149);
		boolexp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Syn

	// $ANTLR start synpred2_Syn
	public final void synpred2_Syn_fragment() throws RecognitionException {
		// Syn.g:109:3: ( constant )
		// Syn.g:109:4: constant
		{
		pushFollow(FOLLOW_constant_in_synpred2_Syn391);
		constant();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_Syn

	// $ANTLR start synpred3_Syn
	public final void synpred3_Syn_fragment() throws RecognitionException {
		// Syn.g:110:3: ( realnum )
		// Syn.g:110:4: realnum
		{
		pushFollow(FOLLOW_realnum_in_synpred3_Syn401);
		realnum();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_Syn

	// $ANTLR start synpred4_Syn
	public final void synpred4_Syn_fragment() throws RecognitionException {
		// Syn.g:134:3: ( exp EQ exp )
		// Syn.g:134:4: exp EQ exp
		{
		pushFollow(FOLLOW_exp_in_synpred4_Syn546);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,EQ,FOLLOW_EQ_in_synpred4_Syn548); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred4_Syn550);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_Syn

	// $ANTLR start synpred5_Syn
	public final void synpred5_Syn_fragment() throws RecognitionException {
		// Syn.g:135:3: ( exp LEQ exp )
		// Syn.g:135:4: exp LEQ exp
		{
		pushFollow(FOLLOW_exp_in_synpred5_Syn565);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,LEQ,FOLLOW_LEQ_in_synpred5_Syn567); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred5_Syn569);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_Syn

	// $ANTLR start synpred6_Syn
	public final void synpred6_Syn_fragment() throws RecognitionException {
		// Syn.g:137:3: ( exp LES exp )
		// Syn.g:137:4: exp LES exp
		{
		pushFollow(FOLLOW_exp_in_synpred6_Syn595);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,LES,FOLLOW_LES_in_synpred6_Syn597); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred6_Syn599);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred6_Syn

	// $ANTLR start synpred7_Syn
	public final void synpred7_Syn_fragment() throws RecognitionException {
		// Syn.g:138:3: ( exp GRT exp )
		// Syn.g:138:4: exp GRT exp
		{
		pushFollow(FOLLOW_exp_in_synpred7_Syn617);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,GRT,FOLLOW_GRT_in_synpred7_Syn619); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred7_Syn621);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_Syn

	// $ANTLR start synpred8_Syn
	public final void synpred8_Syn_fragment() throws RecognitionException {
		// Syn.g:139:3: ( exp GEQ exp )
		// Syn.g:139:4: exp GEQ exp
		{
		pushFollow(FOLLOW_exp_in_synpred8_Syn643);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,GEQ,FOLLOW_GEQ_in_synpred8_Syn645); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred8_Syn647);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_Syn

	// $ANTLR start synpred9_Syn
	public final void synpred9_Syn_fragment() throws RecognitionException {
		// Syn.g:140:3: ( exp NEQ exp )
		// Syn.g:140:4: exp NEQ exp
		{
		pushFollow(FOLLOW_exp_in_synpred9_Syn668);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,NEQ,FOLLOW_NEQ_in_synpred9_Syn670); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred9_Syn672);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred9_Syn

	// Delegated rules

	public final boolean synpred1_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_statements_in_program48 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements63 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_statements67 = new BitSet(new long[]{0x00000070500C0000L});
	public static final BitSet FOLLOW_statement_in_statements71 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_writestatement_in_statement87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_writelnstatement_in_statement91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_skipstatement_in_statement95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifstatement_in_statement99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whilestatement_in_statement103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_readstatement_in_statement107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignstatement_in_statement111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_in_assignstatement122 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assignstatement124 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_assignstatement127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITE_in_writestatement140 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_OPENPAREN_in_writestatement143 = new BitSet(new long[]{0x000000088614C000L});
	public static final BitSet FOLLOW_boolexp_in_writestatement154 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_exp_in_writestatement158 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_string_in_writestatement162 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_writestatement166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITELN_in_writelnstatement179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SKIP_in_skipstatement194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifstatement208 = new BitSet(new long[]{0x000000080614C000L});
	public static final BitSet FOLLOW_boolexp_in_ifstatement211 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_THEN_in_ifstatement213 = new BitSet(new long[]{0x00000070540C0000L});
	public static final BitSet FOLLOW_statement_in_ifstatement218 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_compoundstatement_in_ifstatement222 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_ELSE_in_ifstatement226 = new BitSet(new long[]{0x00000070540C0000L});
	public static final BitSet FOLLOW_statement_in_ifstatement231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compoundstatement_in_ifstatement235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPENPAREN_in_compoundstatement248 = new BitSet(new long[]{0x00000070500C0000L});
	public static final BitSet FOLLOW_statements_in_compoundstatement251 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_compoundstatement253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_whilestatement266 = new BitSet(new long[]{0x000000080614C000L});
	public static final BitSet FOLLOW_boolexp_in_whilestatement269 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_DO_in_whilestatement271 = new BitSet(new long[]{0x00000070540C0000L});
	public static final BitSet FOLLOW_statement_in_whilestatement275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compoundstatement_in_whilestatement279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_readstatement294 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_OPENPAREN_in_readstatement297 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_variable_in_readstatement300 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_readstatement302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_variable349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTNUM_in_constant361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_realnum373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_in_factor386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_in_factor396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_realnum_in_factor406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPENPAREN_in_factor411 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_factor414 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_factor416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp430 = new BitSet(new long[]{0x0000000100000092L});
	public static final BitSet FOLLOW_set_in_exp433 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_term_in_exp442 = new BitSet(new long[]{0x0000000100000092L});
	public static final BitSet FOLLOW_factor_in_term457 = new BitSet(new long[]{0x0000000000800402L});
	public static final BitSet FOLLOW_set_in_term461 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_factor_in_term468 = new BitSet(new long[]{0x0000000000800402L});
	public static final BitSet FOLLOW_NOT_in_boolterm484 = new BitSet(new long[]{0x000000080414C000L});
	public static final BitSet FOLLOW_booleanValue_in_boolterm487 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_booleanValue_in_boolterm492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolterm_in_boolexp507 = new BitSet(new long[]{0x0000000008000022L});
	public static final BitSet FOLLOW_set_in_boolexp511 = new BitSet(new long[]{0x000000080614C000L});
	public static final BitSet FOLLOW_boolterm_in_boolexp518 = new BitSet(new long[]{0x0000000008000022L});
	public static final BitSet FOLLOW_TRUE_in_booleanValue537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_booleanValue541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_booleanValue555 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EQ_in_booleanValue557 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_booleanValue560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_booleanValue574 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LEQ_in_booleanValue576 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_booleanValue579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPENPAREN_in_booleanValue584 = new BitSet(new long[]{0x000000080614C000L});
	public static final BitSet FOLLOW_boolexp_in_booleanValue587 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_booleanValue589 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_booleanValue604 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_LES_in_booleanValue606 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_booleanValue609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_booleanValue626 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_GRT_in_booleanValue628 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_booleanValue631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_booleanValue652 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_GEQ_in_booleanValue654 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_booleanValue657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_booleanValue677 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_NEQ_in_booleanValue679 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_booleanValue682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolexp_in_synpred1_Syn149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_in_synpred2_Syn391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_realnum_in_synpred3_Syn401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred4_Syn546 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EQ_in_synpred4_Syn548 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_synpred4_Syn550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred5_Syn565 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LEQ_in_synpred5_Syn567 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_synpred5_Syn569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred6_Syn595 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_LES_in_synpred6_Syn597 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_synpred6_Syn599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred7_Syn617 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_GRT_in_synpred7_Syn619 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_synpred7_Syn621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred8_Syn643 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_GEQ_in_synpred8_Syn645 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_synpred8_Syn647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred9_Syn668 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_NEQ_in_synpred9_Syn670 = new BitSet(new long[]{0x0000000004148000L});
	public static final BitSet FOLLOW_exp_in_synpred9_Syn672 = new BitSet(new long[]{0x0000000000000002L});
}
