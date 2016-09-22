package org.consulo.freemarker.lang;

import org.consulo.freemarker.lang.lexer.FreeMarkerMergingLexer;
import org.consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;
import org.consulo.freemarker.lang.psi.FreeMarkerElementTypes;
import org.consulo.freemarker.lang.psi.FreeMarkerFile;
import org.jetbrains.annotations.NotNull;
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
	@NotNull
	public Lexer createLexer(@NotNull LanguageVersion languageVersion)
	{
		return new FreeMarkerMergingLexer();
	}

	@NotNull
	public PsiParser createParser(@NotNull LanguageVersion languageVersion)
	{
		return new FreeMarkerParser();
	}

	@NotNull
	public IFileElementType getFileNodeType()
	{
		return FreeMarkerElementTypes.FILE;
	}

	@NotNull
	public TokenSet getWhitespaceTokens(@NotNull LanguageVersion languageVersion)
	{
		return FreeMarkerTokenTypes.WHITESPACE_SET;
	}

	@NotNull
	public TokenSet getCommentTokens(@NotNull LanguageVersion languageVersion)
	{
		return FreeMarkerTokenTypes.COMMENTS_SET;
	}

	@NotNull
	@Override
	public TokenSet getStringLiteralElements(@NotNull LanguageVersion languageVersion)
	{
		return FreeMarkerTokenTypes.STRING_SET;
	}

	@NotNull
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
