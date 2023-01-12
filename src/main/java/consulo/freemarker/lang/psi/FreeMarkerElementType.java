package consulo.freemarker.lang.psi;

import consulo.freemarker.lang.FreeMarkerLanguage;
import consulo.language.ast.IElementType;
import org.jetbrains.annotations.NonNls;

/**
 * User: Max
 * Date: 21.04.2007
 * Time: 17:43:35
 */
public class FreeMarkerElementType extends IElementType
{
	public FreeMarkerElementType(@NonNls String debugName)
	{
		super(debugName, FreeMarkerLanguage.INSTANCE);
	}
}
