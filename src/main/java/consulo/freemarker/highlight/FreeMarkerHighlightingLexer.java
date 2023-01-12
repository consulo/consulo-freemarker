package consulo.freemarker.highlight;

import consulo.freemarker.lang.lexer.FreeMarkerMergingLexer;
import consulo.language.lexer.LayeredLexer;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 26.04.2007
 * Time: 0:57:20
 */
public class FreeMarkerHighlightingLexer extends LayeredLexer
{
	public FreeMarkerHighlightingLexer()
	{
		super(new FreeMarkerMergingLexer());
	}
}