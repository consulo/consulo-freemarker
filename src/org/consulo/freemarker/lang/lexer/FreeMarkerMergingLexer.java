package org.consulo.freemarker.lang.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;

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
		super(new FlexAdapter(new _FreeMarkerLexer()), mergeMe);
	}
}
