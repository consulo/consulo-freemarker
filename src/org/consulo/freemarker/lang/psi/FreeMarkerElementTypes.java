package org.consulo.freemarker.lang.psi;

import org.consulo.freemarker.lang.FreeMarkerLanguage;
import org.consulo.freemarker.lang.lexer.FreeMarkerTokenTypes;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;

/**
 * User: Max
 * Date: 21.04.2007
 * Time: 17:40:43
 */
public interface FreeMarkerElementTypes extends FreeMarkerTokenTypes
{
	IFileElementType FILE = new IFileElementType(FreeMarkerLanguage.INSTANCE);

	IElementType OUTER_ELEMENT_TYPE = new IElementType("FREE-MARKER_FRAGMENT", FreeMarkerLanguage.INSTANCE);

	FreeMarkerElementType TEMPLATE_TEXT = new FreeMarkerElementType("TEMPLATE_TEXT");

	TemplateDataElementType TEMPLATE_DATA = new TemplateDataElementType("VTL_TEMPLATE_DATA", FreeMarkerLanguage.INSTANCE, TEMPLATE_TEXT, OUTER_ELEMENT_TYPE);
}
