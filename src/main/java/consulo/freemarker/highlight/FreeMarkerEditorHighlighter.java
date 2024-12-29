package consulo.freemarker.highlight;

import consulo.colorScheme.EditorColorsScheme;
import consulo.colorScheme.TextAttributesKey;
import consulo.freemarker.lang.psi.FreeMarkerElementTypes;
import consulo.language.ast.IElementType;
import consulo.language.editor.highlight.LayerDescriptor;
import consulo.language.editor.highlight.LayeredLexerEditorHighlighter;
import consulo.language.editor.highlight.SyntaxHighlighter;
import consulo.language.editor.highlight.SyntaxHighlighterFactory;
import consulo.language.lexer.Lexer;
import consulo.project.Project;
import consulo.virtualFileSystem.VirtualFile;
import consulo.xml.ide.highlighter.HtmlFileType;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerEditorHighlighter extends LayeredLexerEditorHighlighter
{

	public FreeMarkerEditorHighlighter(@Nullable Project project, @Nullable final VirtualFile virtualFile, @Nonnull final EditorColorsScheme colors)
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
