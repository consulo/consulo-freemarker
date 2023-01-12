package consulo.freemarker.lang.psi;

import consulo.freemarker.FreeMarkerFileType;
import consulo.freemarker.lang.FreeMarkerLanguage;
import consulo.language.file.FileViewProvider;
import consulo.language.impl.psi.PsiFileBase;
import consulo.virtualFileSystem.fileType.FileType;

import javax.annotation.Nonnull;

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
}
