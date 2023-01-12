package consulo.freemarker.lang;

import consulo.language.Language;
import consulo.language.template.TemplateLanguage;

/**
 * User: Max
 * Date: 21.04.2007
 * Time: 16:46:53
 */
public class FreeMarkerLanguage extends Language implements TemplateLanguage
{
	public static FreeMarkerLanguage INSTANCE = new FreeMarkerLanguage();

	protected FreeMarkerLanguage()
	{
		super("FREE-MARKER");
	}
}
