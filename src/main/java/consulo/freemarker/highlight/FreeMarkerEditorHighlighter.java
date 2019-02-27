package consulo.freemarker.highlight;

import javax.annotation.Nonnull;

import consulo.freemarker.lang.psi.FreeMarkerElementTypes;

import javax.annotation.Nullable;
import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.ex.util.LayerDescriptor;
import com.intellij.openapi.editor.ex.util.LayeredLexerEditorHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.psi.tree.IElementType;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerEditorHighlighter extends LayeredLexerEditorHighlighter
{

	public FreeMarkerEditorHighlighter(@Nullable final com.intellij.openapi.project.Project project, @Nullable final com.intellij.openapi.vfs.VirtualFile virtualFile, @Nonnull final EditorColorsScheme colors)
	{
		super(new FreeMarkerHighlighter(), colors);
		final SyntaxHighlighter highlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(HtmlFileType.INSTANCE, project, virtualFile);

		assert highlighter != null;

		registerLayer(FreeMarkerElementTypes.TEMPLATE_TEXT, new LayerDescriptor(new SyntaxHighlighter()
		{
			@Nonnull
			public Lexer getHighlightingLexer()
			{
				return highlighter.getHighlightingLexer();
			}

			@Nonnull
			public TextAttributesKey[] getTokenHighlights(final IElementType tokenType)
			{
				return highlighter.getTokenHighlights(tokenType);
			}
		}, ""));
	}
}
