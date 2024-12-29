package consulo.freemarker.lang;

import consulo.annotation.component.ExtensionImpl;
import consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;
import consulo.language.BracePair;
import consulo.language.Language;
import consulo.language.PairedBraceMatcher;

import jakarta.annotation.Nonnull;

/**
 * User: Max
 * Date: 09.05.2007
 * Time: 23:05:36
 */
@ExtensionImpl
public class FreeMarkerBraceMatcher implements PairedBraceMatcher
{
	public static BracePair[] pairs = new BracePair[]{
			new BracePair(FreeMarkerTokenTypes.OPEN_PAREN, FreeMarkerTokenTypes.CLOSE_PAREN, false),
			new BracePair(FreeMarkerTokenTypes.OPEN_BRACKET, FreeMarkerTokenTypes.CLOSE_BRACKET, false),
			new BracePair(FreeMarkerTokenTypes.OPEN_BRACE, FreeMarkerTokenTypes.CLOSE_BRACE, false)
	};

	public BracePair[] getPairs()
	{
		return pairs;
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return FreeMarkerLanguage.INSTANCE;
	}
}
