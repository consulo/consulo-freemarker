package consulo.freemarker.lang;

import javax.annotation.Nonnull;

import consulo.freemarker.lang.lexer.FreeMarkerMergingLexer;
import consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;
import consulo.freemarker.lang.psi.FreeMarkerElementTypes;
import consulo.freemarker.lang.psi.FreeMarkerFile;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 01.05.2007
 * Time: 23:52:03
 */
public class FreeMarkerParserDefinition implements ParserDefinition
{
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
