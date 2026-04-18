/**
 * @author VISTALL
 * @since 12/01/2023
 */
module consulo.freemarker
{
	requires consulo.code.editor.api;
	requires consulo.color.scheme.api;
	requires consulo.language.api;
	requires consulo.language.editor.api;
	requires consulo.language.impl;
	requires consulo.localize.api;
	requires consulo.project.api;
	requires consulo.ui.api;
	requires consulo.virtual.file.system.api;

	requires com.intellij.xml.html.api;

	exports consulo.freemarker;
	exports consulo.freemarker.highlight;
	exports consulo.freemarker.icon;
	exports consulo.freemarker.lang;
	exports consulo.freemarker.lang.lexer;
	exports consulo.freemarker.lang.psi;
}
