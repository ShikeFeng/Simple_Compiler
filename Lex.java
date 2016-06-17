// $ANTLR 3.5.2 Lex.g 2015-12-18 15:48:33

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Lex extends Lexer {
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


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public Lex() {} 
	public Lex(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public Lex(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Lex.g"; }

	// $ANTLR start "WRITE"
	public final void mWRITE() throws RecognitionException {
		try {
			int _type = WRITE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:20:12: ( 'write' )
			// Lex.g:20:14: 'write'
			{
			match("write"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WRITE"

	// $ANTLR start "WRITELN"
	public final void mWRITELN() throws RecognitionException {
		try {
			int _type = WRITELN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:21:12: ( 'writeln' )
			// Lex.g:21:14: 'writeln'
			{
			match("writeln"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WRITELN"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:22:8: ( 'do' )
			// Lex.g:22:10: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:23:9: ( 'else' )
			// Lex.g:23:11: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:24:10: ( 'false' )
			// Lex.g:24:12: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:25:7: ( 'if' )
			// Lex.g:25:9: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "READ"
	public final void mREAD() throws RecognitionException {
		try {
			int _type = READ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:26:9: ( 'read' )
			// Lex.g:26:11: 'read'
			{
			match("read"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "READ"

	// $ANTLR start "SKIP"
	public final void mSKIP() throws RecognitionException {
		try {
			int _type = SKIP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:27:10: ( 'skip' )
			// Lex.g:27:12: 'skip'
			{
			match("skip"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SKIP"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:28:10: ( 'then' )
			// Lex.g:28:12: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:29:10: ( 'true' )
			// Lex.g:29:12: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:30:11: ( 'while' )
			// Lex.g:30:13: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:34:14: ( ';' )
			// Lex.g:34:16: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "OPENPAREN"
	public final void mOPENPAREN() throws RecognitionException {
		try {
			int _type = OPENPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:35:14: ( '(' )
			// Lex.g:35:16: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENPAREN"

	// $ANTLR start "CLOSEPAREN"
	public final void mCLOSEPAREN() throws RecognitionException {
		try {
			int _type = CLOSEPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:36:14: ( ')' )
			// Lex.g:36:16: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSEPAREN"

	// $ANTLR start "INTNUM"
	public final void mINTNUM() throws RecognitionException {
		try {
			int _type = INTNUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:38:14: ( ( '0' .. '9' )+ )
			// Lex.g:38:16: ( '0' .. '9' )+
			{
			// Lex.g:38:16: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Lex.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTNUM"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:40:9: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// Lex.g:40:11: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// Lex.g:40:11: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Lex.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match('.'); 
			// Lex.g:40:25: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Lex.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:42:14: ( '\\'' ( '\\'' '\\'' |~ '\\'' )* '\\'' )
			// Lex.g:42:16: '\\'' ( '\\'' '\\'' |~ '\\'' )* '\\''
			{
			match('\''); 
			// Lex.g:42:21: ( '\\'' '\\'' |~ '\\'' )*
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\'') ) {
					int LA4_1 = input.LA(2);
					if ( (LA4_1=='\'') ) {
						alt4=1;
					}

				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '&')||(LA4_0 >= '(' && LA4_0 <= '\uFFFF')) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// Lex.g:42:22: '\\'' '\\''
					{
					match('\''); 
					match('\''); 
					}
					break;
				case 2 :
					// Lex.g:42:34: ~ '\\''
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:44:14: ( '{' (~ '}' )* '}' )
			// Lex.g:44:16: '{' (~ '}' )* '}'
			{
			match('{'); 
			// Lex.g:44:20: (~ '}' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\u0000' && LA5_0 <= '|')||(LA5_0 >= '~' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// Lex.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '|')||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			match('}'); 
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:46:14: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// Lex.g:46:16: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// Lex.g:46:16: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Lex.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:48:12: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )? )? )? )? )
			// Lex.g:48:14: ( 'a' .. 'z' | 'A' .. 'Z' ) ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )? )? )? )?
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Lex.g:48:33: ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )? )? )? )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( ((LA13_0 >= '0' && LA13_0 <= '9')||(LA13_0 >= 'A' && LA13_0 <= 'Z')||LA13_0=='_'||(LA13_0 >= 'a' && LA13_0 <= 'z')) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// Lex.g:48:34: SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )? )? )?
					{
					mSUBID(); 

					// Lex.g:48:40: ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )? )? )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( ((LA12_0 >= '0' && LA12_0 <= '9')||(LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// Lex.g:48:41: SUBID ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )? )?
							{
							mSUBID(); 

							// Lex.g:48:47: ( SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )? )?
							int alt11=2;
							int LA11_0 = input.LA(1);
							if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
								alt11=1;
							}
							switch (alt11) {
								case 1 :
									// Lex.g:48:48: SUBID ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )?
									{
									mSUBID(); 

									// Lex.g:48:54: ( SUBID ( SUBID ( SUBID ( SUBID )? )? )? )?
									int alt10=2;
									int LA10_0 = input.LA(1);
									if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
										alt10=1;
									}
									switch (alt10) {
										case 1 :
											// Lex.g:48:55: SUBID ( SUBID ( SUBID ( SUBID )? )? )?
											{
											mSUBID(); 

											// Lex.g:48:61: ( SUBID ( SUBID ( SUBID )? )? )?
											int alt9=2;
											int LA9_0 = input.LA(1);
											if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
												alt9=1;
											}
											switch (alt9) {
												case 1 :
													// Lex.g:48:62: SUBID ( SUBID ( SUBID )? )?
													{
													mSUBID(); 

													// Lex.g:48:68: ( SUBID ( SUBID )? )?
													int alt8=2;
													int LA8_0 = input.LA(1);
													if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
														alt8=1;
													}
													switch (alt8) {
														case 1 :
															// Lex.g:48:69: SUBID ( SUBID )?
															{
															mSUBID(); 

															// Lex.g:48:75: ( SUBID )?
															int alt7=2;
															int LA7_0 = input.LA(1);
															if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
																alt7=1;
															}
															switch (alt7) {
																case 1 :
																	// Lex.g:
																	{
																	if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
																		input.consume();
																	}
																	else {
																		MismatchedSetException mse = new MismatchedSetException(null,input);
																		recover(mse);
																		throw mse;
																	}
																	}
																	break;

															}

															}
															break;

													}

													}
													break;

											}

											}
											break;

									}

									}
									break;

							}

							}
							break;

					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "SUBID"
	public final void mSUBID() throws RecognitionException {
		try {
			// Lex.g:51:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' ) )
			// Lex.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBID"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:53:8: ( ':=' )
			// Lex.g:53:10: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:55:4: ( '=' )
			// Lex.g:55:6: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "LEQ"
	public final void mLEQ() throws RecognitionException {
		try {
			int _type = LEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:57:5: ( '<=' )
			// Lex.g:57:7: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEQ"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:59:5: ( '&' )
			// Lex.g:59:7: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:61:5: ( '!' )
			// Lex.g:61:7: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:63:5: ( '+' )
			// Lex.g:63:7: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:65:5: ( '-' )
			// Lex.g:65:7: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB"

	// $ANTLR start "MULTIPLY"
	public final void mMULTIPLY() throws RecognitionException {
		try {
			int _type = MULTIPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:67:10: ( '*' )
			// Lex.g:67:12: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTIPLY"

	// $ANTLR start "GRT"
	public final void mGRT() throws RecognitionException {
		try {
			int _type = GRT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:70:5: ( '>' )
			// Lex.g:70:7: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GRT"

	// $ANTLR start "LES"
	public final void mLES() throws RecognitionException {
		try {
			int _type = LES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:72:5: ( '<' )
			// Lex.g:72:7: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LES"

	// $ANTLR start "GEQ"
	public final void mGEQ() throws RecognitionException {
		try {
			int _type = GEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:74:5: ( '>=' )
			// Lex.g:74:7: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GEQ"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:76:4: ( '|' )
			// Lex.g:76:6: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NEQ"
	public final void mNEQ() throws RecognitionException {
		try {
			int _type = NEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:78:5: ( '!=' )
			// Lex.g:78:7: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEQ"

	// $ANTLR start "DIVIDE"
	public final void mDIVIDE() throws RecognitionException {
		try {
			int _type = DIVIDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:80:8: ( '/' )
			// Lex.g:80:10: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVIDE"

	// $ANTLR start "BITXOR"
	public final void mBITXOR() throws RecognitionException {
		try {
			int _type = BITXOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lex.g:82:8: ( '^' )
			// Lex.g:82:10: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BITXOR"

	@Override
	public void mTokens() throws RecognitionException {
		// Lex.g:1:8: ( WRITE | WRITELN | DO | ELSE | FALSE | IF | READ | SKIP | THEN | TRUE | WHILE | SEMICOLON | OPENPAREN | CLOSEPAREN | INTNUM | FLOAT | STRING | COMMENT | WS | IDENTIFIER | ASSIGN | EQ | LEQ | AND | NOT | ADD | SUB | MULTIPLY | GRT | LES | GEQ | OR | NEQ | DIVIDE | BITXOR )
		int alt14=35;
		alt14 = dfa14.predict(input);
		switch (alt14) {
			case 1 :
				// Lex.g:1:10: WRITE
				{
				mWRITE(); 

				}
				break;
			case 2 :
				// Lex.g:1:16: WRITELN
				{
				mWRITELN(); 

				}
				break;
			case 3 :
				// Lex.g:1:24: DO
				{
				mDO(); 

				}
				break;
			case 4 :
				// Lex.g:1:27: ELSE
				{
				mELSE(); 

				}
				break;
			case 5 :
				// Lex.g:1:32: FALSE
				{
				mFALSE(); 

				}
				break;
			case 6 :
				// Lex.g:1:38: IF
				{
				mIF(); 

				}
				break;
			case 7 :
				// Lex.g:1:41: READ
				{
				mREAD(); 

				}
				break;
			case 8 :
				// Lex.g:1:46: SKIP
				{
				mSKIP(); 

				}
				break;
			case 9 :
				// Lex.g:1:51: THEN
				{
				mTHEN(); 

				}
				break;
			case 10 :
				// Lex.g:1:56: TRUE
				{
				mTRUE(); 

				}
				break;
			case 11 :
				// Lex.g:1:61: WHILE
				{
				mWHILE(); 

				}
				break;
			case 12 :
				// Lex.g:1:67: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 13 :
				// Lex.g:1:77: OPENPAREN
				{
				mOPENPAREN(); 

				}
				break;
			case 14 :
				// Lex.g:1:87: CLOSEPAREN
				{
				mCLOSEPAREN(); 

				}
				break;
			case 15 :
				// Lex.g:1:98: INTNUM
				{
				mINTNUM(); 

				}
				break;
			case 16 :
				// Lex.g:1:105: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 17 :
				// Lex.g:1:111: STRING
				{
				mSTRING(); 

				}
				break;
			case 18 :
				// Lex.g:1:118: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 19 :
				// Lex.g:1:126: WS
				{
				mWS(); 

				}
				break;
			case 20 :
				// Lex.g:1:129: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 21 :
				// Lex.g:1:140: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 22 :
				// Lex.g:1:147: EQ
				{
				mEQ(); 

				}
				break;
			case 23 :
				// Lex.g:1:150: LEQ
				{
				mLEQ(); 

				}
				break;
			case 24 :
				// Lex.g:1:154: AND
				{
				mAND(); 

				}
				break;
			case 25 :
				// Lex.g:1:158: NOT
				{
				mNOT(); 

				}
				break;
			case 26 :
				// Lex.g:1:162: ADD
				{
				mADD(); 

				}
				break;
			case 27 :
				// Lex.g:1:166: SUB
				{
				mSUB(); 

				}
				break;
			case 28 :
				// Lex.g:1:170: MULTIPLY
				{
				mMULTIPLY(); 

				}
				break;
			case 29 :
				// Lex.g:1:179: GRT
				{
				mGRT(); 

				}
				break;
			case 30 :
				// Lex.g:1:183: LES
				{
				mLES(); 

				}
				break;
			case 31 :
				// Lex.g:1:187: GEQ
				{
				mGEQ(); 

				}
				break;
			case 32 :
				// Lex.g:1:191: OR
				{
				mOR(); 

				}
				break;
			case 33 :
				// Lex.g:1:194: NEQ
				{
				mNEQ(); 

				}
				break;
			case 34 :
				// Lex.g:1:198: DIVIDE
				{
				mDIVIDE(); 

				}
				break;
			case 35 :
				// Lex.g:1:205: BITXOR
				{
				mBITXOR(); 

				}
				break;

		}
	}


	protected DFA14 dfa14 = new DFA14(this);
	static final String DFA14_eotS =
		"\1\uffff\10\20\3\uffff\1\47\6\uffff\1\52\1\uffff\1\54\3\uffff\1\56\3\uffff"+
		"\2\20\1\61\2\20\1\64\4\20\10\uffff\2\20\1\uffff\2\20\1\uffff\6\20\1\103"+
		"\1\20\1\105\1\106\1\107\1\110\1\112\1\113\1\uffff\1\114\4\uffff\1\20\3"+
		"\uffff\1\116\1\uffff";
	static final String DFA14_eofS =
		"\117\uffff";
	static final String DFA14_minS =
		"\1\11\1\150\1\157\1\154\1\141\1\146\1\145\1\153\1\150\3\uffff\1\56\6\uffff"+
		"\1\75\1\uffff\1\75\3\uffff\1\75\3\uffff\2\151\1\60\1\163\1\154\1\60\1"+
		"\141\1\151\1\145\1\165\10\uffff\1\164\1\154\1\uffff\1\145\1\163\1\uffff"+
		"\1\144\1\160\1\156\3\145\1\60\1\145\6\60\1\uffff\1\60\4\uffff\1\156\3"+
		"\uffff\1\60\1\uffff";
	static final String DFA14_maxS =
		"\1\174\1\162\1\157\1\154\1\141\1\146\1\145\1\153\1\162\3\uffff\1\71\6"+
		"\uffff\1\75\1\uffff\1\75\3\uffff\1\75\3\uffff\2\151\1\172\1\163\1\154"+
		"\1\172\1\141\1\151\1\145\1\165\10\uffff\1\164\1\154\1\uffff\1\145\1\163"+
		"\1\uffff\1\144\1\160\1\156\3\145\1\172\1\145\6\172\1\uffff\1\172\4\uffff"+
		"\1\156\3\uffff\1\172\1\uffff";
	static final String DFA14_acceptS =
		"\11\uffff\1\14\1\15\1\16\1\uffff\1\21\1\22\1\23\1\24\1\25\1\26\1\uffff"+
		"\1\30\1\uffff\1\32\1\33\1\34\1\uffff\1\40\1\42\1\43\12\uffff\1\17\1\20"+
		"\1\27\1\36\1\41\1\31\1\37\1\35\2\uffff\1\3\2\uffff\1\6\16\uffff\1\4\1"+
		"\uffff\1\7\1\10\1\11\1\12\1\uffff\1\1\1\13\1\5\1\uffff\1\2";
	static final String DFA14_specialS =
		"\117\uffff}>";
	static final String[] DFA14_transitionS = {
			"\2\17\2\uffff\1\17\22\uffff\1\17\1\25\4\uffff\1\24\1\15\1\12\1\13\1\30"+
			"\1\26\1\uffff\1\27\1\uffff\1\33\12\14\1\21\1\11\1\23\1\22\1\31\2\uffff"+
			"\32\20\3\uffff\1\34\2\uffff\3\20\1\2\1\3\1\4\2\20\1\5\10\20\1\6\1\7\1"+
			"\10\2\20\1\1\3\20\1\16\1\32",
			"\1\36\11\uffff\1\35",
			"\1\37",
			"\1\40",
			"\1\41",
			"\1\42",
			"\1\43",
			"\1\44",
			"\1\45\11\uffff\1\46",
			"",
			"",
			"",
			"\1\50\1\uffff\12\14",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\51",
			"",
			"\1\53",
			"",
			"",
			"",
			"\1\55",
			"",
			"",
			"",
			"\1\57",
			"\1\60",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"\1\62",
			"\1\63",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\71",
			"\1\72",
			"",
			"\1\73",
			"\1\74",
			"",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"\1\104",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\13\20\1\111\16\20",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			"",
			"",
			"",
			"",
			"\1\115",
			"",
			"",
			"",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( WRITE | WRITELN | DO | ELSE | FALSE | IF | READ | SKIP | THEN | TRUE | WHILE | SEMICOLON | OPENPAREN | CLOSEPAREN | INTNUM | FLOAT | STRING | COMMENT | WS | IDENTIFIER | ASSIGN | EQ | LEQ | AND | NOT | ADD | SUB | MULTIPLY | GRT | LES | GEQ | OR | NEQ | DIVIDE | BITXOR );";
		}
	}

}
