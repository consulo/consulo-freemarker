package consulo.freemarker.lang.lexer;

import consulo.language.ast.TokenSet;
import consulo.language.lexer.MergingLexerAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 26.04.2007
 * Time: 0:57:20
 */
public class FreeMarkerMergingLexer extends MergingLexerAdapter
{
	private static final TokenSet mergeMe = TokenSet.create(FreeMarkerTokenTypes.ALPHA);

	public FreeMarkerMergingLexer()
	{
		super(new _FreeMarkerLexer(), mergeMe);
	}
}
