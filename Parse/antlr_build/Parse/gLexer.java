// Generated from Parse/gLexer.g4 by ANTLR 4.13.2

	package Parse.antlr_build;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class gLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, LINE_COMMENT=2, VAR=3, FUN=4, WHILE=5, CONST=6, STRING=7, VOID=8, 
		RETURN=9, IF=10, ELSE=11, BREAK=12, INT=13, TYPEDEF=14, STRUCT=15, UNION=16, 
		ARROW=17, ANDAND=18, OROR=19, LT=20, STAR=21, PLUS=22, TILDE=23, ASSIGN=24, 
		DOT=25, LBRACE=26, RBRACE=27, COMMA=28, LPAREN=29, RPAREN=30, AMP=31, 
		BAR=32, BANG=33, SEMI=34, COLON=35, LBRACK=36, RBRACK=37, STRING_LITERAL=38, 
		DECIMAL_LITERAL=39, ID=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALPHA", "DIGIT", "WS", "LINE_COMMENT", "VAR", "FUN", "WHILE", "CONST", 
			"STRING", "VOID", "RETURN", "IF", "ELSE", "BREAK", "INT", "TYPEDEF", 
			"STRUCT", "UNION", "ARROW", "ANDAND", "OROR", "LT", "STAR", "PLUS", "TILDE", 
			"ASSIGN", "DOT", "LBRACE", "RBRACE", "COMMA", "LPAREN", "RPAREN", "AMP", 
			"BAR", "BANG", "SEMI", "COLON", "LBRACK", "RBRACK", "STRING_LITERAL", 
			"DECIMAL_LITERAL", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'var'", "'fun'", "'while'", "'const'", "'string'", 
			"'void'", "'return'", "'if'", "'else'", "'break'", "'int'", "'typedef'", 
			"'struct'", "'union'", "'->'", "'&&'", "'||'", "'<'", "'*'", "'+'", "'~'", 
			"'='", "'.'", "'{'", "'}'", "','", "'('", "')'", "'&'", "'|'", "'!'", 
			"';'", "':'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "LINE_COMMENT", "VAR", "FUN", "WHILE", "CONST", "STRING", 
			"VOID", "RETURN", "IF", "ELSE", "BREAK", "INT", "TYPEDEF", "STRUCT", 
			"UNION", "ARROW", "ANDAND", "OROR", "LT", "STAR", "PLUS", "TILDE", "ASSIGN", 
			"DOT", "LBRACE", "RBRACE", "COMMA", "LPAREN", "RPAREN", "AMP", "BAR", 
			"BANG", "SEMI", "COLON", "LBRACK", "RBRACK", "STRING_LITERAL", "DECIMAL_LITERAL", 
			"ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	   private int stringToInt(String target) {
	      if (target == null || target.length() == 0) return 0;
	      if (target.charAt(0) == 'x' || target.charAt(0) == 'X') {
	         return Integer.parseInt(target.substring(1), 16);
	      }
	      return Integer.parseInt(target, 8);
	   }

	   private String processString(String raw) {
	      StringBuilder out = new StringBuilder();
	      int i = 1;
	      int end = raw.length() - 1;
	      while (i < end) {
	         char c = raw.charAt(i);
	         if (c != '\\') {
	            out.append(c);
	            i++;
	            continue;
	         }
	         i++;
	         if (i >= end) break;
	         char e = raw.charAt(i);
	         if (e == 'n') { out.append('\n'); i++; continue; }
	         if (e == 't') { out.append('\t'); i++; continue; }
	         if (e == 'r') { out.append('\r'); i++; continue; }
	         if (e == 'b') { out.append('\b'); i++; continue; }
	         if (e == 'f') { out.append('\f'); i++; continue; }
	         if (e == '\\') { out.append('\\'); i++; continue; }
	         if (e == '"') { out.append('\"'); i++; continue; }

	         if (e == 'x' || e == 'X') {
	            int j = i + 1;
	            while (j < end) {
	               char h = raw.charAt(j);
	               boolean ok = (h >= '0' && h <= '9') || (h >= 'a' && h <= 'f') || (h >= 'A' && h <= 'F');
	               if (!ok) break;
	               j++;
	            }
	            String hex = raw.substring(i, j);
	            out.append((char) stringToInt(hex));
	            i = j;
	            continue;
	         }

	         if (e >= '0' && e <= '7') {
	            int j = i;
	            int count = 0;
	            while (j < end && count < 3) {
	               char o = raw.charAt(j);
	               if (o < '0' || o > '7') break;
	               j++;
	               count++;
	            }
	            String oct = raw.substring(i, j);
	            out.append((char) stringToInt(oct));
	            i = j;
	            continue;
	         }

	         out.append(e);
	         i++;
	      }
	      return out.toString();
	   }


	public gLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 39:
			STRING_LITERAL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setText(processString(getText())); 
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000(\u0103\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002[\b\u0002\u000b\u0002"+
		"\f\u0002\\\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003e\b\u0003\n\u0003\f\u0003h\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!"+
		"\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u00eb\b\'\n\'\f\'\u00ee"+
		"\t\'\u0001\'\u0001\'\u0001\'\u0001(\u0004(\u00f4\b(\u000b(\f(\u00f5\u0001"+
		")\u0001)\u0003)\u00fa\b)\u0001)\u0001)\u0001)\u0005)\u00ff\b)\n)\f)\u0102"+
		"\t)\u0000\u0000*\u0001\u0000\u0003\u0000\u0005\u0001\u0007\u0002\t\u0003"+
		"\u000b\u0004\r\u0005\u000f\u0006\u0011\u0007\u0013\b\u0015\t\u0017\n\u0019"+
		"\u000b\u001b\f\u001d\r\u001f\u000e!\u000f#\u0010%\u0011\'\u0012)\u0013"+
		"+\u0014-\u0015/\u00161\u00173\u00185\u00197\u001a9\u001b;\u001c=\u001d"+
		"?\u001eA\u001fC E!G\"I#K$M%O&Q\'S(\u0001\u0000\u0005\u0002\u0000AZaz\u0001"+
		"\u000009\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0004\u0000\n\n\r\r"+
		"\"\"\\\\\u0109\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001"+
		"\u0000\u0000\u0000\u0001U\u0001\u0000\u0000\u0000\u0003W\u0001\u0000\u0000"+
		"\u0000\u0005Z\u0001\u0000\u0000\u0000\u0007`\u0001\u0000\u0000\u0000\t"+
		"k\u0001\u0000\u0000\u0000\u000bo\u0001\u0000\u0000\u0000\rs\u0001\u0000"+
		"\u0000\u0000\u000fy\u0001\u0000\u0000\u0000\u0011\u007f\u0001\u0000\u0000"+
		"\u0000\u0013\u0086\u0001\u0000\u0000\u0000\u0015\u008b\u0001\u0000\u0000"+
		"\u0000\u0017\u0092\u0001\u0000\u0000\u0000\u0019\u0095\u0001\u0000\u0000"+
		"\u0000\u001b\u009a\u0001\u0000\u0000\u0000\u001d\u00a0\u0001\u0000\u0000"+
		"\u0000\u001f\u00a4\u0001\u0000\u0000\u0000!\u00ac\u0001\u0000\u0000\u0000"+
		"#\u00b3\u0001\u0000\u0000\u0000%\u00b9\u0001\u0000\u0000\u0000\'\u00bc"+
		"\u0001\u0000\u0000\u0000)\u00bf\u0001\u0000\u0000\u0000+\u00c2\u0001\u0000"+
		"\u0000\u0000-\u00c4\u0001\u0000\u0000\u0000/\u00c6\u0001\u0000\u0000\u0000"+
		"1\u00c8\u0001\u0000\u0000\u00003\u00ca\u0001\u0000\u0000\u00005\u00cc"+
		"\u0001\u0000\u0000\u00007\u00ce\u0001\u0000\u0000\u00009\u00d0\u0001\u0000"+
		"\u0000\u0000;\u00d2\u0001\u0000\u0000\u0000=\u00d4\u0001\u0000\u0000\u0000"+
		"?\u00d6\u0001\u0000\u0000\u0000A\u00d8\u0001\u0000\u0000\u0000C\u00da"+
		"\u0001\u0000\u0000\u0000E\u00dc\u0001\u0000\u0000\u0000G\u00de\u0001\u0000"+
		"\u0000\u0000I\u00e0\u0001\u0000\u0000\u0000K\u00e2\u0001\u0000\u0000\u0000"+
		"M\u00e4\u0001\u0000\u0000\u0000O\u00e6\u0001\u0000\u0000\u0000Q\u00f3"+
		"\u0001\u0000\u0000\u0000S\u00f9\u0001\u0000\u0000\u0000UV\u0007\u0000"+
		"\u0000\u0000V\u0002\u0001\u0000\u0000\u0000WX\u0007\u0001\u0000\u0000"+
		"X\u0004\u0001\u0000\u0000\u0000Y[\u0007\u0002\u0000\u0000ZY\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]"+
		"\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0006\u0002\u0000"+
		"\u0000_\u0006\u0001\u0000\u0000\u0000`a\u0005/\u0000\u0000ab\u0005/\u0000"+
		"\u0000bf\u0001\u0000\u0000\u0000ce\b\u0003\u0000\u0000dc\u0001\u0000\u0000"+
		"\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ij\u0006"+
		"\u0003\u0000\u0000j\b\u0001\u0000\u0000\u0000kl\u0005v\u0000\u0000lm\u0005"+
		"a\u0000\u0000mn\u0005r\u0000\u0000n\n\u0001\u0000\u0000\u0000op\u0005"+
		"f\u0000\u0000pq\u0005u\u0000\u0000qr\u0005n\u0000\u0000r\f\u0001\u0000"+
		"\u0000\u0000st\u0005w\u0000\u0000tu\u0005h\u0000\u0000uv\u0005i\u0000"+
		"\u0000vw\u0005l\u0000\u0000wx\u0005e\u0000\u0000x\u000e\u0001\u0000\u0000"+
		"\u0000yz\u0005c\u0000\u0000z{\u0005o\u0000\u0000{|\u0005n\u0000\u0000"+
		"|}\u0005s\u0000\u0000}~\u0005t\u0000\u0000~\u0010\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005s\u0000\u0000\u0080\u0081\u0005t\u0000\u0000\u0081\u0082"+
		"\u0005r\u0000\u0000\u0082\u0083\u0005i\u0000\u0000\u0083\u0084\u0005n"+
		"\u0000\u0000\u0084\u0085\u0005g\u0000\u0000\u0085\u0012\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005v\u0000\u0000\u0087\u0088\u0005o\u0000\u0000\u0088"+
		"\u0089\u0005i\u0000\u0000\u0089\u008a\u0005d\u0000\u0000\u008a\u0014\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005r\u0000\u0000\u008c\u008d\u0005e\u0000"+
		"\u0000\u008d\u008e\u0005t\u0000\u0000\u008e\u008f\u0005u\u0000\u0000\u008f"+
		"\u0090\u0005r\u0000\u0000\u0090\u0091\u0005n\u0000\u0000\u0091\u0016\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0005i\u0000\u0000\u0093\u0094\u0005f\u0000"+
		"\u0000\u0094\u0018\u0001\u0000\u0000\u0000\u0095\u0096\u0005e\u0000\u0000"+
		"\u0096\u0097\u0005l\u0000\u0000\u0097\u0098\u0005s\u0000\u0000\u0098\u0099"+
		"\u0005e\u0000\u0000\u0099\u001a\u0001\u0000\u0000\u0000\u009a\u009b\u0005"+
		"b\u0000\u0000\u009b\u009c\u0005r\u0000\u0000\u009c\u009d\u0005e\u0000"+
		"\u0000\u009d\u009e\u0005a\u0000\u0000\u009e\u009f\u0005k\u0000\u0000\u009f"+
		"\u001c\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005i\u0000\u0000\u00a1\u00a2"+
		"\u0005n\u0000\u0000\u00a2\u00a3\u0005t\u0000\u0000\u00a3\u001e\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0005t\u0000\u0000\u00a5\u00a6\u0005y\u0000\u0000"+
		"\u00a6\u00a7\u0005p\u0000\u0000\u00a7\u00a8\u0005e\u0000\u0000\u00a8\u00a9"+
		"\u0005d\u0000\u0000\u00a9\u00aa\u0005e\u0000\u0000\u00aa\u00ab\u0005f"+
		"\u0000\u0000\u00ab \u0001\u0000\u0000\u0000\u00ac\u00ad\u0005s\u0000\u0000"+
		"\u00ad\u00ae\u0005t\u0000\u0000\u00ae\u00af\u0005r\u0000\u0000\u00af\u00b0"+
		"\u0005u\u0000\u0000\u00b0\u00b1\u0005c\u0000\u0000\u00b1\u00b2\u0005t"+
		"\u0000\u0000\u00b2\"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005u\u0000"+
		"\u0000\u00b4\u00b5\u0005n\u0000\u0000\u00b5\u00b6\u0005i\u0000\u0000\u00b6"+
		"\u00b7\u0005o\u0000\u0000\u00b7\u00b8\u0005n\u0000\u0000\u00b8$\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0005-\u0000\u0000\u00ba\u00bb\u0005>\u0000"+
		"\u0000\u00bb&\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005&\u0000\u0000\u00bd"+
		"\u00be\u0005&\u0000\u0000\u00be(\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005"+
		"|\u0000\u0000\u00c0\u00c1\u0005|\u0000\u0000\u00c1*\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005<\u0000\u0000\u00c3,\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0005*\u0000\u0000\u00c5.\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005"+
		"+\u0000\u0000\u00c70\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005~\u0000"+
		"\u0000\u00c92\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005=\u0000\u0000\u00cb"+
		"4\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005.\u0000\u0000\u00cd6\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0005{\u0000\u0000\u00cf8\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0005}\u0000\u0000\u00d1:\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0005,\u0000\u0000\u00d3<\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		"(\u0000\u0000\u00d5>\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005)\u0000"+
		"\u0000\u00d7@\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005&\u0000\u0000\u00d9"+
		"B\u0001\u0000\u0000\u0000\u00da\u00db\u0005|\u0000\u0000\u00dbD\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0005!\u0000\u0000\u00ddF\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005;\u0000\u0000\u00dfH\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0005:\u0000\u0000\u00e1J\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005"+
		"[\u0000\u0000\u00e3L\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005]\u0000"+
		"\u0000\u00e5N\u0001\u0000\u0000\u0000\u00e6\u00ec\u0005\"\u0000\u0000"+
		"\u00e7\u00e8\u0005\\\u0000\u0000\u00e8\u00eb\t\u0000\u0000\u0000\u00e9"+
		"\u00eb\b\u0004\u0000\u0000\u00ea\u00e7\u0001\u0000\u0000\u0000\u00ea\u00e9"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0005\"\u0000\u0000\u00f0\u00f1\u0006\'\u0001\u0000\u00f1P\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f4\u0003\u0003\u0001\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6R\u0001\u0000\u0000"+
		"\u0000\u00f7\u00fa\u0003\u0001\u0000\u0000\u00f8\u00fa\u0005_\u0000\u0000"+
		"\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000"+
		"\u00fa\u0100\u0001\u0000\u0000\u0000\u00fb\u00ff\u0003\u0001\u0000\u0000"+
		"\u00fc\u00ff\u0003\u0003\u0001\u0000\u00fd\u00ff\u0005_\u0000\u0000\u00fe"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe"+
		"\u00fd\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100"+
		"\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101"+
		"T\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\t\u0000"+
		"\\f\u00ea\u00ec\u00f5\u00f9\u00fe\u0100\u0002\u0006\u0000\u0000\u0001"+
		"\'\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}