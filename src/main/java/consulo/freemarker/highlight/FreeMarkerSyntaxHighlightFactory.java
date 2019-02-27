package consulo.freemarker.highlight;

import javax.annotation.Nonnull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerSyntaxHighlightFactory extends SingleLazyInstanceSyntaxHighlighterFactory
{
	@Nonnull
	@Override
	protected SyntaxHighlighter createHighlighter()
	{
		return new FreeMarkerHighlighter();
	}
}
