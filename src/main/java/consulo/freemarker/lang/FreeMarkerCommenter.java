package consulo.freemarker.lang;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Commenter;
import consulo.language.Language;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * User: Max
 * Date: 09.05.2007
 * Time: 22:07:01
 */
@ExtensionImpl
public class FreeMarkerCommenter implements Commenter
{
	@Nullable
	public String getLineCommentPrefix()
	{
		return null;
	}

	@Nullable
	public String getBlockCommentPrefix()
	{
		return "[#--";
	}

	@Nullable
	public String getBlockCommentSuffix()
	{
		return "--]";
	}

	@Nullable
	@Override
	public String getCommentedBlockCommentPrefix()
	{
		return null;
	}

	@Nullable
	@Override
	public String getCommentedBlockCommentSuffix()
	{
		return null;
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return FreeMarkerLanguage.INSTANCE;
	}
}
