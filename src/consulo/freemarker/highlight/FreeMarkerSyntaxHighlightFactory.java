package consulo.freemarker.highlight;

import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerSyntaxHighlightFactory extends SingleLazyInstanceSyntaxHighlighterFactory
{
	@NotNull
	@Override
	protected SyntaxHighlighter createHighlighter()
	{
		return new FreeMarkerHighlighter();
	}
}
