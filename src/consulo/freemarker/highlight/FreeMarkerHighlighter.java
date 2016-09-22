package consulo.freemarker.highlight;

import java.util.HashMap;

import org.jetbrains.annotations.NotNull;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import consulo.freemarker.lang.lexer.FreeMarkerHighlighterKeys;
import consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;

/**
 * User: Max
 * Date: 21.04.2007
 * Time: 18:58:33
 */
public class FreeMarkerHighlighter extends SyntaxHighlighterBase
{
	static HashMap<IElementType, TextAttributesKey> keys = new HashMap<IElementType, TextAttributesKey>();

	static
	{
		safeMap(keys, FreeMarkerTokenTypes.KEYWORDS_SET, FreeMarkerHighlighterKeys.INSTRUCTION_TAG);
		safeMap(keys, FreeMarkerTokenTypes.UNIFIED_CALL_SET, FreeMarkerHighlighterKeys.INSTRUCTION_TAG);
		safeMap(keys, FreeMarkerTokenTypes.UNKNOWN_DIRECTIVE_SET, FreeMarkerHighlighterKeys.INSTRUCTION_TAG);
		safeMap(keys, FreeMarkerTokenTypes.COMMENTS_SET, FreeMarkerHighlighterKeys.COMMENTS);
		safeMap(keys, FreeMarkerTokenTypes.BAD_SET, FreeMarkerHighlighterKeys.BAD_CHARACTER);
		safeMap(keys, FreeMarkerTokenTypes.STRING_SET, FreeMarkerHighlighterKeys.STRING);
		safeMap(keys, FreeMarkerTokenTypes.IDENTIFIER_SET, FreeMarkerHighlighterKeys.ID);
	}

	@NotNull
	public Lexer getHighlightingLexer()
	{
		return new FreeMarkerHighlightingLexer();
	}

	@NotNull
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
	{
		return new TextAttributesKey[]{keys.get(tokenType)};
	}
}
