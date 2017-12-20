package consulo.freemarker.lang.lexer;

import consulo.freemarker.lang.psi.FreeMarkerElementType;
import consulo.freemarker.lang.psi.FreeMarkerElementTypes;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 21.04.2007
 * Time: 17:40:43
 */
public interface FreeMarkerTokenTypes
{
	//IElementType ALPHA = new IChameleonElementType("FM:ALPHA", StdLanguages.HTML);
	IElementType ALPHA = FreeMarkerElementTypes.TEMPLATE_TEXT;

	IElementType WHITESPACE = TokenType.WHITE_SPACE;
	IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;


	IElementType NATURAL_GT = new FreeMarkerElementType("NATURAL_GT");
	IElementType NATURAL_GTE = new FreeMarkerElementType("NATURAL_GTE");

	IElementType STRING_LITERAL = new FreeMarkerElementType("STRING_LITERAL");
	IElementType RAW_STRING = new FreeMarkerElementType("RAW_STRING");

	IElementType FALSE = new FreeMarkerElementType("FALSE");
	IElementType TRUE = new FreeMarkerElementType("TRUE");

	IElementType INTEGER = new FreeMarkerElementType("INTEGER");
	IElementType DECIMAL = new FreeMarkerElementType("DECIMAL");

	IElementType DOT = new FreeMarkerElementType("DOT");
	IElementType DOT_DOT = new FreeMarkerElementType("DOT_DOT");
	IElementType BUILT_IN = new FreeMarkerElementType("BUILT_IN");
	IElementType EXISTS = new FreeMarkerElementType("EXISTS");
	IElementType EQUALS = new FreeMarkerElementType("EQUALS");
	IElementType DOUBLE_EQUALS = new FreeMarkerElementType("DOUBLE_EQUALS");
	IElementType NOT_EQUALS = new FreeMarkerElementType("NOT_EQUALS");
	IElementType LESS_THAN = new FreeMarkerElementType("LESS_THAN");
	IElementType LESS_THAN_EQUALS = new FreeMarkerElementType("LESS_THAN_EQUALS");
	IElementType ESCAPED_GT = new FreeMarkerElementType("ESCAPED_GT");
	IElementType ESCAPED_GTE = new FreeMarkerElementType("ESCAPED_GTE");
	IElementType PLUS = new FreeMarkerElementType("PLUS");
	IElementType MINUS = new FreeMarkerElementType("MINUS");
	IElementType TIMES = new FreeMarkerElementType("TIMES");
	IElementType DOUBLE_STAR = new FreeMarkerElementType("DOUBLE_STAR");
	IElementType ELLIPSIS = new FreeMarkerElementType("ELLIPSIS");
	IElementType DIVIDE = new FreeMarkerElementType("DIVIDE");
	IElementType PERCENT = new FreeMarkerElementType("PERCENT");
	IElementType AND = new FreeMarkerElementType("AND");
	IElementType OR = new FreeMarkerElementType("OR");
	IElementType EXCLAM = new FreeMarkerElementType("EXCLAM");
	IElementType COMMA = new FreeMarkerElementType("COMMA");
	IElementType SEMICOLON = new FreeMarkerElementType("SEMICOLON");
	IElementType COLON = new FreeMarkerElementType("COLON");
	IElementType OPEN_BRACKET = new FreeMarkerElementType("OPEN_BRACKET");
	IElementType CLOSE_BRACKET = new FreeMarkerElementType("CLOSE_BRACKET");
	IElementType OPEN_PAREN = new FreeMarkerElementType("OPEN_PAREN");
	IElementType CLOSE_PAREN = new FreeMarkerElementType("CLOSE_PAREN");
	IElementType OPEN_BRACE = new FreeMarkerElementType("OPEN_BRACE");
	IElementType CLOSE_BRACE = new FreeMarkerElementType("CLOSE_BRACE");
	IElementType EVALUATION_END = new FreeMarkerElementType("EVALUATION_END");// my stuff
	IElementType IN = new FreeMarkerElementType("IN");
	IElementType AS = new FreeMarkerElementType("AS");
	IElementType USING = new FreeMarkerElementType("USING");
	IElementType ID = new FreeMarkerElementType("ID");

	IElementType EMPTY_DIRECTIVE_END = new FreeMarkerElementType("EMPTY_DIRECTIVE_END"); //my stuff
	IElementType DIRECTIVE_END = new FreeMarkerElementType("DIRECTIVE_END"); //my stuff

	IElementType OUTPUT_ESCAPE = new FreeMarkerElementType("OUTPUT_ESCAPE");
	IElementType NUMERICAL_ESCAPE = new FreeMarkerElementType("NUMERICAL_ESCAPE");

	/**
	 * from fmparser.jj
	 */
	IElementType ATTEMPT_START = new FreeMarkerElementType("ATTEMPT_START");
	IElementType ATTEMPT_END = new FreeMarkerElementType("ATTEMPT_END");

	IElementType RECOVER_START = new FreeMarkerElementType("RECOVER_START");
	IElementType RECOVER_END = new FreeMarkerElementType("RECOVER_END");

	IElementType COMPRESS_START = new FreeMarkerElementType("COMPRESS_START");
	IElementType COMPRESS_END = new FreeMarkerElementType("COMPRESS_END");

	IElementType COMMENT_START = new FreeMarkerElementType("COMMENT_START");
	IElementType COMMENT_END = new FreeMarkerElementType("COMMENT_END");

	IElementType TERSE_COMMENT_START = new FreeMarkerElementType("TERSE_COMMENT_START");
	IElementType TERSE_COMMENT_CONTENTS = new FreeMarkerElementType("TERSE_COMMENT_CONTENTS"); //my stuff
	IElementType TERSE_COMMENT_END = new FreeMarkerElementType("TERSE_COMMENT_END"); //my stuff

	IElementType NOPARSE_START = new FreeMarkerElementType("NOPARSE_START");
	//IElementType NOPARSE_CONTENTS = new FMElementType("NOPARSE_CONTENTS"); //my stuff
	IElementType NOPARSE_END = new FreeMarkerElementType("NOPARSE_END");

	IElementType IF_START = new FreeMarkerElementType("IF_START");
	IElementType IF_END = new FreeMarkerElementType("IF_END");

	IElementType LIST_START = new FreeMarkerElementType("LIST_START");
	IElementType LIST_END = new FreeMarkerElementType("LIST_END");

	IElementType FOREACH_START = new FreeMarkerElementType("FOREACH_START");
	IElementType FOREACH_END = new FreeMarkerElementType("FOREACH_END");

	IElementType LOCAL_START = new FreeMarkerElementType("LOCAL_START");
	IElementType LOCAL_END = new FreeMarkerElementType("LOCAL_END");

	IElementType GLOBAL_START = new FreeMarkerElementType("GLOBAL_START");
	IElementType GLOBAL_END = new FreeMarkerElementType("GLOBAL_END");

	IElementType ASSIGN_START = new FreeMarkerElementType("ASSIGN_START");
	IElementType ASSIGN_END = new FreeMarkerElementType("ASSIGN_END");

	IElementType FUNCTION_START = new FreeMarkerElementType("FUNCTION_START");
	IElementType FUNCTION_END = new FreeMarkerElementType("FUNCTION_END");

	IElementType MACRO_START = new FreeMarkerElementType("MACRO_START");
	IElementType MACRO_END = new FreeMarkerElementType("MACRO_END");

	IElementType TRANSFORM_START = new FreeMarkerElementType("TRANSFORM_START");
	IElementType TRANSFORM_END = new FreeMarkerElementType("TRANSFORM_END");

	IElementType SWITCH_START = new FreeMarkerElementType("SWITCH_START");
	IElementType SWITCH_END = new FreeMarkerElementType("SWITCH_END");


	IElementType ELSE = new FreeMarkerElementType("ELSE");
	IElementType ELSE_IF = new FreeMarkerElementType("ELSE_IF");
	IElementType BREAK = new FreeMarkerElementType("BREAK");
	IElementType SIMPLE_RETURN = new FreeMarkerElementType("SIMPLE_RETURN");
	IElementType HALT = new FreeMarkerElementType("HALT");
	IElementType FLUSH = new FreeMarkerElementType("FLUSH");
	IElementType TRIM = new FreeMarkerElementType("TRIM");
	IElementType LTRIM = new FreeMarkerElementType("LTRIM");
	IElementType RTRIM = new FreeMarkerElementType("RTRIM");
	IElementType NOTRIM = new FreeMarkerElementType("NOTRIM");
	IElementType DEFAULT = new FreeMarkerElementType("DEFAULT");

	IElementType SIMPLE_NESTED = new FreeMarkerElementType("SIMPLE_NESTED");
	IElementType NESTED = new FreeMarkerElementType("NESTED");

	IElementType SIMPLE_RECURSE = new FreeMarkerElementType("SIMPLE_RECURSE");
	IElementType RECURSE = new FreeMarkerElementType("RECURSE");

	IElementType FALLBACK = new FreeMarkerElementType("FALLBACK");

	IElementType ESCAPE_START = new FreeMarkerElementType("ESCAPE_START");
	IElementType ESCAPE_END = new FreeMarkerElementType("ESCAPE_END");

	IElementType NOESCAPE_START = new FreeMarkerElementType("NOESCAPE_START");
	IElementType NOESCAPE_END = new FreeMarkerElementType("NOESCAPE_END");

	IElementType CASE = new FreeMarkerElementType("CASE");
	IElementType INCLUDE = new FreeMarkerElementType("INCLUDE");
	IElementType IMPORT = new FreeMarkerElementType("IMPORT");
	IElementType VISIT = new FreeMarkerElementType("VISIT");
	IElementType STOP = new FreeMarkerElementType("STOP");
	IElementType RETURN = new FreeMarkerElementType("RETURN");
	IElementType CALL = new FreeMarkerElementType("CALL");
	IElementType SETTING = new FreeMarkerElementType("SETTING");


	IElementType UNIFIED_CALL = new FreeMarkerElementType("UNIFIED_CALL");
	IElementType UNIFIED_CALL_END = new FreeMarkerElementType("UNIFIED_CALL_END");

	IElementType UNKNOWN_DIRECTIVE = new FreeMarkerElementType("UNKNOWN_DIRECTIVE");

	IElementType FTL_HEADER = new FreeMarkerElementType("FTL_HEADER");
	IElementType TRIVIAL_FTL_HEADER = new FreeMarkerElementType("TRIVIAL_FTL_HEADER");


	/**************************************************************************
	 *                  TOKEN SETS
	 *************************************************************************/

	/**
	 * Comments: wiill be gray
	 */
	TokenSet COMMENTS_SET = TokenSet.create(TERSE_COMMENT_START, TERSE_COMMENT_CONTENTS, TERSE_COMMENT_END);

	/**
	 * Tagnames
	 */
	TokenSet KEYWORDS_SET = TokenSet.create(ATTEMPT_START, ATTEMPT_END, RECOVER_START, RECOVER_END, COMPRESS_START, COMPRESS_END, COMMENT_START, COMMENT_END, NOPARSE_START, NOPARSE_END, IF_START, IF_END, LIST_START, LIST_END, FOREACH_START, FOREACH_END, LOCAL_START, LOCAL_END, GLOBAL_START, GLOBAL_END, ASSIGN_START, ASSIGN_END, FUNCTION_START, FUNCTION_END, MACRO_START, MACRO_END, TRANSFORM_START, TRANSFORM_END, SWITCH_START, SWITCH_END, ELSE, ELSE_IF, BREAK, SIMPLE_RETURN, HALT, FLUSH, TRIM, LTRIM, RTRIM, NOTRIM, DEFAULT, SIMPLE_NESTED, NESTED, SIMPLE_RECURSE, RECURSE, FALLBACK, ESCAPE_START, ESCAPE_END, NOESCAPE_START, NOESCAPE_END, FTL_HEADER, TRIVIAL_FTL_HEADER, CASE, INCLUDE, IMPORT, VISIT, STOP, RETURN, CALL, SETTING, EMPTY_DIRECTIVE_END, // "/]" as a directive closing symbol
			DIRECTIVE_END, // "]" as a directive closing symbol
			OUTPUT_ESCAPE, NUMERICAL_ESCAPE, EVALUATION_END);

	TokenSet IDENTIFIER_SET = TokenSet.create(ID);

	TokenSet UNIFIED_CALL_SET = TokenSet.create(UNIFIED_CALL, UNIFIED_CALL_END);

	TokenSet UNKNOWN_DIRECTIVE_SET = TokenSet.create(UNKNOWN_DIRECTIVE);

	TokenSet BAD_SET = TokenSet.create(BAD_CHARACTER);

	TokenSet WHITESPACE_SET = TokenSet.create(WHITESPACE);

	TokenSet STRING_SET = TokenSet.create(STRING_LITERAL);

}
