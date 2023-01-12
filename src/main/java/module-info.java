/**
 * @author VISTALL
 * @since 12/01/2023
 */
module consulo.freemarker
{
	requires consulo.ide.api;

	requires com.intellij.xml;

	exports consulo.freemarker;
	exports consulo.freemarker.highlight;
	exports consulo.freemarker.icon;
	exports consulo.freemarker.lang;
	exports consulo.freemarker.lang.lexer;
	exports consulo.freemarker.lang.psi;
}