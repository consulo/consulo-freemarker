package consulo.freemarker;

import consulo.freemarker.icon.FreeMarkerIconGroup;
import consulo.freemarker.lang.FreeMarkerLanguage;
import consulo.language.file.LanguageFileType;
import consulo.localize.LocalizeValue;
import consulo.ui.image.Image;
import org.jetbrains.annotations.NonNls;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * User: Max
 * Date: 21.04.2007
 * Time: 14:36:31
 */
public class FreeMarkerFileType extends LanguageFileType
{
	public static final FreeMarkerFileType INSTANCE = new FreeMarkerFileType();

	protected FreeMarkerFileType()
	{
		super(FreeMarkerLanguage.INSTANCE);
	}

	@Nonnull
	@NonNls
	public String getId()
	{
		return "FREE-MARKER";
	}

	@Nonnull
	public LocalizeValue getDescription()
	{
		return LocalizeValue.localizeTODO("FreeMarker template");
	}

	@Nonnull
	@NonNls
	public String getDefaultExtension()
	{
		return "ftl";
	}

	@Nullable
	public Image getIcon()
	{
		return FreeMarkerIconGroup.freemarker();
	}
}


