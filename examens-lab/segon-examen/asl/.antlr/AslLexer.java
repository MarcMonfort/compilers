// Generated from /home/hammer/fib-upc/cl/NASA/examen/asl/Asl.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AslLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ASSIGN=10, PLUS=11, SUB=12, MUL=13, DIV=14, MOD=15, EQ=16, NEQ=17, GT=18, 
		GTE=19, LT=20, LTE=21, AND=22, OR=23, NOT=24, VAR=25, INT=26, FLOAT=27, 
		BOOL=28, CHAR=29, ARRAY=30, IF=31, THEN=32, ELSE=33, ENDIF=34, WHILE=35, 
		ENDWHILE=36, FUNC=37, ENDFUNC=38, RETURN=39, READ=40, WRITE=41, SUM=42, 
		FILTER=43, INTO=44, USING=45, MAX=46, FOR=47, IN=48, RANGE=49, ENDFOR=50, 
		A_MAX=51, INTVAL=52, FLOATVAL=53, CHARVAL=54, BOOLVAL=55, ID=56, STRING=57, 
		COMMENT=58, WS=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"ASSIGN", "PLUS", "SUB", "MUL", "DIV", "MOD", "EQ", "NEQ", "GT", "GTE", 
		"LT", "LTE", "AND", "OR", "NOT", "VAR", "INT", "FLOAT", "BOOL", "CHAR", 
		"ARRAY", "IF", "THEN", "ELSE", "ENDIF", "WHILE", "ENDWHILE", "FUNC", "ENDFUNC", 
		"RETURN", "READ", "WRITE", "SUM", "FILTER", "INTO", "USING", "MAX", "FOR", 
		"IN", "RANGE", "ENDFOR", "A_MAX", "INTVAL", "FLOATVAL", "CHARVAL", "BOOLVAL", 
		"ID", "STRING", "ESC_SEQ", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "','", "'['", "']'", "'of'", "';'", "'do'", 
		"'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", "'>='", 
		"'<'", "'<='", "'and'", "'or'", "'not'", "'var'", "'int'", "'float'", 
		"'bool'", "'char'", "'array'", "'if'", "'then'", "'else'", "'endif'", 
		"'while'", "'endwhile'", "'func'", "'endfunc'", "'return'", "'read'", 
		"'write'", "'sum'", "'filter'", "'into'", "'using'", "'max_'", "'for'", 
		"'in'", "'range'", "'endfor'", "'.max'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "ASSIGN", 
		"PLUS", "SUB", "MUL", "DIV", "MOD", "EQ", "NEQ", "GT", "GTE", "LT", "LTE", 
		"AND", "OR", "NOT", "VAR", "INT", "FLOAT", "BOOL", "CHAR", "ARRAY", "IF", 
		"THEN", "ELSE", "ENDIF", "WHILE", "ENDWHILE", "FUNC", "ENDFUNC", "RETURN", 
		"READ", "WRITE", "SUM", "FILTER", "INTO", "USING", "MAX", "FOR", "IN", 
		"RANGE", "ENDFOR", "A_MAX", "INTVAL", "FLOATVAL", "CHARVAL", "BOOLVAL", 
		"ID", "STRING", "COMMENT", "WS"
	};
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


	public AslLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Asl.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u0196\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65"+
		"\6\65\u014b\n\65\r\65\16\65\u014c\3\66\6\66\u0150\n\66\r\66\16\66\u0151"+
		"\3\66\3\66\6\66\u0156\n\66\r\66\16\66\u0157\3\67\3\67\3\67\5\67\u015d"+
		"\n\67\3\67\3\67\38\38\38\38\38\38\38\38\38\58\u016a\n8\39\39\79\u016e"+
		"\n9\f9\169\u0171\139\3:\3:\3:\7:\u0176\n:\f:\16:\u0179\13:\3:\3:\3;\3"+
		";\3;\3<\3<\3<\3<\7<\u0184\n<\f<\16<\u0187\13<\3<\5<\u018a\n<\3<\3<\3<"+
		"\3<\3=\6=\u0191\n=\r=\16=\u0192\3=\3=\2\2>\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w<y=\3\2\t\4\2))^^"+
		"\5\2C\\aac|\6\2\62;C\\aac|\4\2$$^^\n\2$$))^^ddhhppttvv\4\2\f\f\17\17\5"+
		"\2\13\f\17\17\"\"\2\u019f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2w\3\2\2\2"+
		"\2y\3\2\2\2\3{\3\2\2\2\5}\3\2\2\2\7\177\3\2\2\2\t\u0081\3\2\2\2\13\u0083"+
		"\3\2\2\2\r\u0085\3\2\2\2\17\u0087\3\2\2\2\21\u008a\3\2\2\2\23\u008c\3"+
		"\2\2\2\25\u008f\3\2\2\2\27\u0091\3\2\2\2\31\u0093\3\2\2\2\33\u0095\3\2"+
		"\2\2\35\u0097\3\2\2\2\37\u0099\3\2\2\2!\u009b\3\2\2\2#\u009e\3\2\2\2%"+
		"\u00a1\3\2\2\2\'\u00a3\3\2\2\2)\u00a6\3\2\2\2+\u00a8\3\2\2\2-\u00ab\3"+
		"\2\2\2/\u00af\3\2\2\2\61\u00b2\3\2\2\2\63\u00b6\3\2\2\2\65\u00ba\3\2\2"+
		"\2\67\u00be\3\2\2\29\u00c4\3\2\2\2;\u00c9\3\2\2\2=\u00ce\3\2\2\2?\u00d4"+
		"\3\2\2\2A\u00d7\3\2\2\2C\u00dc\3\2\2\2E\u00e1\3\2\2\2G\u00e7\3\2\2\2I"+
		"\u00ed\3\2\2\2K\u00f6\3\2\2\2M\u00fb\3\2\2\2O\u0103\3\2\2\2Q\u010a\3\2"+
		"\2\2S\u010f\3\2\2\2U\u0115\3\2\2\2W\u0119\3\2\2\2Y\u0120\3\2\2\2[\u0125"+
		"\3\2\2\2]\u012b\3\2\2\2_\u0130\3\2\2\2a\u0134\3\2\2\2c\u0137\3\2\2\2e"+
		"\u013d\3\2\2\2g\u0144\3\2\2\2i\u014a\3\2\2\2k\u014f\3\2\2\2m\u0159\3\2"+
		"\2\2o\u0169\3\2\2\2q\u016b\3\2\2\2s\u0172\3\2\2\2u\u017c\3\2\2\2w\u017f"+
		"\3\2\2\2y\u0190\3\2\2\2{|\7*\2\2|\4\3\2\2\2}~\7+\2\2~\6\3\2\2\2\177\u0080"+
		"\7<\2\2\u0080\b\3\2\2\2\u0081\u0082\7.\2\2\u0082\n\3\2\2\2\u0083\u0084"+
		"\7]\2\2\u0084\f\3\2\2\2\u0085\u0086\7_\2\2\u0086\16\3\2\2\2\u0087\u0088"+
		"\7q\2\2\u0088\u0089\7h\2\2\u0089\20\3\2\2\2\u008a\u008b\7=\2\2\u008b\22"+
		"\3\2\2\2\u008c\u008d\7f\2\2\u008d\u008e\7q\2\2\u008e\24\3\2\2\2\u008f"+
		"\u0090\7?\2\2\u0090\26\3\2\2\2\u0091\u0092\7-\2\2\u0092\30\3\2\2\2\u0093"+
		"\u0094\7/\2\2\u0094\32\3\2\2\2\u0095\u0096\7,\2\2\u0096\34\3\2\2\2\u0097"+
		"\u0098\7\61\2\2\u0098\36\3\2\2\2\u0099\u009a\7\'\2\2\u009a \3\2\2\2\u009b"+
		"\u009c\7?\2\2\u009c\u009d\7?\2\2\u009d\"\3\2\2\2\u009e\u009f\7#\2\2\u009f"+
		"\u00a0\7?\2\2\u00a0$\3\2\2\2\u00a1\u00a2\7@\2\2\u00a2&\3\2\2\2\u00a3\u00a4"+
		"\7@\2\2\u00a4\u00a5\7?\2\2\u00a5(\3\2\2\2\u00a6\u00a7\7>\2\2\u00a7*\3"+
		"\2\2\2\u00a8\u00a9\7>\2\2\u00a9\u00aa\7?\2\2\u00aa,\3\2\2\2\u00ab\u00ac"+
		"\7c\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7f\2\2\u00ae.\3\2\2\2\u00af\u00b0"+
		"\7q\2\2\u00b0\u00b1\7t\2\2\u00b1\60\3\2\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4"+
		"\7q\2\2\u00b4\u00b5\7v\2\2\u00b5\62\3\2\2\2\u00b6\u00b7\7x\2\2\u00b7\u00b8"+
		"\7c\2\2\u00b8\u00b9\7t\2\2\u00b9\64\3\2\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc"+
		"\7p\2\2\u00bc\u00bd\7v\2\2\u00bd\66\3\2\2\2\u00be\u00bf\7h\2\2\u00bf\u00c0"+
		"\7n\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7v\2\2\u00c3"+
		"8\3\2\2\2\u00c4\u00c5\7d\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7q\2\2\u00c7"+
		"\u00c8\7n\2\2\u00c8:\3\2\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7j\2\2\u00cb"+
		"\u00cc\7c\2\2\u00cc\u00cd\7t\2\2\u00cd<\3\2\2\2\u00ce\u00cf\7c\2\2\u00cf"+
		"\u00d0\7t\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7{\2\2"+
		"\u00d3>\3\2\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7h\2\2\u00d6@\3\2\2\2\u00d7"+
		"\u00d8\7v\2\2\u00d8\u00d9\7j\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7p\2\2"+
		"\u00dbB\3\2\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7n\2\2\u00de\u00df\7u\2"+
		"\2\u00df\u00e0\7g\2\2\u00e0D\3\2\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7"+
		"p\2\2\u00e3\u00e4\7f\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7h\2\2\u00e6F"+
		"\3\2\2\2\u00e7\u00e8\7y\2\2\u00e8\u00e9\7j\2\2\u00e9\u00ea\7k\2\2\u00ea"+
		"\u00eb\7n\2\2\u00eb\u00ec\7g\2\2\u00ecH\3\2\2\2\u00ed\u00ee\7g\2\2\u00ee"+
		"\u00ef\7p\2\2\u00ef\u00f0\7f\2\2\u00f0\u00f1\7y\2\2\u00f1\u00f2\7j\2\2"+
		"\u00f2\u00f3\7k\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7g\2\2\u00f5J\3\2\2"+
		"\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa"+
		"\7e\2\2\u00faL\3\2\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe"+
		"\7f\2\2\u00fe\u00ff\7h\2\2\u00ff\u0100\7w\2\2\u0100\u0101\7p\2\2\u0101"+
		"\u0102\7e\2\2\u0102N\3\2\2\2\u0103\u0104\7t\2\2\u0104\u0105\7g\2\2\u0105"+
		"\u0106\7v\2\2\u0106\u0107\7w\2\2\u0107\u0108\7t\2\2\u0108\u0109\7p\2\2"+
		"\u0109P\3\2\2\2\u010a\u010b\7t\2\2\u010b\u010c\7g\2\2\u010c\u010d\7c\2"+
		"\2\u010d\u010e\7f\2\2\u010eR\3\2\2\2\u010f\u0110\7y\2\2\u0110\u0111\7"+
		"t\2\2\u0111\u0112\7k\2\2\u0112\u0113\7v\2\2\u0113\u0114\7g\2\2\u0114T"+
		"\3\2\2\2\u0115\u0116\7u\2\2\u0116\u0117\7w\2\2\u0117\u0118\7o\2\2\u0118"+
		"V\3\2\2\2\u0119\u011a\7h\2\2\u011a\u011b\7k\2\2\u011b\u011c\7n\2\2\u011c"+
		"\u011d\7v\2\2\u011d\u011e\7g\2\2\u011e\u011f\7t\2\2\u011fX\3\2\2\2\u0120"+
		"\u0121\7k\2\2\u0121\u0122\7p\2\2\u0122\u0123\7v\2\2\u0123\u0124\7q\2\2"+
		"\u0124Z\3\2\2\2\u0125\u0126\7w\2\2\u0126\u0127\7u\2\2\u0127\u0128\7k\2"+
		"\2\u0128\u0129\7p\2\2\u0129\u012a\7i\2\2\u012a\\\3\2\2\2\u012b\u012c\7"+
		"o\2\2\u012c\u012d\7c\2\2\u012d\u012e\7z\2\2\u012e\u012f\7a\2\2\u012f^"+
		"\3\2\2\2\u0130\u0131\7h\2\2\u0131\u0132\7q\2\2\u0132\u0133\7t\2\2\u0133"+
		"`\3\2\2\2\u0134\u0135\7k\2\2\u0135\u0136\7p\2\2\u0136b\3\2\2\2\u0137\u0138"+
		"\7t\2\2\u0138\u0139\7c\2\2\u0139\u013a\7p\2\2\u013a\u013b\7i\2\2\u013b"+
		"\u013c\7g\2\2\u013cd\3\2\2\2\u013d\u013e\7g\2\2\u013e\u013f\7p\2\2\u013f"+
		"\u0140\7f\2\2\u0140\u0141\7h\2\2\u0141\u0142\7q\2\2\u0142\u0143\7t\2\2"+
		"\u0143f\3\2\2\2\u0144\u0145\7\60\2\2\u0145\u0146\7o\2\2\u0146\u0147\7"+
		"c\2\2\u0147\u0148\7z\2\2\u0148h\3\2\2\2\u0149\u014b\4\62;\2\u014a\u0149"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"j\3\2\2\2\u014e\u0150\4\62;\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2"+
		"\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155"+
		"\7\60\2\2\u0154\u0156\4\62;\2\u0155\u0154\3\2\2\2\u0156\u0157\3\2\2\2"+
		"\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158l\3\2\2\2\u0159\u015c\7"+
		")\2\2\u015a\u015d\5u;\2\u015b\u015d\n\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\7)\2\2\u015fn\3\2\2\2\u0160"+
		"\u0161\7v\2\2\u0161\u0162\7t\2\2\u0162\u0163\7w\2\2\u0163\u016a\7g\2\2"+
		"\u0164\u0165\7h\2\2\u0165\u0166\7c\2\2\u0166\u0167\7n\2\2\u0167\u0168"+
		"\7u\2\2\u0168\u016a\7g\2\2\u0169\u0160\3\2\2\2\u0169\u0164\3\2\2\2\u016a"+
		"p\3\2\2\2\u016b\u016f\t\3\2\2\u016c\u016e\t\4\2\2\u016d\u016c\3\2\2\2"+
		"\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170r\3"+
		"\2\2\2\u0171\u016f\3\2\2\2\u0172\u0177\7$\2\2\u0173\u0176\5u;\2\u0174"+
		"\u0176\n\5\2\2\u0175\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0176\u0179\3\2"+
		"\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179"+
		"\u0177\3\2\2\2\u017a\u017b\7$\2\2\u017bt\3\2\2\2\u017c\u017d\7^\2\2\u017d"+
		"\u017e\t\6\2\2\u017ev\3\2\2\2\u017f\u0180\7\61\2\2\u0180\u0181\7\61\2"+
		"\2\u0181\u0185\3\2\2\2\u0182\u0184\n\7\2\2\u0183\u0182\3\2\2\2\u0184\u0187"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0189\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0188\u018a\7\17\2\2\u0189\u0188\3\2\2\2\u0189\u018a\3"+
		"\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\7\f\2\2\u018c\u018d\3\2\2\2\u018d"+
		"\u018e\b<\2\2\u018ex\3\2\2\2\u018f\u0191\t\b\2\2\u0190\u018f\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\3\2"+
		"\2\2\u0194\u0195\b=\2\2\u0195z\3\2\2\2\16\2\u014c\u0151\u0157\u015c\u0169"+
		"\u016f\u0175\u0177\u0185\u0189\u0192\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}