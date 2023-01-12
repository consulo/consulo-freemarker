package consulo.freemarker.lang;

import consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;
import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementType;
import consulo.language.parser.PsiBuilder;
import consulo.language.parser.PsiParser;
import consulo.language.version.LanguageVersion;

import javax.annotation.Nonnull;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 09.05.2007
 * Time: 2:42:03
 */
public class FreeMarkerParser implements PsiParser
{
	@Nonnull
	public ASTNode parse(IElementType root, PsiBuilder builder, LanguageVersion languageVersion)
	{
		builder.setDebugMode(true);
		final PsiBuilder.Marker rootMarker = builder.mark();
		while(!builder.eof())
		{
			parseSource(builder);
		}
		rootMarker.done(root);
		return builder.getTreeBuilt();
	}

	private static void parseSource(PsiBuilder builder)
	{
		IElementType tt = builder.getTokenType();

		if(tt == FreeMarkerTokenTypes.ALPHA)
		{
			final PsiBuilder.Marker m = builder.mark();
			builder.advanceLexer();
			m.done(FreeMarkerTokenTypes.ALPHA);
		}
		//        if (tt == FMTokenTypes.MACRO_START) {
		//            parseMacroDefinition(builder);
		//        } else if (tt == FMTokenTypes.UNKNOWN_DIRECTIVE) {
		//            parseUnknownDirective(builder);
		//        } else if (tt == FMTokenTypes.UNIFIED_CALL){
		//            parseUnifiedCall(builder);
		//        }else{
		//            builder.advanceLexer();
		//        }
		builder.advanceLexer();
	}

	private static void parseUnifiedCall(PsiBuilder builder)
	{
		final PsiBuilder.Marker m = builder.mark();
		builder.advanceLexer();
		builder.advanceLexer();
		builder.advanceLexer();
		m.done(FreeMarkerTokenTypes.UNIFIED_CALL);
	}

	private static void parseUnknownDirective(PsiBuilder builder)
	{
		final PsiBuilder.Marker bad = builder.mark();
		String text = builder.getTokenText();
		builder.advanceLexer();
		bad.done(FreeMarkerTokenTypes.UNKNOWN_DIRECTIVE);
	}


	private static void parseMacroDefinition(PsiBuilder builder)
	{
		final PsiBuilder.Marker macroStart = builder.mark();
		builder.advanceLexer();
		/** expecting macro identifier */
		if(builder.getTokenType() == FreeMarkerTokenTypes.ID)
		{
			builder.advanceLexer();
		}
		else
		{
			macroStart.done(FreeMarkerTokenTypes.MACRO_START);
			builder.error("Macro identifier expected");
		}
		parseMacroParametersDeclaration(builder);

		macroStart.done(FreeMarkerTokenTypes.MACRO_START);

	}

	private static void parseMacroParametersDeclaration(PsiBuilder builder)
	{
		builder.advanceLexer();
		while(builder.getTokenType() != FreeMarkerTokenTypes.DIRECTIVE_END)
		{
			if(builder.eof())
			{
				builder.error("Unexpected end of file");
				return;
			}
			builder.advanceLexer();
		}
		builder.advanceLexer();
	}

}
