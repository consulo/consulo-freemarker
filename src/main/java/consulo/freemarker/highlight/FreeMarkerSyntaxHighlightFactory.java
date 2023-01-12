package consulo.freemarker.highlight;

import consulo.annotation.component.ExtensionImpl;
import consulo.freemarker.lang.FreeMarkerLanguage;
import consulo.language.Language;
import consulo.language.editor.highlight.SingleLazyInstanceSyntaxHighlighterFactory;
import consulo.language.editor.highlight.SyntaxHighlighter;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
@ExtensionImpl
public class FreeMarkerSyntaxHighlightFactory extends SingleLazyInstanceSyntaxHighlighterFactory
{
	@Nonnull
	@Override
	protected SyntaxHighlighter createHighlighter()
	{
		return new FreeMarkerHighlighter();
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return FreeMarkerLanguage.INSTANCE;
	}
}
