package consulo.freemarker.lang;

import javax.annotation.Nonnull;

import consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;

import javax.annotation.Nullable;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

/**
 * User: Max
 * Date: 09.05.2007
 * Time: 23:05:36
 */
public class FreeMarkerBraceMatcher implements PairedBraceMatcher
{

	public static BracePair[] pairs = new BracePair[]{
			new BracePair(FreeMarkerTokenTypes.OPEN_PAREN, FreeMarkerTokenTypes.CLOSE_PAREN, false),
			new BracePair(FreeMarkerTokenTypes.OPEN_BRACKET, FreeMarkerTokenTypes.CLOSE_BRACKET, false),
			new BracePair(FreeMarkerTokenTypes.OPEN_BRACE, FreeMarkerTokenTypes.CLOSE_BRACE, false)
	};

	public boolean isPairedBracesAllowedBeforeType(@Nonnull IElementType lbraceType, @Nullable IElementType contextType)
	{
		return true;
	}

	@Override
	public int getCodeConstructStart(PsiFile psiFile, int i)
	{
		return i;
	}

	public BracePair[] getPairs()
	{
		return pairs;
	}
}
