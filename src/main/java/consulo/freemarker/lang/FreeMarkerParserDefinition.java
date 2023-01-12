package consulo.freemarker.lang;

import consulo.annotation.component.ExtensionImpl;
import consulo.freemarker.lang.lexer.FreeMarkerMergingLexer;
import consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;
import consulo.freemarker.lang.psi.FreeMarkerElementTypes;
import consulo.freemarker.lang.psi.FreeMarkerFile;
import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.ast.IFileElementType;
import consulo.language.ast.TokenSet;
import consulo.language.file.FileViewProvider;
import consulo.language.impl.psi.ASTWrapperPsiElement;
import consulo.language.lexer.Lexer;
import consulo.language.parser.ParserDefinition;
import consulo.language.parser.PsiParser;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiFile;
import consulo.language.version.LanguageVersion;

import javax.annotation.Nonnull;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 01.05.2007
 * Time: 23:52:03
 */
@ExtensionImpl
public class FreeMarkerParserDefinition implements ParserDefinition
{
	@Nonnull
	@Override
	public Language getLanguage()
	{
		return FreeMarkerLanguage.INSTANCE;
	}

	@Nonnull
	public Lexer createLexer(@Nonnull LanguageVersion languageVersion)
	{
		return new FreeMarkerMergingLexer();
	}

	@Nonnull
	public PsiParser createParser(@Nonnull LanguageVersion languageVersion)
	{
		return new FreeMarkerParser();
	}

	@Nonnull
	public IFileElementType getFileNodeType()
	{
		return FreeMarkerElementTypes.FILE;
	}

	@Nonnull
	public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion)
	{
		return FreeMarkerTokenTypes.WHITESPACE_SET;
	}

	@Nonnull
	public TokenSet getCommentTokens(@Nonnull LanguageVersion languageVersion)
	{
		return FreeMarkerTokenTypes.COMMENTS_SET;
	}

	@Nonnull
	@Override
	public TokenSet getStringLiteralElements(@Nonnull LanguageVersion languageVersion)
	{
		return FreeMarkerTokenTypes.STRING_SET;
	}

	@Nonnull
	public PsiElement createElement(ASTNode node)
	{
		return new ASTWrapperPsiElement(node);
	}

	public PsiFile createFile(FileViewProvider viewProvider)
	{
		return new FreeMarkerFile(viewProvider);
	}

	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		return SpaceRequirements.MAY;
	}

}
