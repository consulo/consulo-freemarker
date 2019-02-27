package consulo.freemarker.lang.psi;

import javax.annotation.Nonnull;

import consulo.freemarker.FreeMarkerFileType;
import consulo.freemarker.lang.FreeMarkerLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerFile extends PsiFileBase
{
	public FreeMarkerFile(@Nonnull FileViewProvider viewProvider)
	{
		super(viewProvider, FreeMarkerLanguage.INSTANCE);
	}

	@Nonnull
	@Override
	public FileType getFileType()
	{
		return FreeMarkerFileType.INSTANCE;
	}
}
