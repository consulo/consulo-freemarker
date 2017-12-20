package consulo.freemarker.lang.psi;

import org.jetbrains.annotations.NonNls;
import com.intellij.psi.tree.IElementType;
import consulo.freemarker.lang.FreeMarkerLanguage;

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
