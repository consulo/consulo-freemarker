package consulo.freemarker.lang.lexer;

import consulo.codeEditor.DefaultLanguageHighlighterColors;
import consulo.codeEditor.HighlighterColors;
import consulo.colorScheme.TextAttributesKey;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public interface FreeMarkerHighlighterKeys
{
	TextAttributesKey INSTRUCTION_TAG = TextAttributesKey.createTextAttributesKey("FREE-MARKER_INSTRUCTION_TAG", DefaultLanguageHighlighterColors.KEYWORD);

	TextAttributesKey COMMENTS = TextAttributesKey.createTextAttributesKey("FREE-MARKER_COMMENTS", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

	TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("FREE-MARKER_BADCHARACTER", HighlighterColors.BAD_CHARACTER);

	TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("FREE-MARKER_STRING", DefaultLanguageHighlighterColors.STRING);

	TextAttributesKey ID = TextAttributesKey.createTextAttributesKey("FREE-MARKER_ID", DefaultLanguageHighlighterColors.MARKUP_TAG);
}
