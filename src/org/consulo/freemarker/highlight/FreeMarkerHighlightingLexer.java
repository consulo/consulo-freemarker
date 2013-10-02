package org.consulo.freemarker.highlight;

import org.consulo.freemarker.lang.lexer.FreeMarkerMergingLexer;
import com.intellij.lexer.LayeredLexer;

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