package org.consulo.freemarker.lang;

import org.jetbrains.annotations.Nullable;
import com.intellij.lang.Commenter;

/**
 * User: Max
 * Date: 09.05.2007
 * Time: 22:07:01
 */
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
}
